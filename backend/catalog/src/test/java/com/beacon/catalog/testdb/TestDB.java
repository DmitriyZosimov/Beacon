package com.beacon.catalog.testdb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.jwt.JwtDecoder;

import javax.sql.DataSource;

/**
 * Check only whether the embedded h2 database is correctly configured.
 */
@SpringBootTest
public class TestDB {
    /**
     * As the {@code SpringBootTest} loads all configuration and the application uses security configuration with JWT
     * and this tests do not load checking security configuration but only control the application, we should mock the
     * {@code JwtDecoder}. Without this simple step the test will not pass.
     */
    @MockBean
    JwtDecoder jwtDecoder;
    @Autowired
    DataSource dataSource;

    @Test
    public void setupTest() {
        Assertions.assertNotNull(dataSource);
    }
}
