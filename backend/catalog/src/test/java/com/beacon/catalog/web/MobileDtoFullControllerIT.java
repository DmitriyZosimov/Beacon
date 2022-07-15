package com.beacon.catalog.web;

import com.beacon.catalog.TestMobileDtoFulBuilder;
import com.beacon.model.MobileDtoFull;
import com.beacon.model.tools.MobileIdToUrlPathConverter;
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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * All test data is included in import.sql.
 */

@SpringBootTest
@AutoConfigureMockMvc
public class MobileDtoFullControllerIT implements TestMobileDtoFulBuilder {

    private static final String MOBILE_ID_URL = "/mobile/";
    private static final String FULL_MOBILE_ID_URL = "http://localhost/mobile/";

    @Autowired
    MobileDtoFullController mobileDtoFullController;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(mobileDtoFullController)
                .alwaysDo(MockMvcResultHandlers.print())
                .setMessageConverters(new MappingJackson2HttpMessageConverter())
                .build();
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    public void findMobileDtoFullById_statusOK() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(MOBILE_ID_URL + "honor/508128black")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();
        MobileDtoFull mobileDtoFull = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() {
        });
        Assertions.assertNotNull(mobileDtoFull);
        //if it doesn't pass, see import.sql
        Assertions.assertEquals("honor508128black", mobileDtoFull.getMobileId());
        Assertions.assertEquals("honor", mobileDtoFull.getBrand());
        Assertions.assertEquals("50", mobileDtoFull.getModel());
        Assertions.assertEquals(MobileDtoFull.class, mobileDtoFull.getClass());
        System.out.println(mobileDtoFull.toString());
    }

    @Test
    public void notFindMobileDtoFullById_statusNotFound() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(MOBILE_ID_URL + "1/2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound()).andReturn().getResponse();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(404, response.getStatus());
    }

    @DirtiesContext
    @Test
    public void createNewMobileDtoFull_statusCreated() throws Exception {
        MobileDtoFull mobileDtoFull = build();
        mobileDtoFull.setMobileId(null);
        mobileDtoFull.getMainImage().setMobileDto(null);
        mobileDtoFull.getNotMainImages().forEach(image -> image.setMobileDtoFull(null));
        String json = objectMapper.writeValueAsString(mobileDtoFull);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.post(MOBILE_ID_URL)
                .accept(MediaType.APPLICATION_JSON)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn().getResponse();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(201, response.getStatus());
        Assertions.assertEquals(FULL_MOBILE_ID_URL + MobileIdToUrlPathConverter.convert(build()),
                response.getRedirectedUrl());
    }

    @DirtiesContext
    @Test
    public void createNewMobileDtoFull_WithoutImages_statusCreated() throws Exception {
        MobileDtoFull mobileDtoFull = build();
        mobileDtoFull.setMobileId(null);
        mobileDtoFull.setMainImage(null);
        mobileDtoFull.setNotMainImages(null);
        String json = objectMapper.writeValueAsString(mobileDtoFull);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.post(MOBILE_ID_URL)
                .accept(MediaType.APPLICATION_JSON)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn().getResponse();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(201, response.getStatus());
        Assertions.assertEquals(FULL_MOBILE_ID_URL + MobileIdToUrlPathConverter.convert(build()),
                response.getRedirectedUrl());
    }
}
