package com.beacon.model.tools;

import com.beacon.model.Mobile;
import com.beacon.model.MobileFullTest;
import com.beacon.model.MobileMainImage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ToStringToolTest implements MobileFullTest {

    Mobile mobile = new Mobile();

    @BeforeEach
    public void setup() {
        mobile.setMobileId("honor508128black");
        mobile.setBrand("honor");
        mobile.setModel("50");
        mobile.setBattery(4100);
        mobile.setColor("black");
        mobile.setRam(8);
        mobile.setStorageCapacity(128);
        mobile.setOs("android");
        mobile.setSimCardSlot("2");
        mobile.setCameraResolution("48");
        mobile.setChipsetModel("Qualcomm");
        mobile.setDisplayResolution("1920x2100");
        mobile.setDisplayTechnology("IPS");
        mobile.setScreenSize("6.67\"");
        mobile.setReleaseYear("2022");
        mobile.setMainImage(MobileMainImage.builder().mobile(mobile).build());
        mobile.setRelevant(1);
    }

    @Test
    public void getStringUsingTool() {
        ToStringTool<Mobile> tool = new ToStringTool<>(mobile);
        String result = tool.getString();
        Assertions.assertNotNull(result);
        System.out.println(result);
    }

    @Test
    public void getStringUsingTool_MobileFull() {
        ToStringTool<Mobile> tool = new ToStringTool<>(getTestMobileFull());
        String result = tool.getString();
        Assertions.assertNotNull(result);
        System.out.println(result);
    }
}
