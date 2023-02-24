package com.beacon.catalog.dao;

import com.beacon.catalog.config.DaoConfiguration;
import com.beacon.model.MobileFull;
import com.beacon.model.MobileNotMainImage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.io.*;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@ContextConfiguration(classes = DaoConfiguration.class)
public class MobileFullDaoIT {

    @Autowired
    MobileFullDao mobileFullDao;

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
    public void findMobileFullById() {
        Optional<MobileFull> optionalMobileFull = mobileFullDao.findById("honor508128black");
        Assertions.assertTrue(optionalMobileFull.isPresent());
        //if it doesn't pass, see import.sql
        Assertions.assertEquals("honor508128black", optionalMobileFull.get().getMobileId());
        Assertions.assertEquals("honor", optionalMobileFull.get().getBrand());
        Assertions.assertEquals("50", optionalMobileFull.get().getModel());
        Assertions.assertEquals(MobileFull.class, optionalMobileFull.get().getClass());
//        for (int i = 0; i < FIRST_IMAGE.length; i++) {
//            Assertions.assertEquals(FIRST_IMAGE[i], optionalMobileFull.get().getMainImage().getImage()[i]);
//        }
//        Assertions.assertEquals(2, optionalMobileFull.get().getNotMainImages().size());
//        List<MobileNotMainImage> notMainImages = optionalMobileFull.get().getNotMainImages();
//        for (int i = 0; i < SECOND_IMAGE.length; i++) {
//            Assertions.assertEquals(SECOND_IMAGE[i], notMainImages.get(0).getImage()[i]);
//        }
//        for (int i = 0; i < THIRD_IMAGE.length; i++) {
//            Assertions.assertEquals(THIRD_IMAGE[i], notMainImages.get(1).getImage()[i]);
//        }
        System.out.println(optionalMobileFull.get().toString());
    }
}
