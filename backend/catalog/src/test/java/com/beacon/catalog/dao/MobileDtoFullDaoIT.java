package com.beacon.catalog.dao;

import com.beacon.model.MobileDtoFull;
import com.beacon.model.MobileNotMainImage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MobileDtoFullDaoIT {

    @Autowired
    MobileDtoFullDao mobileDtoFullDao;

    private static byte[] FIRST_IMAGE;
    private static byte[] SECOND_IMAGE;
    private static byte[] THIRD_IMAGE;

    @BeforeAll
    public static void loadImages() {
        File imgF = new File("src/test/resources/img/sample-phone.jpeg");
        File imgS = new File("src/test/resources/img/sample-phone-2.jpeg");
        File imgT = new File("src/test/resources/img/sample-phone-3.jpeg");
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(imgF));
            FIRST_IMAGE = bufferedInputStream.readAllBytes();
            bufferedInputStream.close();

            bufferedInputStream = new BufferedInputStream(new FileInputStream(imgS));
            SECOND_IMAGE = bufferedInputStream.readAllBytes();
            bufferedInputStream.close();

            bufferedInputStream = new BufferedInputStream(new FileInputStream(imgT));
            THIRD_IMAGE = bufferedInputStream.readAllBytes();
            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findMobileDtoFullById() {
        Optional<MobileDtoFull> optionalMobileDtoFull = mobileDtoFullDao.findById("honor508128black");
        Assertions.assertTrue(optionalMobileDtoFull.isPresent());
        //if it doesn't pass, see import.sql
        Assertions.assertEquals("honor508128black", optionalMobileDtoFull.get().getMobileId());
        Assertions.assertEquals("honor", optionalMobileDtoFull.get().getBrand());
        Assertions.assertEquals("50", optionalMobileDtoFull.get().getModel());
        Assertions.assertEquals(MobileDtoFull.class, optionalMobileDtoFull.get().getClass());
        for (int i = 0; i < FIRST_IMAGE.length; i++) {
            Assertions.assertEquals(FIRST_IMAGE[i], optionalMobileDtoFull.get().getMainImage().getImage()[i]);
        }
        Assertions.assertEquals(2, optionalMobileDtoFull.get().getNotMainImages().size());
        List<MobileNotMainImage> notMainImages = optionalMobileDtoFull.get().getNotMainImages();
        for (int i = 0; i < SECOND_IMAGE.length; i++) {
            Assertions.assertEquals(SECOND_IMAGE[i], notMainImages.get(0).getImage()[i]);
        }
        for (int i = 0; i < THIRD_IMAGE.length; i++) {
            Assertions.assertEquals(THIRD_IMAGE[i], notMainImages.get(1).getImage()[i]);
        }
        System.out.println(optionalMobileDtoFull.get().toString());
    }
}
