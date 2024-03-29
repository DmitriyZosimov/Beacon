package com.beacon.catalog.web;

import com.beacon.catalog.TestMobileFullBuilder;
import com.beacon.catalog.service.MobileFullService;
import com.beacon.catalog.service.MobileService;
import com.beacon.model.MobileFull;
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
public class SecurityTests implements TestMobileFullBuilder {
    private static final String MOBILE_URL = "/mobile/";
    private static final String MOBILE_ID_URL = "/mobile/";
    private static final String TASK_URL = "/shop/";

    @Autowired
    WebApplicationContext context;
    @MockBean
    JwtDecoder jwtDecoder;
    @MockBean
    MobileService service;
    @MockBean
    MobileFullService FullService;
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
        when(FullService.findMobileFullById(any())).thenReturn(Optional.empty());
        when(FullService.saveMobileFull(any())).thenReturn(null);
    }

    @Test
    public void createNewMobileFull_401_WithoutManagerCatalogRole() throws Exception {
        MobileFull mobileFull = build();
        mobileFull.setMobileId(null);
        mobileFull.getMainImage().setMobile(null);
        mobileFull.getNotMainImages().forEach(image -> image.setMobileFull(null));
        String json = objectMapper.writeValueAsString(mobileFull);

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
    public void createNewMobileFull_403_WithNotManagerCatalogRole() throws Exception {
        MobileFull mobileFull = build();
        mobileFull.setMobileId(null);
        mobileFull.getMainImage().setMobile(null);
        mobileFull.getNotMainImages().forEach(image -> image.setMobileFull(null));
        String json = objectMapper.writeValueAsString(mobileFull);

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

    @Test
    public void tryToGetTasks_401_NotAuthorized() throws Exception {
        Long shopId = 1L;
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(TASK_URL + shopId +"/tasks")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized())
                .andReturn().getResponse();
    }

    @Test
    @WithMockUser(roles = "Consumer")
    public void tryToGetTasks_403_WithoutSuitableRole() throws Exception {
        Long shopId = 1L;
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(TASK_URL + shopId +"/tasks")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isForbidden())
                .andReturn().getResponse();
    }

    @Test
    @WithMockUser(roles = "Employee-Beacon")
    public void tryToGetTasks_200_WithSuitableRole() throws Exception {
        Long shopId = 1L;
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(TASK_URL + shopId +"/tasks")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();
    }
}