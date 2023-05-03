package com.beacon.catalog.service;

import com.beacon.model.MobileHelpers;
import com.beacon.model.dtos.MobileDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class MobileServiceImplIT {

    /**
     * As the {@code SpringBootTest} loads all configuration and the application uses security configuration with JWT
     * and this tests do not load checking security configuration but only control the application, we should mock the
     * {@code JwtDecoder}. Without this simple step the test will not pass.
     */
    @MockBean
    JwtDecoder jwtDecoder;
    @Autowired
    MobileService mobileService;

    @Test
    public void findAllMobile() {
        List<MobileDto> list = mobileService.findAllMobileDtos();
        Assertions.assertNotNull(list);
        //if it doesn't pass, see import.sql
        // Also check release_years. First goes the newest phone.
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("pocox3pro8256green", list.get(0).getMobileId());
        Assertions.assertEquals("green", list.get(0).getColor());
        Assertions.assertEquals(MobileDto.class, list.get(0).getClass());
        Assertions.assertEquals("honor508128black", list.get(1).getMobileId());
        Assertions.assertEquals("honor", list.get(1).getBrand());
        Assertions.assertEquals("50", list.get(1).getModel());
        Assertions.assertEquals(MobileDto.class, list.get(1).getClass());
        System.out.println(list.get(0).toString());
        System.out.println(list.get(1).toString());

        list.forEach(dto -> {
            if (!dto.getMobileId().equals(MobileHelpers.REMOVED.getId())) {
                Assertions.assertNotNull(dto.getCountOfOffers());
                Assertions.assertNotNull(dto.getMinimalPrice());
            }
        });
    }

}
