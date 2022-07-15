package com.beacon.catalog.service;

import com.beacon.catalog.dao.MobileDtoFullDao;
import com.beacon.model.MobileDtoFull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
public class MobileDtoFullServiceImplMockito {

    @InjectMocks
    MobileDtoFullServiceImpl service;
    @Mock
    MobileDtoFullDao dao;

    @Test
    public void generateMobileIdTestPrivateMethod() {
        MobileDtoFull mobileDtoFullFirst = generateMobileDtoFull("BQ-Mobile", "bq model", "dark (blue)");
        MobileDtoFull mobileDtoFullSecond = generateMobileDtoFull("F+", "x3 pro", "cherry blossom pink");
        MobileDtoFull mobileDtoFullThird = generateMobileDtoFull("Joy's", "S10+", "navy blue");

        Assertions.assertEquals("bqmobilebqmodel8128darkblue",
                ReflectionTestUtils.invokeMethod(service, "generateMobileId", mobileDtoFullFirst));

        Assertions.assertEquals("fplusx3pro8128cherryblossompink",
                ReflectionTestUtils.invokeMethod(service, "generateMobileId", mobileDtoFullSecond));

        Assertions.assertEquals("joyss10plus8128navyblue",
                ReflectionTestUtils.invokeMethod(service, "generateMobileId", mobileDtoFullThird));
    }

    private MobileDtoFull generateMobileDtoFull(String brand, String model, String color) {
        MobileDtoFull mobileDtoFullFirst = new MobileDtoFull();
        mobileDtoFullFirst.setBrand(brand);
        mobileDtoFullFirst.setModel(model);
        mobileDtoFullFirst.setRam(8);
        mobileDtoFullFirst.setStorageCapacity(128);
        mobileDtoFullFirst.setColor(color);
        return mobileDtoFullFirst;
    }
}
