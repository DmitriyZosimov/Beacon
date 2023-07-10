package com.beacon.catalog;

import com.beacon.catalog.config.DatasourceProxyBeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

    @Bean
    @ConditionalOnMissingBean(DatasourceProxyBeanPostProcessor.class)
    public DatasourceProxyBeanPostProcessor datasourceProxyBeanPostProcessor() {
        return new DatasourceProxyBeanPostProcessor();
    }
}
