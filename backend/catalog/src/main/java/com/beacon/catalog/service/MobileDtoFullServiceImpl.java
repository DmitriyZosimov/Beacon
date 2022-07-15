package com.beacon.catalog.service;

import com.beacon.catalog.dao.MobileDtoFullDao;
import com.beacon.model.MobileDtoFull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
            mobileDtoFull.setMobileId(generateMobileId(mobileDtoFull));
        }
        validateImages(mobileDtoFull);
        return mobileDtoFullDao.saveAndFlush(mobileDtoFull);
    }

    private String generateMobileId(MobileDtoFull mobileDtoFull) {
        return mobileDtoFull.getBrand()
                .toLowerCase()
                .trim()
                .replaceAll("[+]", "plus")
                .replaceAll("[-\\s\\p{Punct}]", "")
                + mobileDtoFull.getModel().
                toLowerCase()
                .trim()
                .replaceAll("[+]", "plus")
                .replaceAll("[-\\s\\p{Punct}]", "")
                + mobileDtoFull.getRam()
                + mobileDtoFull.getStorageCapacity()
                + mobileDtoFull.getColor()
                .toLowerCase()
                .trim()
                .replaceAll("[\\s\\p{Punct}]", "");
    }

    private void validateImages(MobileDtoFull mobileDtoFull) {
        if (mobileDtoFull.getMainImage() != null && mobileDtoFull.getMainImage().getMobileDto() != mobileDtoFull) {
            mobileDtoFull.getMainImage().setMobileDto(mobileDtoFull);
        }
        if (mobileDtoFull.getNotMainImages() != null) {
            mobileDtoFull.getNotMainImages().stream().filter(image -> image.getMobileDtoFull() != mobileDtoFull)
                    .forEach(image -> image.setMobileDtoFull(mobileDtoFull));
        }
    }
}
