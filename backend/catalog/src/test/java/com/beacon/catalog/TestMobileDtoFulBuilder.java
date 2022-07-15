package com.beacon.catalog;

import com.beacon.model.MobileDtoFull;
import com.beacon.model.MobileDtoFullBuilder;

import java.io.File;

public interface TestMobileDtoFulBuilder {

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
    Integer length = 166;
    Integer width = 76;
    Integer height = 8;
    Integer weight = 189;
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

    default MobileDtoFull build() {
        return MobileDtoFullBuilder.create()
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
}
