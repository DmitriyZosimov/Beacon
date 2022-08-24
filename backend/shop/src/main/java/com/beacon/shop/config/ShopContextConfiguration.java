package com.beacon.shop.config;

import com.beacon.security.annotation.EnableBeaconSecurity;
import com.beacon.security.config.Application;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "com.beacon.shop")
@EnableBeaconSecurity(application = Application.SHOP)
public class ShopContextConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
