package com.beacon.shop.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.beacon.model.shop")
@EnableJpaRepositories(basePackages = "com.beacon.shop.dao")
@ComponentScan(basePackages = "com.beacon.shop.dao")
public class DaoConfiguration {
}
