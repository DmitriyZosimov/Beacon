package com.beacon.catalog.web;

import com.beacon.model.dtos.MobileDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

/**
 * All test data is included in import.sql.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class MobileControllerIT {

    private static final String MOBILE_URL = "/mobile/";
    private static byte[] FIRST_IMAGE;
    private static byte[] SECOND_IMAGE;

    @Autowired
    WebApplicationContext context;
    @Autowired
    @Qualifier("customSimpleModule")
    SimpleModule simpleModule;
    @MockBean
    JwtDecoder jwtDecoder;
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @BeforeAll
    public static void loadImages() {
        File imgF = new File("src/test/resources/img/sample-phone.jpeg");
        File imgS = new File("src/test/resources/img/sample-phone-2.jpeg");
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(imgF));
            FIRST_IMAGE = bufferedInputStream.readAllBytes();
            bufferedInputStream.close();

            bufferedInputStream = new BufferedInputStream(new FileInputStream(imgS));
            SECOND_IMAGE = bufferedInputStream.readAllBytes();
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .alwaysDo(MockMvcResultHandlers.print())
                .apply(springSecurity())
                .build();
        MockitoAnnotations.openMocks(this);
        objectMapper.registerModule(simpleModule);
    }

    @Test
    public void returnResponseEntityWithAllMobiles_OK_UsingConsumerRole() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(MOBILE_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();
        List<MobileDto> resultList = (List<MobileDto>) objectMapper.readValue(response.getContentAsString(),
                new TypeReference<Iterable<MobileDto>>() {
                });
        Assertions.assertNotNull(resultList);
        Assertions.assertEquals(2, resultList.size());
        Assertions.assertEquals("pocox3pro8256green", resultList.get(0).getMobileId());
        Assertions.assertEquals("green", resultList.get(0).getColor());
        Assertions.assertEquals("honor508128black", resultList.get(1).getMobileId());
        Assertions.assertEquals("honor", resultList.get(1).getBrand());
        Assertions.assertEquals("50", resultList.get(1).getModel());

        resultList.forEach(dto -> {
            Assertions.assertNotNull(dto.getCountOfOffers());
            Assertions.assertNotNull(dto.getMinimalPrice());
        });

        for (int i = 0; i < SECOND_IMAGE.length; i++) {
            Assertions.assertEquals(SECOND_IMAGE[i], resultList.get(0).getMainImage().getImage()[i]);
        }

        for (int i = 0; i < FIRST_IMAGE.length; i++) {
            Assertions.assertEquals(FIRST_IMAGE[i], resultList.get(1).getMainImage().getImage()[i]);
        }
    }
}
