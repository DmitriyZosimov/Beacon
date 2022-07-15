package com.beacon.catalog.dao;

import com.beacon.model.MobileDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.List;

@SpringBootTest
public class MobileDaoIT {

    @Autowired
    MobileDao mobileDao;
    private static byte[] FIRST_IMAGE;
    private static byte[] SECOND_IMAGE;

    @BeforeAll
    public static void loadImages() {
        File imgF = new File("src/test/resources/img/sample-phone.jpeg");
        File imgS = new File("src/test/resources/img/sample-phone-2.jpeg");
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(imgF));
            FIRST_IMAGE = bufferedInputStream.readAllBytes();
            bufferedInputStream.close();

            bufferedInputStream = new BufferedInputStream(new FileInputStream(imgS));
            SECOND_IMAGE = bufferedInputStream.readAllBytes();
            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setupTest() {
        Assertions.assertNotNull(mobileDao);
    }

    @Test
    public void getAllMobileDto() {
        List<MobileDto> dtos = mobileDao.findAll();
        Assertions.assertNotNull(dtos);
        Assertions.assertEquals(2, dtos.size());
        // if it doesn't pass, check import.sql. Mobiles should be inserted in row
        Assertions.assertEquals("honor508128black", dtos.get(0).getMobileId());
        for (int i = 0; i < FIRST_IMAGE.length; i++) {
            Assertions.assertEquals(FIRST_IMAGE[i], dtos.get(0).getMainImage().getImage()[i]);
        }
        System.out.println("\nFirst: " + dtos.get(0).toString());

        Assertions.assertEquals("pocox3pro8256green", dtos.get(1).getMobileId());
        for (int i = 0; i < SECOND_IMAGE.length; i++) {
            Assertions.assertEquals(SECOND_IMAGE[i], dtos.get(1).getMainImage().getImage()[i]);
        }
        System.out.println("\nSecond: " + dtos.get(1).toString());
    }
}
