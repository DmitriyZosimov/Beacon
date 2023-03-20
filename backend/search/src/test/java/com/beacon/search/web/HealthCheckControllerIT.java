package com.beacon.search.web;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureEmbeddedDatabase(provider = AutoConfigureEmbeddedDatabase.DatabaseProvider.ZONKY)
public class HealthCheckControllerIT {

    private static final String STATUS_URL = "/statuscheck";
    private static final String RESOURCE_URL = "/resourcecheck";

    @Autowired
    private HealthCheckController healthCheckController;
    @MockBean
    private EntityManager entityManager;
    @MockBean
    private JwtDecoder jwtDecoder;
    @MockBean
    private Query query;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(healthCheckController).build();
    }

    @Test
    public void testStatusCheck() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(STATUS_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("OK"));
    }

    @Test
    public void testResourceCheck_SUCCESS() throws Exception {
        when(entityManager.createNativeQuery(anyString())).thenReturn(query);
        when(query.getSingleResult()).thenReturn("1");
        mockMvc.perform(MockMvcRequestBuilders.get(RESOURCE_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("OK"));
    }

    @Test
    public void testResourceCheck_FAILED() throws Exception {
        when(entityManager.createNativeQuery(anyString())).thenReturn(query);
        when(query.getSingleResult()).thenReturn("2");
        mockMvc.perform(MockMvcRequestBuilders.get(RESOURCE_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("FAILED"));
    }

    @Test
    public void testResourceCheck_FAILED_WhenExceptionWasThrown() throws Exception {
        when(entityManager.createNativeQuery(anyString())).thenReturn(query);
        when(query.getSingleResult()).thenThrow(NoResultException.class);
        mockMvc.perform(MockMvcRequestBuilders.get(RESOURCE_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("FAILED"));
    }
}
