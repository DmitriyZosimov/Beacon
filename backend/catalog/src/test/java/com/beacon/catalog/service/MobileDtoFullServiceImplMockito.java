package com.beacon.catalog.service;

import com.beacon.catalog.TestMobileDtoFulBuilder;
import com.beacon.catalog.dao.MobileDtoFullDao;
import com.beacon.model.MobileDtoFull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MobileDtoFullServiceImplMockito implements TestMobileDtoFulBuilder {

    @InjectMocks
    MobileDtoFullServiceImpl service;
    @Mock
    MobileDtoFullDao dao;

    @Test
    public void checkValidationOfMainAndFrontApertureCameras_shouldInsertSlashFAtTheBeginning() {
        MobileDtoFull mobile = build();
        mobile.setMainCameraAperture("1.8");
        mobile.setFrontCameraAperture("1.8");

        when(dao.saveAndFlush(any())).thenAnswer(invocation -> {
            MobileDtoFull argument = invocation.getArgument(0, MobileDtoFull.class);
            Assertions.assertTrue(argument.getMainCameraAperture().startsWith("f/"));
            Assertions.assertTrue(argument.getFrontCameraAperture().startsWith("f/"));
            return null;
        });
        service.saveMobileDtoFull(mobile);
    }

    @Test
    public void testValidationOfImages() {
        when(dao.saveAndFlush(any())).thenAnswer(invocation -> {
            MobileDtoFull argument = invocation.getArgument(0, MobileDtoFull.class);
            Assertions.assertEquals(argument, argument.getMainImage().getMobileDto());
            argument.getNotMainImages().forEach(image -> {
                Assertions.assertEquals(argument, image.getMobileDtoFull());
            });
            return null;
        });

        MobileDtoFull mobileDtoFull = build();
        mobileDtoFull.setMobileId(null);
        mobileDtoFull.getMainImage().setMobileDto(null);
        mobileDtoFull.getNotMainImages().forEach(image -> image.setMobileDtoFull(null));

        service.saveMobileDtoFull(mobileDtoFull);
    }
}
