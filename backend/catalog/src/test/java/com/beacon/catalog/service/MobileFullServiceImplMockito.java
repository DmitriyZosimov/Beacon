package com.beacon.catalog.service;

import com.beacon.catalog.TestMobileFullBuilder;
import com.beacon.catalog.dao.MobileFullDao;
import com.beacon.model.MobileFull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MobileFullServiceImplMockito implements TestMobileFullBuilder {

    @InjectMocks
    MobileFullServiceImpl service;
    @Mock
    MobileFullDao dao;

    @Test
    public void checkValidationOfMainAndFrontApertureCameras_shouldInsertSlashFAtTheBeginning() {
        MobileFull mobile = build();
        mobile.setMainCameraAperture("1.8");
        mobile.setFrontCameraAperture("1.8");

        when(dao.saveAndFlush(any())).thenAnswer(invocation -> {
            MobileFull argument = invocation.getArgument(0, MobileFull.class);
            Assertions.assertTrue(argument.getMainCameraAperture().startsWith("f/"));
            Assertions.assertTrue(argument.getFrontCameraAperture().startsWith("f/"));
            return null;
        });
        service.saveMobileFull(mobile);
    }

    @Test
    public void testValidationOfImages() {
        when(dao.saveAndFlush(any())).thenAnswer(invocation -> {
            MobileFull argument = invocation.getArgument(0, MobileFull.class);
            Assertions.assertEquals(argument, argument.getMainImage().getMobile());
            argument.getNotMainImages().forEach(image -> {
                Assertions.assertEquals(argument, image.getMobileFull());
            });
            return null;
        });

        MobileFull mobileFull = build();
        mobileFull.setMobileId(null);
        mobileFull.getMainImage().setMobile(null);
        mobileFull.getNotMainImages().forEach(image -> image.setMobileFull(null));

        service.saveMobileFull(mobileFull);
    }
}
