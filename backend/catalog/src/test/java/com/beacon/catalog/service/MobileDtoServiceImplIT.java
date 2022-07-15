package com.beacon.catalog.service;

import com.beacon.model.MobileDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MobileDtoServiceImplIT {

    @Autowired
    MobileDtoService mobileDtoService;

    @Test
    public void findAllMobileDto() {
        List<MobileDto> list = mobileDtoService.findAllMobileDtos();
        Assertions.assertNotNull(list);
        //if it doesn't pass, see import.sql
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("honor508128black", list.get(0).getMobileId());
        Assertions.assertEquals("honor", list.get(0).getBrand());
        Assertions.assertEquals("50", list.get(0).getModel());
        Assertions.assertEquals("pocox3pro8256green", list.get(1).getMobileId());
        Assertions.assertEquals("green", list.get(1).getColor());
        Assertions.assertEquals(MobileDto.class, list.get(0).getClass());
        System.out.println(list.get(0).toString());
        System.out.println(list.get(1).toString());
    }

}
