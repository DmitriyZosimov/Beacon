package com.beacon.catalog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest()
@ComponentScan(basePackages = "com.beacon")
class CatalogApplicationTests {

    @Test
    void contextLoads() {
    }

}
