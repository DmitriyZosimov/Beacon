package com.beacon.catalog.service;

import com.beacon.catalog.dao.MobileFullDao;
import com.beacon.catalog.dao.MobileImageDao;
import com.beacon.catalog.dao.OrderDao;
import com.beacon.model.MobileFull;
import com.beacon.model.MobileHelpers;
import com.beacon.model.order.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Default implementation of {@link MobileFullService}
 */
@Service
@Transactional
public class MobileFullServiceImpl implements MobileFullService {

    private MobileFullDao mobileFullDao;
    private MobileImageDao mobileImageDao;
    private OrderDao orderDao;

    public MobileFullServiceImpl(MobileFullDao mobileFullDao, MobileImageDao imageDao, OrderDao orderDao) {
        this.mobileFullDao = mobileFullDao;
        this.mobileImageDao = imageDao;
        this.orderDao = orderDao;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<MobileFull> findMobileFullById(String mobileId) {
        return mobileFullDao.findByMobileId(mobileId);
    }

    @Override
    public MobileFull saveMobileFull(MobileFull mobileDtoFull) {
        if (mobileDtoFull.getMobileId() == null) {
            generateMobileId(mobileDtoFull);
        }
        validateProperties(mobileDtoFull);
        validateImages(mobileDtoFull);
        return mobileFullDao.saveAndFlush(mobileDtoFull);
    }

    @Override
    public void deleteMobileFullById(String id) {
        replaceOrderByRemoved(List.of(id));
        mobileImageDao.deleteByMobileIdentifier(id);
        mobileFullDao.deleteByMobileId(id);
    }

    @Override
    public void deleteMobileFullInBatch(Iterable<String> ids) {
        mobileImageDao.deleteBulkByIdentifiers(ids);
        mobileFullDao.deleteBulkOffersByMobileIdentifiers(ids);
        replaceOrderByRemoved(ids);
        mobileFullDao.deleteBulkMobileFullByIdentifiers(ids);
    }

    private void replaceOrderByRemoved(Iterable<String> ids) {
        MobileFull removedMobile = mobileFullDao.getReferenceById(MobileHelpers.REMOVED.getId());
        if (removedMobile != null) {
            List<Order> orders = orderDao.findAllByMobileIdIn(ids);
            List<Order> updatedOrders = orders.parallelStream().peek(order -> order.setMobile(removedMobile)).collect(Collectors.toList());
            orderDao.deleteAllByMobileIdIn(ids);
            orderDao.saveAll(updatedOrders);
        } else {
            orderDao.deleteAllByMobileIdIn(ids);
        }
    }

    private void validateProperties(MobileFull mobileDtoFull) {
        if (mobileDtoFull.getMainCameraAperture() != null &&
                !mobileDtoFull.getMainCameraAperture().startsWith("f/")) {
            mobileDtoFull.setMainCameraAperture("f/" + mobileDtoFull.getMainCameraAperture());
        }
        if (mobileDtoFull.getFrontCameraAperture() != null &&
                !mobileDtoFull.getFrontCameraAperture().startsWith("f/")) {
            mobileDtoFull.setFrontCameraAperture("f/" + mobileDtoFull.getFrontCameraAperture());
        }
    }

    private void validateImages(MobileFull mobileDtoFull) {
        if (mobileDtoFull.getMainImage() != null && !mobileDtoFull.equals(mobileDtoFull.getMainImage().getMobile())) {
            mobileDtoFull.getMainImage().setMobile(mobileDtoFull);
        }
        if (mobileDtoFull.getNotMainImages() != null) {
            mobileDtoFull.getNotMainImages().stream().filter(image -> !mobileDtoFull.equals(image.getMobileFull()))
                    .forEach(image -> image.setMobileFull(mobileDtoFull));
        }
    }
}
