package com.beacon.catalog;

import com.beacon.model.MobileFull;
import com.beacon.model.builders.MobileFullBuilder;
import com.beacon.model.builders.ShopBuilder;
import com.beacon.model.builders.WorkingHoursBuilder;
import com.beacon.model.shop.PaymentMethod;
import com.beacon.model.shop.Shop;
import com.beacon.model.shop.WorkingHours;

import java.io.File;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public interface TestMobileFullBuilder {

    String mobileId = "honorx96128titan";
    String brand = "HONOR";
    String model = "X9";
    String os = "Android";
    String screenSize = "6.81";
    String displayResolution = "1080x2388";
    String displayTechnology = "IPS";
    Integer ram = 6;
    Integer storageCapacity = 128;
    String chipsetModel = "Qualcomm Snapdragon";
    String cameraResolution = "64";
    String simCardSlot = "2";
    Integer battery = 4800;
    String color = "titan";
    String releaseYear = "2022";
    String type = "samrtphone";
    String osVersion = "Android 11";
    Integer processorClockFrequency = 2400;
    Integer coresNumber = 8;
    Integer technicalProcess = 6;
    String housingMaterial = "plastic";
    String simFormat = "nano-SIM";
    Double length = 166.75;
    Double width = 76.45;
    Double height = 8.79;
    Double weight = 189.9;
    Integer mainCamerasNumber = 4;
    Boolean builtInFlash = true;
    Boolean automaticFocus = true;
    Boolean opticalStabilization = false;
    Boolean mainCamera = true;
    String mainCameraAperture = "f/1.8";
    Boolean frontCamera = true;
    String frontCameraResolution = "16";
    String frontCameraAperture = "f/2.45";
    Boolean gps = true;
    Boolean glonass = true;
    Boolean beidou = true;
    Boolean edge = true;
    Boolean hspa = true;
    Boolean hspaPlus = true;
    Boolean lte = true;
    Boolean fiveG = false;
    Boolean bluetooth = true;
    String bluetoothVersion = "5.0";
    Boolean audioOutput = true;
    String audioOutputVersion = "USB Type-C";
    Boolean wifi = true;
    String wifiVersion = "802.11ac";
    String connection = "USB Type-C 2.0";
    Boolean nfc = true;
    String batteryType = "Li-ion";
    String chargeTime = null;

    default MobileFull build() {
        return MobileFullBuilder.create()
                .setMobileId(this.mobileId)
                .setBrand(this.brand)
                .setModel(this.model)
                .setOs(this.os)
                .setScreenSize(this.screenSize)
                .setDisplayResolution(this.displayResolution)
                .setDisplayTechnology(this.displayTechnology)
                .setRam(this.ram)
                .setStorageCapacity(this.storageCapacity)
                .setChipsetModel(this.chipsetModel)
                .setCameraResolution(this.cameraResolution)
                .setSimCardSlot(this.simCardSlot)
                .setBattery(this.battery)
                .setColor(this.color)
                .setReleaseYear(this.releaseYear)
                .setType(this.type)
                .setOsVersion(this.osVersion)
                .setProcessorClockFrequency(this.processorClockFrequency)
                .setCoresNumber(this.coresNumber)
                .setTechnicalProcess(this.technicalProcess)
                .setHousingMaterial(this.housingMaterial)
                .setSimFormat(this.simFormat)
                .setLength(this.length)
                .setWidth(this.width)
                .setHeight(this.height)
                .setWeight(this.weight)
                .setMainCamerasNumber(this.mainCamerasNumber)
                .setBuiltInFlash(this.builtInFlash)
                .setAutomaticFocus(this.automaticFocus)
                .setOpticalStabilization(this.opticalStabilization)
                .setMainCamera(this.mainCamera)
                .setMainCameraAperture(this.mainCameraAperture)
                .setFrontCamera(this.frontCamera)
                .setFrontCameraResolution(this.frontCameraResolution)
                .setFrontCameraAperture(this.frontCameraAperture)
                .setGps(this.gps)
                .setGlonass(this.glonass)
                .setBeidou(this.beidou)
                .setEdge(this.edge)
                .setHspa(this.hspa)
                .setHspaPlus(this.hspaPlus)
                .setLte(this.lte)
                .setFiveG(this.fiveG)
                .setBluetooth(this.bluetooth)
                .setBluetoothVersion(this.bluetoothVersion)
                .setAudioOutput(this.audioOutput)
                .setAudioOutputVersion(this.audioOutputVersion)
                .setWifi(this.wifi)
                .setWifiVersion(this.wifiVersion)
                .setConnection(this.connection)
                .setNfc(this.nfc)
                .setBatteryType(this.batteryType)
                .setChargeTime(this.chargeTime)
                .setMainImage(new File("src/test/resources/img/sample-phone.jpeg"))
                .setNotMainImages(new File("src/test/resources/img/sample-phone-2.jpeg"),
                        new File("src/test/resources/img/sample-phone-3.jpeg"))
                .build();
    }

    default Map<Shop, Double> buildOffers() {
        Set<PaymentMethod> paymentMethodSet = new HashSet<>();
        paymentMethodSet.add(PaymentMethod.CASH);
        paymentMethodSet.add(PaymentMethod.CREDIT_CARD);
        paymentMethodSet.add(PaymentMethod.DEBIT_CARD);
        paymentMethodSet.add(PaymentMethod.ELECTRONIC_BANK_TRANSFER);
        paymentMethodSet.add(PaymentMethod.MOBILE_PAYMENT);

        Map<DayOfWeek, WorkingHours> workingHoursMap = WorkingHoursBuilder.create()
                .setMonday(LocalTime.of(9, 0), LocalTime.of(18, 0))
                .setTuesday(LocalTime.of(9, 0), LocalTime.of(18, 0))
                .setWednesday(LocalTime.of(9, 0), LocalTime.of(18, 0))
                .setThursday(LocalTime.of(9, 0), LocalTime.of(18, 0))
                .setFriday(LocalTime.of(9, 0), LocalTime.of(18, 0))
                .setSaturday(LocalTime.of(9, 0), LocalTime.of(18, 0))
                .setSunday(LocalTime.of(9, 0), LocalTime.of(18, 0))
                .build();

        Map<Shop, Double> map = new HashMap<>();
        map.put(
                ShopBuilder.create().shopId(1L).name("test 1 shop").description("test 1 shop description")
                        .paymentMethods(paymentMethodSet).workingHoursMap(workingHoursMap).build(), 1000.0);
        map.put(
                ShopBuilder.create().shopId(2L).name("test 2 shop").description("test 2 shop description")
                        .paymentMethods(paymentMethodSet).workingHoursMap(workingHoursMap).build(), 2000.0);
        map.put(
                ShopBuilder.create().shopId(3L).name("test 3 shop").description("test 3 shop description")
                        .paymentMethods(paymentMethodSet).workingHoursMap(workingHoursMap).build(), 3000.0);
        return map;
    }
}
