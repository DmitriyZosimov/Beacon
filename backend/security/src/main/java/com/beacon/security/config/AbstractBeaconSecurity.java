package com.beacon.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

public abstract class AbstractBeaconSecurity extends WebSecurityConfigurerAdapter {

    /**
     * To solve issue with CORS and to configure global Cross-Origin
     * <p>
     * Access to XMLHttpRequest at from origin has been blocked by CORS policy:
     * Response to preflight request doesn't pass access control check:
     * No 'Access-Control-Allow-Origin' header is present on the requested resource.
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

    protected Converter<Jwt, ? extends AbstractAuthenticationToken> jwtAuthenticationToken() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
        return jwtAuthenticationConverter;
    }
}
