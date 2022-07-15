package com.beacon.catalog.web;

import com.beacon.model.MobileDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
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
 * All test data is included in import.sql.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class MobileDtoControllerIT {

    private static final String MOBILE_URL = "/mobile/";

    @Autowired
    MobileDtoController mobileDtoController;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(mobileDtoController)
                .setMessageConverters(new MappingJackson2HttpMessageConverter())
                .alwaysDo(MockMvcResultHandlers.print())
                .build();
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    public void returnResponseEntityWithAllMobileDtos_OK() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(MOBILE_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();
        List<MobileDto> resultList = (List<MobileDto>) objectMapper.readValue(response.getContentAsString(),
                new TypeReference<Iterable<MobileDto>>() {
                });
        Assertions.assertNotNull(resultList);
        Assertions.assertEquals(2, resultList.size());
        Assertions.assertEquals("honor508128black", resultList.get(0).getMobileId());
        Assertions.assertEquals("honor", resultList.get(0).getBrand());
        Assertions.assertEquals("50", resultList.get(0).getModel());
        Assertions.assertEquals("pocox3pro8256green", resultList.get(1).getMobileId());
        Assertions.assertEquals("green", resultList.get(1).getColor());
        System.out.println(resultList.get(0).toString());
        System.out.println(resultList.get(1).toString());
    }

}
