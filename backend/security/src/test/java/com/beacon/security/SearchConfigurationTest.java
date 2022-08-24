package com.beacon.security;

import com.beacon.security.annotation.EnableBeaconSecurity;
import com.beacon.security.config.Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SearchContextConfiguration.class)
public class SearchConfigurationTest {

    @Autowired
    private ApplicationContext context;

    @MockBean
    private JwtDecoder jwtDecoder;

    @Test
    public void contextTest() {
        Map<String, Object> beans = context.getBeansWithAnnotation(Configuration.class);
        Assertions.assertFalse(beans.containsKey("com.beacon.security.config.CatalogSecurityResourceServerConfig"));
        Assertions.assertTrue(beans.containsKey("com.beacon.security.config.SearchSecurityResourceServerConfig"));
        Assertions.assertFalse(beans.containsKey("com.beacon.security.config.ShopSecurityResourceServerConfig"));
    }
}

@Configuration
@EnableBeaconSecurity(application = Application.SEARCH)
@EnableWebSecurity
class SearchContextConfiguration {

}
