package com.beacon.catalog.service;

import com.beacon.catalog.TestMobileFullBuilder;
import com.beacon.catalog.dao.MobileImageDao;
import com.beacon.catalog.dao.OrderDao;
import com.beacon.model.MobileFull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest
@Transactional
public class MobileFullServiceImplIT implements TestMobileFullBuilder {

    /**
     * As the {@code SpringBootTest} loads all configuration and the application uses security configuration with JWT
     * and this tests do not load checking security configuration but only control the application, we should mock the
     * {@code JwtDecoder}. Without this simple step the test will not pass.
     */
    @MockBean
    JwtDecoder jwtDecoder;
    @Autowired
    MobileFullService mobileFullService;

    @Autowired
    MobileImageDao mobileImageDao;

    @Autowired
    OrderDao orderDao;

    @Test
    public void findMobileFullById() {
        Optional<MobileFull> optionalMobileFull = mobileFullService.findMobileFullById("honor508128black");
        Assertions.assertTrue(optionalMobileFull.isPresent());
        //if it doesn't pass, see import.sql
        Assertions.assertEquals("honor508128black", optionalMobileFull.get().getMobileId());
        Assertions.assertEquals("honor", optionalMobileFull.get().getBrand());
        Assertions.assertEquals("50", optionalMobileFull.get().getModel());
        Assertions.assertEquals(MobileFull.class, optionalMobileFull.get().getClass());
        System.out.println(optionalMobileFull.get().toString());
    }

    @Test
    public void doesntFindAnyMobileFullById_returnEmpty() {
        Optional<MobileFull> optionalMobileFull = mobileFullService.findMobileFullById("1");
        Assertions.assertTrue(optionalMobileFull.isEmpty());
    }

    @Test
    public void testOfSavingNewMobileFull() {
        MobileFull mobileFull = build();
        mobileFull.setMobileId(null);
        mobileFull.getMainImage().setMobile(null);
        mobileFull.getNotMainImages().forEach(image -> image.setMobileFull(null));
        MobileFull saved = mobileFullService.saveMobileFull(mobileFull);
        Assertions.assertNotNull(saved.getMainImage().getImageId());
        Assertions.assertEquals(saved, saved.getMainImage().getMobile());
        saved.getNotMainImages().forEach(image -> {
            Assertions.assertNotNull(image.getImageId());
            Assertions.assertEquals(saved, image.getMobileFull());
        });
    }

    @Test
    public void deleteMobileFullById() {
        String mobileId = "honor508128black";
        MobileFull mobileFull = mobileFullService.findMobileFullById(mobileId).get();
        mobileFullService.deleteMobileFullById(mobileId);
        Assertions.assertTrue(mobileFullService.findMobileFullById(mobileId).isEmpty());

        Assertions.assertTrue(mobileImageDao.findById(mobileFull.getMainImage().getImageId()).isEmpty());
        mobileFull.getNotMainImages().forEach(image -> Assertions.assertTrue(mobileImageDao.findById(image.getImageId()).isEmpty()));

        Assertions.assertTrue(orderDao.findAllByMobileIdIn(List.of(mobileId)).isEmpty());
    }

    @Test
    public void deleteMobileFullById_WhenIdDoesNotExist() {
        String mobileId = "honor";
        Assertions.assertTrue(mobileFullService.findMobileFullById(mobileId).isEmpty());
        mobileFullService.deleteMobileFullById(mobileId);
    }

    @Test
    public void deleteMobileFullByIdInBatch() {
        List<MobileFull> mobiles = List.of(mobileFullService.findMobileFullById("honor508128black").get(),
                mobileFullService.findMobileFullById("pocox3pro8256green").get());
        mobileFullService.deleteMobileFullInBatch(mobiles.stream().map(MobileFull::getMobileId).collect(Collectors.toList()));
        mobiles.forEach(mobile -> {
            Assertions.assertTrue(mobileFullService.findMobileFullById(mobile.getMobileId()).isEmpty());
            Assertions.assertTrue(mobileImageDao.findById(mobile.getMainImage().getImageId()).isEmpty());
            mobile.getNotMainImages().forEach(image -> Assertions.assertTrue(mobileImageDao.findById(image.getImageId()).isEmpty()));

            Assertions.assertTrue(orderDao.findAllByMobileIdIn(List.of(mobile.getMobileId())).isEmpty());
        });
    }
}
