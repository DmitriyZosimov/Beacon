package com.beacon.catalog.service;

import com.beacon.catalog.TestMobileDtoFulBuilder;
import com.beacon.model.MobileDtoFull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
public class MobileDtoFullServiceImplIT implements TestMobileDtoFulBuilder {

    /**
     * As the {@code SpringBootTest} loads all configuration and the application uses security configuration with JWT
     * and this tests do not load checking security configuration but only control the application, we should mock the
     * {@code JwtDecoder}. Without this simple step the test will not pass.
     */
    @MockBean
    JwtDecoder jwtDecoder;
    @Autowired
    MobileDtoFullService mobileDtoFullService;

    @Test
    public void findMobileDtoFullById() {
        Optional<MobileDtoFull> optionalMobileDtoFull = mobileDtoFullService.findMobileDtoFullById("honor508128black");
        Assertions.assertTrue(optionalMobileDtoFull.isPresent());
        //if it doesn't pass, see import.sql
        Assertions.assertEquals("honor508128black", optionalMobileDtoFull.get().getMobileId());
        Assertions.assertEquals("honor", optionalMobileDtoFull.get().getBrand());
        Assertions.assertEquals("50", optionalMobileDtoFull.get().getModel());
        Assertions.assertEquals(MobileDtoFull.class, optionalMobileDtoFull.get().getClass());
        System.out.println(optionalMobileDtoFull.get().toString());
    }

    @Test
    public void doesntFindAnyMobileDtoFullById_returnEmpty() {
        Optional<MobileDtoFull> optionalMobileDtoFull = mobileDtoFullService.findMobileDtoFullById("1");
        Assertions.assertTrue(optionalMobileDtoFull.isEmpty());
    }

    @DirtiesContext
    @Test
    public void testOfSavingNewMobileDtoFull() {
        MobileDtoFull mobileDtoFull = build();
        mobileDtoFull.setMobileId(null);
        mobileDtoFull.getMainImage().setMobileDto(null);
        mobileDtoFull.getNotMainImages().forEach(image -> image.setMobileDtoFull(null));
        MobileDtoFull saved = mobileDtoFullService.saveMobileDtoFull(mobileDtoFull);
        Assertions.assertNotNull(saved.getMainImage().getImageId());
        Assertions.assertEquals(saved, saved.getMainImage().getMobileDto());
        saved.getNotMainImages().forEach(image -> {
            Assertions.assertNotNull(image.getImageId());
            Assertions.assertEquals(saved, image.getMobileDtoFull());
        });
    }
}
