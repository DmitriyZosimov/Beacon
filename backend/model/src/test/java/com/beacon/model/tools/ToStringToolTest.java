package com.beacon.model.tools;

import com.beacon.model.MobileDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ToStringToolTest {

    MobileDto mobileDto = new MobileDto();

    @BeforeEach
    public void setup() {
        mobileDto.setMobileId("honor508128black");
        mobileDto.setBrand("honor");
        mobileDto.setModel("50");
        mobileDto.setBattery(4100);
        mobileDto.setColor("black");
        mobileDto.setRam(8);
        mobileDto.setStorageCapacity(128);
        mobileDto.setOs("android");
        mobileDto.setSimCardSlot("2");
        mobileDto.setCameraResolution("48");
        mobileDto.setChipsetModel("Qualcomm");
        mobileDto.setDisplayResolution("1920x2100");
        mobileDto.setDisplayTechnology("IPS");
        mobileDto.setScreenSize("6.67\"");
        mobileDto.setReleaseYear("2022");
    }

    @Test
    public void getStringUsingTool() {
        ToStringTool<MobileDto> tool = new ToStringTool<>(mobileDto);
        String result = tool.getString();
        Assertions.assertNotNull(result);
        System.out.println(result);
    }
}
