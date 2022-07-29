package com.beacon.catalog.web;

import com.beacon.catalog.TestMobileDtoFulBuilder;
import com.beacon.catalog.service.MobileDtoFullService;
import com.beacon.catalog.service.MobileDtoService;
import com.beacon.model.MobileDtoFull;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest
public class SecurityTests implements TestMobileDtoFulBuilder {
    private static final String MOBILE_URL = "/mobile/";
    private static final String MOBILE_ID_URL = "/mobile/";

    @Autowired
    WebApplicationContext context;
    @MockBean
    JwtDecoder jwtDecoder;
    @MockBean
    MobileDtoService service;
    @MockBean
    MobileDtoFullService dtoFullService;
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
        when(service.findAllMobileDtos()).thenReturn(List.of());
        when(dtoFullService.findMobileDtoFullById(any())).thenReturn(Optional.empty());
        when(dtoFullService.saveMobileDtoFull(any())).thenReturn(null);
    }

    @Test
    public void createNewMobileDtoFull_401_WithoutManagerCatalogRole() throws Exception {
        MobileDtoFull mobileDtoFull = build();
        mobileDtoFull.setMobileId(null);
        mobileDtoFull.getMainImage().setMobileDto(null);
        mobileDtoFull.getNotMainImages().forEach(image -> image.setMobileDtoFull(null));
        String json = objectMapper.writeValueAsString(mobileDtoFull);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.post(MOBILE_ID_URL)
                .with(csrf())
                .accept(MediaType.APPLICATION_JSON)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized())
                .andReturn().getResponse();
        Assertions.assertNotNull(response);
    }

    @Test
    @WithMockUser(roles = "Consumer")
    public void createNewMobileDtoFull_403_WithNotManagerCatalogRole() throws Exception {
        MobileDtoFull mobileDtoFull = build();
        mobileDtoFull.setMobileId(null);
        mobileDtoFull.getMainImage().setMobileDto(null);
        mobileDtoFull.getNotMainImages().forEach(image -> image.setMobileDtoFull(null));
        String json = objectMapper.writeValueAsString(mobileDtoFull);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.post(MOBILE_ID_URL)
                .with(csrf())
                .accept(MediaType.APPLICATION_JSON)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isForbidden())
                .andReturn().getResponse();
        Assertions.assertNotNull(response);
    }

    @Test
    public void tryToGetContentFromDoNotExistedURL_401_WithoutAnyRole() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/999999999999")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized())
                .andReturn().getResponse();
        Assertions.assertNotNull(response);
    }
}