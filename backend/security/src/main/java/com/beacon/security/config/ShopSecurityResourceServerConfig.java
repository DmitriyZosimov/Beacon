package com.beacon.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class ShopSecurityResourceServerConfig extends AbstractBeaconSecurity {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/shop/*")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .oauth2ResourceServer()
            .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationToken()));
    }
}