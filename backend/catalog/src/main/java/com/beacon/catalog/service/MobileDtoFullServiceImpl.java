package com.beacon.catalog.service;

import com.beacon.catalog.dao.MobileDtoFullDao;
import com.beacon.model.MobileDtoFull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.StringJoiner;

/**
 * Default implementation of {@link MobileDtoFullService}
 */
@Service
@Transactional
public class MobileDtoFullServiceImpl implements MobileDtoFullService {

    private MobileDtoFullDao mobileDtoFullDao;

    public MobileDtoFullServiceImpl(MobileDtoFullDao mobileDtoFullDao) {
        this.mobileDtoFullDao = mobileDtoFullDao;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<MobileDtoFull> findMobileDtoFullById(String mobileId) {
        return mobileDtoFullDao.findById(mobileId);
    }

    @Override
    public MobileDtoFull saveMobileDtoFull(MobileDtoFull mobileDtoFull) {
        if (mobileDtoFull.getMobileId() == null) {
            generateMobileId(mobileDtoFull);
        }
        validateProperties(mobileDtoFull);
        validateImages(mobileDtoFull);
        return mobileDtoFullDao.saveAndFlush(mobileDtoFull);
    }

    private void validateProperties(MobileDtoFull mobileDtoFull) {
        if (!mobileDtoFull.getMainCameraAperture().startsWith("f/")) {
            mobileDtoFull.setMainCameraAperture("f/" + mobileDtoFull.getMainCameraAperture());
        }
        if (!mobileDtoFull.getFrontCameraAperture().startsWith("f/")) {
            mobileDtoFull.setFrontCameraAperture("f/" + mobileDtoFull.getFrontCameraAperture());
        }
    }

    private void validateImages(MobileDtoFull mobileDtoFull) {
        if (mobileDtoFull.getMainImage() != null && !mobileDtoFull.equals(mobileDtoFull.getMainImage().getMobileDto())) {
            mobileDtoFull.getMainImage().setMobileDto(mobileDtoFull);
        }
        if (mobileDtoFull.getNotMainImages() != null) {
            mobileDtoFull.getNotMainImages().stream().filter(image -> !mobileDtoFull.equals(image.getMobileDtoFull()))
                    .forEach(image -> image.setMobileDtoFull(mobileDtoFull));
        }
    }
}
