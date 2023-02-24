package com.beacon.catalog.dao;

import com.beacon.catalog.config.DaoConfiguration;
import com.beacon.model.Mobile;
import com.beacon.model.dtos.MobileDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.io.*;
import java.util.Comparator;
import java.util.List;

/**
 * With this annotation, you can test any JPA related parts of your application. A good example is
 * to verify that a native query is working as expected.
 * <p>
 * What's part of the Spring Test Context: {@code Repository}, {@code EntityManager}, {@code
 * TestEntityManager}, {@code DataSource}.
 * <p>
 * What's not part of the Spring Test Context: {@code Service}, {@code Component}, {@code
 * Controller} beans.
 * <p>
 * By default, this annotation tries to auto-configure use an embedded database (e.g. H2) as the
 * DataSource. While an in-memory database might not be a good choice to verify a native query using
 * proprietary features, you can disable this auto-configuration with {@code
 * AutoConfigureTestDatabase} and use e.g. Testcontainers to create a PostgreSQL database for
 * testing.
 * <p>
 * Also see {@code TestApplication}
 */

@DataJpaTest
@ContextConfiguration(classes = DaoConfiguration.class)
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
    public void getAllMobileDto_FirstShouldPOCOPhone_BecauseItIsTheNewestPhone() {
        List<Mobile> dtos = mobileDao.findAll();
        Assertions.assertNotNull(dtos);
        Assertions.assertEquals(2, dtos.size());
        // if it doesn't pass, check import.sql. Mobiles should be inserted in row
        // Also check release_years. First goes the newest phone.
        Assertions.assertEquals("pocox3pro8256green", dtos.get(0).getMobileId());
        Assertions.assertNotNull(dtos.get(0).getReleaseYear());
        System.out.println("TEST :" + SECOND_IMAGE.length);
        for (int i = 0; i < SECOND_IMAGE.length; i++) {
            Assertions.assertEquals(SECOND_IMAGE[i], dtos.get(0).getMainImage().getImage()[i]);
        }
        Assertions.assertEquals("honor508128black", dtos.get(1).getMobileId());
        Assertions.assertNotNull(dtos.get(1).getReleaseYear());
        for (int i = 0; i < FIRST_IMAGE.length; i++) {
            Assertions.assertEquals(FIRST_IMAGE[i], dtos.get(1).getMainImage().getImage()[i]);
        }

        Assertions.assertEquals(1, YearsComparator.COMPARATOR.compare(dtos.get(0).getReleaseYear(), dtos.get(1).getReleaseYear()));
        System.out.println("\nFirst: " + dtos.get(0).toString());
        System.out.println("\nSecond: " + dtos.get(1).toString());
    }

    @Test
    public void shouldReturnMobileDtoList_findAllMobileDtos() {
        List<MobileDto> dtos = mobileDao.findAllMobileDtos();
        Assertions.assertNotNull(dtos);
        Assertions.assertEquals("pocox3pro8256green", dtos.get(0).getMobileId());
        Assertions.assertNotNull(dtos.get(0).getReleaseYear());
        for (int i = 0; i < SECOND_IMAGE.length; i++) {
            Assertions.assertEquals(SECOND_IMAGE[i], dtos.get(0).getMainImage().getImage()[i]);
        }
        Assertions.assertEquals("honor508128black", dtos.get(1).getMobileId());
        Assertions.assertNotNull(dtos.get(1).getReleaseYear());
        for (int i = 0; i < FIRST_IMAGE.length; i++) {
            Assertions.assertEquals(FIRST_IMAGE[i], dtos.get(1).getMainImage().getImage()[i]);
        }

        Assertions.assertEquals(1, YearsComparator.COMPARATOR.compare(dtos.get(0).getReleaseYear(), dtos.get(1).getReleaseYear()));
        dtos.forEach(dto -> {
            Assertions.assertNotNull(dto.getCountOfOffers());
            Assertions.assertNotNull(dto.getMinimalPrice());
        });
    }

    private static class YearsComparator implements Comparator<String> {

        private static YearsComparator COMPARATOR = new YearsComparator();

        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(Integer.parseInt(o1), Integer.parseInt(o2));
        }
    }
}
