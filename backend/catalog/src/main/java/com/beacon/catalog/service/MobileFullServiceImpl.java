package com.beacon.catalog.service;

import com.beacon.catalog.dao.MobileFullDao;
import com.beacon.model.MobileFull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Default implementation of {@link MobileFullService}
 */
@Service
@Transactional
public class MobileFullServiceImpl implements MobileFullService {

    private MobileFullDao mobileFullDao;

    public MobileFullServiceImpl(MobileFullDao mobileFullDao) {
        this.mobileFullDao = mobileFullDao;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<MobileFull> findMobileFullById(String mobileId) {
        return mobileFullDao.findById(mobileId);
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

    private void validateProperties(MobileFull mobileDtoFull) {
        if (!mobileDtoFull.getMainCameraAperture().startsWith("f/")) {
            mobileDtoFull.setMainCameraAperture("f/" + mobileDtoFull.getMainCameraAperture());
        }
        if (!mobileDtoFull.getFrontCameraAperture().startsWith("f/")) {
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
