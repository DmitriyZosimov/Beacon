package com.beacon.catalog.testdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * H2 database configuration class setup embedded h2 database with test data.
 */
@Configuration
public class TestH2DBConfig {

    private static Logger LOGGER = LoggerFactory.getLogger(TestH2DBConfig.class);

    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            DataSource dataSource =  dbBuilder.setType(EmbeddedDatabaseType.H2)
                    .build();
            LOGGER.info("Embedded DataSource was initialized");
            return dataSource;
        } catch (Exception e) {
            LOGGER.error("Embedded test DataSource was not created. ", e);
            return null;
        }
    }
}
