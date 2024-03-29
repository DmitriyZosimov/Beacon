package com.beacon.search.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"com.beacon.search.dao"})
@EnableJpaRepositories(basePackages = {"com.beacon.search.dao"})
@EntityScan(basePackages = "com.beacon.model")
public class DaoConfiguration {
}
