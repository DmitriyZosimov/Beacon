package com.beacon.catalog.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Move into a special configuration class, because it helps {@code @DataJpaTest} to configure a jpa part for testing.
 */
@Configuration
@ComponentScan(basePackages = {"com.beacon.catalog.dao"})
@EnableJpaRepositories(basePackages = {"com.beacon.catalog.dao"})
@EntityScan(basePackages = "com.beacon.model")
public class DaoConfiguration {
}