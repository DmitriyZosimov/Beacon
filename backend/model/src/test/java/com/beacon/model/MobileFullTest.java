package com.beacon.model;

import com.beacon.model.builders.MobileFullBuilder;

import java.io.File;

public interface MobileFullTest {

    final String mobileId = "mobileId";
    final String brand = "brand";
    final String model = "model";
    final String os = "os";
    final String screenSize = "screenSize";
    final String displayResolution = "displayResolution";
    final String displayTechnology = "displayTechnology";
    final Integer ram = 8;
    final Integer storageCapacity = 256;
    final String chipsetModel = "chipsetModel";
    final String cameraResolution = "cameraResolution";
    final String simCardSlot = "simCardSlot";
    final Integer battery = 4600;
    final String color = "color";
    final String releaseYear = "releaseYear";
    final String type = "type";
    final String osVersion = "osVersion";
    final Integer processorClockFrequency = 2700;
    final Integer coresNumber = 4;
    final Integer technicalProcess = 14;
    final String housingMaterial = "housingMaterial";
    final String simFormat = "simFormat";
    final Double length = 170.81;
    final Double width = 50.98;
    final Double height = 8.78;
    final Double weight = 150.41;
    final Integer mainCamerasNumber = 3;
    final Boolean builtInFlash = true;
    final Boolean automaticFocus = true;
    final Boolean opticalStabilization = true;
    final Boolean mainCamera = true;
    final String mainCameraAperture = "mainCameraAperture";
    final Boolean frontCamera = true;
    final String frontCameraResolution = "frontCameraResolution";
    final String frontCameraAperture = "frontCameraAperture";
    final Boolean gps = true;
    final Boolean glonass = true;
    final Boolean beidou = true;
    final Boolean edge = true;
    final Boolean hspa = true;
    final Boolean hspaPlus = true;
    final Boolean lte = true;
    final Boolean fiveG = true;
    final Boolean bluetooth = true;
    final String bluetoothVersion = "bluetoothVersion";
    final Boolean audioOutput = true;
    final String audioOutputVersion = "audioOutputVersion";
    final Boolean wifi = true;
    final String wifiVersion = "wifiVersion";
    final String connection = "connection";
    final Boolean nfc = true;
    final String batteryType = "batteryType";
    final String chargeTime = "chargeTime";
    final File FIRST_IMAGE = new File("src/test/resources/img/sample-phone.jpeg");
    final File SECOND_IMAGE = new File("src/test/resources/img/sample-phone-2.jpeg");
    final File THIRD_IMAGE = new File("src/test/resources/img/sample-phone-3.jpeg");
    
    default MobileFull getTestMobileFull() {
        return MobileFullBuilder.create()
                .setMobileId(mobileId)
                .setBrand(brand)
                .setModel(model)
                .setOs(os)
                .setScreenSize(screenSize)
                .setDisplayResolution(displayResolution)
                .setDisplayTechnology(displayTechnology)
                .setRam(ram)
                .setStorageCapacity(storageCapacity)
                .setChipsetModel(chipsetModel)
                .setCameraResolution(cameraResolution)
                .setSimCardSlot(simCardSlot)
                .setBattery(battery)
                .setColor(color)
                .setReleaseYear(releaseYear)
                .setType(type)
                .setOsVersion(osVersion)
                .setProcessorClockFrequency(processorClockFrequency)
                .setCoresNumber(coresNumber)
                .setTechnicalProcess(technicalProcess)
                .setHousingMaterial(housingMaterial)
                .setSimFormat(simFormat)
                .setLength(length)
                .setWidth(width)
                .setHeight(height)
                .setWeight(weight)
                .setMainCamerasNumber(mainCamerasNumber)
                .setBuiltInFlash(builtInFlash)
                .setAutomaticFocus(automaticFocus)
                .setOpticalStabilization(opticalStabilization)
                .setMainCamera(mainCamera)
                .setMainCameraAperture(mainCameraAperture)
                .setFrontCamera(frontCamera)
                .setFrontCameraResolution(frontCameraResolution)
                .setFrontCameraAperture(frontCameraAperture)
                .setGps(gps)
                .setGlonass(glonass)
                .setBeidou(beidou)
                .setEdge(edge)
                .setHspa(hspa)
                .setHspaPlus(hspaPlus)
                .setLte(lte)
                .setFiveG(fiveG)
                .setBluetooth(bluetooth)
                .setBluetoothVersion(bluetoothVersion)
                .setAudioOutput(audioOutput)
                .setAudioOutputVersion(audioOutputVersion)
                .setWifi(wifi)
                .setWifiVersion(wifiVersion)
                .setConnection(connection)
                .setNfc(nfc)
                .setBatteryType(batteryType)
                .setChargeTime(chargeTime)
                .setMainImage(FIRST_IMAGE)
                .setNotMainImages(SECOND_IMAGE, THIRD_IMAGE)
                .build();
    }
}
