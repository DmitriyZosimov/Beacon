package com.beacon.catalog.service;

import com.beacon.model.MobileFull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MobileFullServiceMock {

    @Spy
    MobileFullService service;

    @Test
    public void generateMobileId_default_test() {
        MobileFull mobileFullFirst = generateMobileFull("BQ-Mobile", "bq model", "dark (blue)");
        MobileFull mobileFullSecond = generateMobileFull("F+", "x3 pro", "cherry blossom pink");
        MobileFull mobileFullThird = generateMobileFull("Joy's", "S10+", "navy blue");

        service.generateMobileId(mobileFullFirst);
        Assertions.assertEquals("bqmobilebqmodel8128darkblue", mobileFullFirst.getMobileId());

        service.generateMobileId(mobileFullSecond);
        Assertions.assertEquals("fplusx3pro8128cherryblossompink", mobileFullSecond.getMobileId());

        service.generateMobileId(mobileFullThird);
        Assertions.assertEquals("joyss10plus8128navyblue", mobileFullThird.getMobileId());
    }

    @Test
    public void testIncomingNullableObject_NullPointerException_shouldBeThrown() {
        Assertions.assertThrowsExactly(NullPointerException.class, () -> service.generateMobileId(null));

    }

    private MobileFull generateMobileFull(String brand, String model, String color) {
        MobileFull mobileFullFirst = new MobileFull();
        mobileFullFirst.setBrand(brand);
        mobileFullFirst.setModel(model);
        mobileFullFirst.setRam(8);
        mobileFullFirst.setStorageCapacity(128);
        mobileFullFirst.setColor(color);
        return mobileFullFirst;
    }
}
