package com.beacon.catalog.service;

import com.beacon.model.MobileDtoFull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MobileDtoFullServiceMock {

    @Spy
    MobileDtoFullService service;

    @Test
    public void generateMobileId_default_test() {
        MobileDtoFull mobileDtoFullFirst = generateMobileDtoFull("BQ-Mobile", "bq model", "dark (blue)");
        MobileDtoFull mobileDtoFullSecond = generateMobileDtoFull("F+", "x3 pro", "cherry blossom pink");
        MobileDtoFull mobileDtoFullThird = generateMobileDtoFull("Joy's", "S10+", "navy blue");

        service.generateMobileId(mobileDtoFullFirst);
        Assertions.assertEquals("bqmobilebqmodel8128darkblue", mobileDtoFullFirst.getMobileId());

        service.generateMobileId(mobileDtoFullSecond);
        Assertions.assertEquals("fplusx3pro8128cherryblossompink", mobileDtoFullSecond.getMobileId());

        service.generateMobileId(mobileDtoFullThird);
        Assertions.assertEquals("joyss10plus8128navyblue", mobileDtoFullThird.getMobileId());
    }

    @Test
    public void testIncomingNullableObject_NullPointerException_shouldBeThrown() {
        Assertions.assertThrowsExactly(NullPointerException.class, () -> service.generateMobileId(null));

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
