package com.beacon.search.dao;

import com.beacon.model.MobileDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * All tests are constructed according to inserted data from import.sql.
 * If any test doesn't pass, first of all default data should be checked in import.sql.
 * <p>
 * Test class uses a postgres database.
 */
@SpringBootTest
@Transactional
public class SearchMobileDaoIT {

    @Autowired
    MobileSearchDao dao;

    @Test
    public void testSearchByColorQuery() {
        String color = "black";

        List<MobileDto> result = dao.search(color);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(color, result.get(0).getColor());
    }

    @Test
    public void testSearchByBrandQuery() {
        String brand = "poco";

        List<MobileDto> result = dao.search(brand);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(brand, result.get(0).getBrand());
    }

    @Test
    public void testSearchByComplexQueryWith_firstShouldBeTheNewestMobile() {
        String complexQuery = "honor poco 48";

        List<MobileDto> result = dao.search(complexQuery);
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("2022", result.get(0).getReleaseYear());
        Assertions.assertEquals("2021", result.get(1).getReleaseYear());
    }

    @Test
    public void testSearchByComplexQuery_firstShouldBeTheMostFitted() {
        String complexQuery = "honor poco 48 x3 pro qualcomm";

        List<MobileDto> result = dao.search(complexQuery);
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("poco", result.get(0).getBrand());
        Assertions.assertEquals("x3pro", result.get(0).getModel());
        Assertions.assertEquals("honor", result.get(1).getBrand());
    }
}
