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

                .antMatchers(HttpMethod.GET, "/shop/1/**")
                .hasAuthority("ROLE_Employee-Beacon")
                .antMatchers(HttpMethod.PUT, "/shop/1/**")
                .hasAuthority("ROLE_Employee-Beacon")

                .antMatchers(HttpMethod.GET, "/shop/2/**")
                .hasAuthority("ROLE_Employee-21Vek")
                .antMatchers(HttpMethod.PUT, "/shop/2/**")
                .hasAuthority("ROLE_Employee-21Vek")

                .antMatchers(HttpMethod.GET, "/shop/3/**")
                .hasAuthority("ROLE_Employee-5element")
                .antMatchers(HttpMethod.PUT, "/shop/3/**")
                .hasAuthority("ROLE_Employee-5element")

                .antMatchers(HttpMethod.GET, "/shop/4/**")
                .hasAuthority("ROLE_Employee-TTN")
                .antMatchers(HttpMethod.PUT, "/shop/4/**")
                .hasAuthority("ROLE_Employee-TTN")

                .antMatchers(HttpMethod.GET, "/shop/5/**")
                .hasAuthority("ROLE_Employee-7745.by")
                .antMatchers(HttpMethod.PUT, "/shop/5/**")
                .hasAuthority("ROLE_Employee-7745.by")

                .antMatchers(HttpMethod.GET, "/shop/6/**")
                .hasAuthority("ROLE_Employee-sila.by")
                .antMatchers(HttpMethod.PUT, "/shop/6/**")
                .hasAuthority("ROLE_Employee-sila.by")

                .antMatchers(HttpMethod.GET, "/shop/7/**")
                .hasAuthority("ROLE_Employee-EVROSET")
                .antMatchers(HttpMethod.PUT, "/shop/7/**")
                .hasAuthority("ROLE_Employee-EVROSET")

                .antMatchers(HttpMethod.GET, "/shop/8/**")
                .hasAuthority("ROLE_Employee-TechnoMir")
                .antMatchers(HttpMethod.PUT, "/shop/8/**")
                .hasAuthority("ROLE_Employee-TechnoMir")

                .anyRequest()
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationToken()));
    }
}