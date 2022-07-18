package com.beacon.search.web;

import com.beacon.model.MobileDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

/**
 * All tests are constructed according to inserted data from import.sql.
 * If any test doesn't pass, first of all default data should be checked in import.sql.
 * <p>
 * Test class uses a postgres database.
 */
@SpringBootTest
public class MobileSearchControllerIT {

    private static final String MOBILE_URL = "/search";

    @Autowired
    private MobileSearchController controller;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setMessageConverters(new MappingJackson2HttpMessageConverter())
                .alwaysDo(MockMvcResultHandlers.print())
                .build();
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    public void testSearchByColorQuery() throws Exception {
        String color = "black";
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(MOBILE_URL)
                .param("query", color)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();
        List<MobileDto> result = (List<MobileDto>) objectMapper.readValue(response.getContentAsString(),
                new TypeReference<List<MobileDto>>() {
                });

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(color, result.get(0).getColor());
    }

    @Test
    public void testSearchByBrandQuery() throws Exception {
        String brand = "poco";

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(MOBILE_URL)
                .param("query", brand)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();
        List<MobileDto> result = (List<MobileDto>) objectMapper.readValue(response.getContentAsString(),
                new TypeReference<List<MobileDto>>() {
                });

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(brand, result.get(0).getBrand());
    }

    @Test
    public void testSearchByComplexQueryWith_firstShouldBeTheNewestMobile() throws Exception {
        String complexQuery = "honor poco 48";

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(MOBILE_URL)
                .param("query", complexQuery)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();
        List<MobileDto> result = (List<MobileDto>) objectMapper.readValue(response.getContentAsString(),
                new TypeReference<List<MobileDto>>() {
                });

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("2022", result.get(0).getReleaseYear());
        Assertions.assertEquals("2021", result.get(1).getReleaseYear());
    }

    @Test
    public void testSearchByComplexQuery_firstShouldBeTheMostFitted() throws Exception {
        String complexQuery = "honor poco 48 x3 pro qualcomm";

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(MOBILE_URL)
                .param("query", complexQuery)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();
        List<MobileDto> result = (List<MobileDto>) objectMapper.readValue(response.getContentAsString(),
                new TypeReference<List<MobileDto>>() {
                });

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("poco", result.get(0).getBrand());
        Assertions.assertEquals("x3pro", result.get(0).getModel());
        Assertions.assertEquals("honor", result.get(1).getBrand());
    }

    @Test
    public void testSearchByComplexQuery_shouldReturnEmptyList() throws Exception {
        String complexQuery = "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww";

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(MOBILE_URL)
                .param("query", complexQuery)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();
        List<MobileDto> result = (List<MobileDto>) objectMapper.readValue(response.getContentAsString(),
                new TypeReference<List<MobileDto>>() {
                });

        Assertions.assertTrue(result.isEmpty());
    }
}
