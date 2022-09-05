package com.beacon.catalog.web;

import com.beacon.catalog.TestMobileFullBuilder;
import com.beacon.model.MobileFull;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerIT implements TestMobileFullBuilder {

    private static final String CART_URL = "/cart/";

    @Autowired
    WebApplicationContext context;
    @Autowired
    @Qualifier("customSimpleModule")
    SimpleModule simpleModule;
    @MockBean
    JwtDecoder jwtDecoder;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .alwaysDo(MockMvcResultHandlers.print())
                .apply(springSecurity())
                .build();
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(simpleModule);
    }

    @Test
    public void createOrderTest() throws Exception {
        MobileFull mobileFull = build();
        mobileFull.getMainImage().setMobile(null);
        mobileFull.getNotMainImages().forEach(image -> image.setMobileFull(null));
        mobileFull.setOffers(buildOffers());
        String json = objectMapper.writeValueAsString(mobileFull);


        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.post(CART_URL)
                .with(csrf())
                .accept(MediaType.APPLICATION_JSON)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatus());
    }
}
