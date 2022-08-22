package com.beacon.catalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityResourceServerConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/mobile/")
                .hasAuthority("ROLE_Manager-content")
                .antMatchers(HttpMethod.GET, "/mobile/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationToken()));
    }

    /**
     * To solve issue with CORS and to configure global Cross-Origin
     * <p>
     *     Access to XMLHttpRequest at from origin has been blocked by CORS policy:
     *     Response to preflight request doesn't pass access control check:
     *     No 'Access-Control-Allow-Origin' header is present on the requested resource.
     * </p>
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:4200"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        /*
        setAllowCredentials(true) is important, otherwise:
        The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the
        request's credentials mode is 'include'.
         */
        configuration.setAllowCredentials(true);

        /*
        setAllowedHeaders is important! Without it, OPTIONS preflight request
        will fail with 403 Invalid CORS request
         */
        configuration.setAllowedHeaders(List.of("Cache-Control", "Content-Type", "Access-Control-Allow-Headers", "Authorization", "X-Requested-With", "observe"));
        configuration.setExposedHeaders(List.of("Authentication", "responseType", "observe"));
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    private Converter<Jwt, ? extends AbstractAuthenticationToken> jwtAuthenticationToken() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
        return jwtAuthenticationConverter;
    }
}