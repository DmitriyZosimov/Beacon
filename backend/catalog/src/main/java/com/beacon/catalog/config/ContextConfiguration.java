package com.beacon.catalog.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"com.beacon.catalog"})
@EnableJpaRepositories(basePackages = {"com.beacon.catalog.dao"})
@EntityScan(basePackages = "com.beacon.model")
public class ContextConfiguration {


}
