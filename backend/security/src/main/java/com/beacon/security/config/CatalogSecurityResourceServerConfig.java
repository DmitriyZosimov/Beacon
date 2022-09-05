package com.beacon.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class CatalogSecurityResourceServerConfig extends AbstractBeaconSecurity {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/mobile/")
                .hasAuthority("ROLE_Manager-content")
                .antMatchers(HttpMethod.GET, "/mobile/**")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/cart/")
                .anonymous()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationToken()));
    }
}