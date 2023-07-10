package com.beacon.catalog.dao;

import com.beacon.catalog.BaseIT;
import com.beacon.catalog.TestConfig;
import com.beacon.catalog.config.DaoConfiguration;
import com.beacon.catalog.transformer.LaptopTransformer;
import com.beacon.model.dtos.LaptopDto;
import com.beacon.model.dtos.LaptopPreviewDto;
import com.beacon.model.product.Laptop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@DataJpaTest
@ContextConfiguration(classes = { DaoConfiguration.class, TestConfig.class})
public class LaptopDaoIT implements BaseIT {

    @Autowired
    LaptopDao laptopDao;

    @Test
    @Transactional(readOnly = true)
    public void findAllPreviewByLaptopPreviewDto() {
        System.out.println("Start...");
        long start = System.nanoTime();
        Set<LaptopPreviewDto> laptops = laptopDao.findAllPreviewBy();
        long end = System.nanoTime();
        System.out.println("End: " + (end - start));
        Assertions.assertFalse(laptops.isEmpty());
        laptops.forEach(laptop -> {
            System.out.println("Id " + laptop.getComputerId());
            System.out.println("LaptopType " + laptop.getType());
            Assertions.assertNotNull(laptop.getImage());
        });
    }

    @Test
    @Transactional(readOnly = true)
    public void findAllBy_LaptopDto() {
        System.out.println("Start...");
        LaptopTransformer transformer = new LaptopTransformer();
        long start = System.nanoTime();
        List<LaptopDto> laptops = transformer.transformList(laptopDao.findAllBy());
        long end = System.nanoTime();
        System.out.println("End: " + (end - start));
        Assertions.assertFalse(laptops.isEmpty());
        laptops.forEach(laptop -> {
            Assertions.assertNotNull(laptop.getComputerMainImage());
            Assertions.assertFalse(laptop.getComputerNotMainImages().isEmpty());
        });
    }

    @Test
    @Transactional(readOnly = true)
    public void findAllByToTuple_LaptopDto() {
        System.out.println("Start...");
        LaptopTransformer transformer = new LaptopTransformer();
        long start = System.nanoTime();
        List<LaptopDto> laptops = transformer.transformTupleList(laptopDao.findAllByToTuple());
        long end = System.nanoTime();
        System.out.println("End: " + (end - start));
        Assertions.assertFalse(laptops.isEmpty());
        laptops.forEach(laptop -> {
            Assertions.assertNotNull(laptop.getComputerMainImage());
            Assertions.assertFalse(laptop.getComputerNotMainImages().isEmpty());
        });
    }

    @Test
    @Transactional(readOnly = true)
    public void findAll() {
        System.out.println("Start...");
        long start = System.nanoTime();
        List<Laptop> laptops = laptopDao.findAll();
        long end = System.nanoTime();
        System.out.println("End: " + (end - start));
        Assertions.assertFalse(laptops.isEmpty());
        laptops.forEach(laptop -> {
            Assertions.assertNotNull(laptop.getComputerMainImage());
            Assertions.assertFalse(laptop.getComputerNotMainImages().isEmpty());
        });
    }

    @Test
    @Transactional(readOnly = true)
    public void findByComputerId_Laptop() {
        System.out.println("Start...");
        long start = System.nanoTime();
        Optional<Laptop> laptops = laptopDao.findByComputerId("lenovo82jf0082rk", Laptop.class);
        long end = System.nanoTime();
        System.out.println("End: " + (end - start));
        Assertions.assertFalse(laptops.isEmpty());
        Assertions.assertEquals("lenovo82jf0082rk", laptops.get().getComputerId());
    }

    @Test
    @Transactional(readOnly = true)
    public void findByComputerId_LaptopDto() {
        System.out.println("Start...");
        LaptopTransformer transformer = new LaptopTransformer();
        long start = System.nanoTime();
        Optional<LaptopDto> laptops = transformer.transform(laptopDao.findByComputerId("lenovo82jf0082rk"));
        long end = System.nanoTime();
        System.out.println("End: " + (end - start));
        Assertions.assertFalse(laptops.isEmpty());
        Assertions.assertEquals("lenovo82jf0082rk", laptops.get().getComputerId());
    }

    @Test
    @Transactional(readOnly = true)
    public void findByComputerIdToTuple_LaptopDto() {
        System.out.println("Start...");
        LaptopTransformer transformer = new LaptopTransformer();
        long start = System.nanoTime();
        Optional<LaptopDto> laptops = transformer.transformFromTuple(laptopDao.findByComputerIdToTuple("lenovo82jf0082rk"));
        long end = System.nanoTime();
        System.out.println("End: " + (end - start));
        Assertions.assertFalse(laptops.isEmpty());
        Assertions.assertEquals("lenovo82jf0082rk", laptops.get().getComputerId());
    }
}
