package com.beacon.catalog.testdb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

/**
 * Check only whether the embedded h2 database is correctly configured.
 */
@SpringBootTest
public class TestDB {

    @Autowired
    DataSource dataSource;

    @Test
    public void setupTest() {
        Assertions.assertNotNull(dataSource);
    }
}
