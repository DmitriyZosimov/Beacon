package com.beacon.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class MobileDtoFullBuilderTest {

    private final String mobileId = "mobileId";
    private final String brand = "brand";
    private final String model = "model";
    private final String os = "os";
    private final String screenSize = "screenSize";
    private final String displayResolution = "displayResolution";
    private final String displayTechnology = "displayTechnology";
    private final Integer ram = 8;
    private final Integer storageCapacity = 256;
    private final String chipsetModel = "chipsetModel";
    private final String cameraResolution = "cameraResolution";
    private final String simCardSlot = "simCardSlot";
    private final Integer battery = 4600;
    private final String color = "color";
    private final String releaseYear = "releaseYear";
    private final String type = "type";
    private final String osVersion = "osVersion";
    private final Integer processorClockFrequency = 2700;
    private final Integer coresNumber = 4;
    private final Integer technicalProcess = 14;
    private final String housingMaterial = "housingMaterial";
    private final String simFormat = "simFormat";
    private final Integer length = 170;
    private final Integer width = 50;
    private final Integer height = 8;
    private final Integer weight = 150;
    private final Integer mainCamerasNumber = 3;
    private final Boolean builtInFlash = true;
    private final Boolean automaticFocus = true;
    private final Boolean opticalStabilization = true;
    private final Boolean mainCamera = true;
    private final String mainCameraAperture = "mainCameraAperture";
    private final Boolean frontCamera = true;
    private final String frontCameraResolution = "frontCameraResolution";
    private final String frontCameraAperture = "frontCameraAperture";
    private final Boolean gps = true;
    private final Boolean glonass = true;
    private final Boolean beidou = true;
    private final Boolean edge = true;
    private final Boolean hspa = true;
    private final Boolean hspaPlus = true;
    private final Boolean lte = true;
    private final Boolean fiveG = true;
    private final Boolean bluetooth = true;
    private final String bluetoothVersion = "bluetoothVersion";
    private final Boolean audioOutput = true;
    private final String audioOutputVersion = "audioOutputVersion";
    private final Boolean wifi = true;
    private final String wifiVersion = "wifiVersion";
    private final String connection = "connection";
    private final Boolean nfc = true;
    private final String batteryType = "batteryType";
    private final String chargeTime = "chargeTime";
    private final File FIRST_IMAGE = new File("src/test/resources/img/sample-phone.jpeg");
    private final File SECOND_IMAGE = new File("src/test/resources/img/sample-phone-2.jpeg");
    private final File THIRD_IMAGE = new File("src/test/resources/img/sample-phone-3.jpeg");

    @Test
    public void testCreatingMobileDtoFullByBuilder() {
        MobileDtoFull mobileDtoFull = MobileDtoFullBuilder.create()
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
                .setMainImage(FIRST_IMAGE)
                .setNotMainImages(SECOND_IMAGE, THIRD_IMAGE)
                .build();
        
        Assertions.assertEquals(this.mobileId, mobileDtoFull.getMobileId());
                Assertions.assertEquals(this.brand , mobileDtoFull.getBrand());
                Assertions.assertEquals(this.model , mobileDtoFull.getModel());
                Assertions.assertEquals(this.os , mobileDtoFull.getOs());
                Assertions.assertEquals(this.screenSize , mobileDtoFull.getScreenSize());
                Assertions.assertEquals(this.displayResolution , mobileDtoFull.getDisplayResolution());
                Assertions.assertEquals(this.displayTechnology , mobileDtoFull.getDisplayTechnology());
                Assertions.assertEquals(this.ram , mobileDtoFull.getRam());
                Assertions.assertEquals(this.storageCapacity , mobileDtoFull.getStorageCapacity());
                Assertions.assertEquals(this.chipsetModel , mobileDtoFull.getChipsetModel());
                Assertions.assertEquals(this.cameraResolution , mobileDtoFull.getCameraResolution());
                Assertions.assertEquals(this.simCardSlot , mobileDtoFull.getSimCardSlot());
                Assertions.assertEquals(this.battery , mobileDtoFull.getBattery());
                Assertions.assertEquals(this.color , mobileDtoFull.getColor());
                Assertions.assertEquals(this.releaseYear , mobileDtoFull.getReleaseYear());
                Assertions.assertEquals(this.type , mobileDtoFull.getType());
                Assertions.assertEquals(this.osVersion , mobileDtoFull.getOsVersion());
                Assertions.assertEquals(this.processorClockFrequency , mobileDtoFull.getProcessorClockFrequency());
                Assertions.assertEquals(this.coresNumber , mobileDtoFull.getCoresNumber());
                Assertions.assertEquals(this.technicalProcess , mobileDtoFull.getTechnicalProcess());
                Assertions.assertEquals(this.housingMaterial , mobileDtoFull.getHousingMaterial());
                Assertions.assertEquals(this.simFormat , mobileDtoFull.getSimFormat());
                Assertions.assertEquals(this.length , mobileDtoFull.getLength());
                Assertions.assertEquals(this.width , mobileDtoFull.getWidth());
                Assertions.assertEquals(this.height , mobileDtoFull.getHeight());
                Assertions.assertEquals(this.weight , mobileDtoFull.getWeight());
                Assertions.assertEquals(this.mainCamerasNumber , mobileDtoFull.getMainCamerasNumber());
                Assertions.assertEquals(this.builtInFlash , mobileDtoFull.getBuiltInFlash());
                Assertions.assertEquals(this.automaticFocus , mobileDtoFull.getAutomaticFocus());
                Assertions.assertEquals(this.opticalStabilization , mobileDtoFull.getOpticalStabilization());
                Assertions.assertEquals(this.mainCamera , mobileDtoFull.getMainCamera());
                Assertions.assertEquals(this.mainCameraAperture , mobileDtoFull.getMainCameraAperture());
                Assertions.assertEquals(this.frontCamera , mobileDtoFull.getFrontCamera());
                Assertions.assertEquals(this.frontCameraResolution , mobileDtoFull.getFrontCameraResolution());
                Assertions.assertEquals(this.frontCameraAperture , mobileDtoFull.getFrontCameraAperture());
                Assertions.assertEquals(this.gps , mobileDtoFull.getGps());
                Assertions.assertEquals(this.glonass , mobileDtoFull.getGlonass());
                Assertions.assertEquals(this.beidou , mobileDtoFull.getBeidou());
                Assertions.assertEquals(this.edge , mobileDtoFull.getEdge());
                Assertions.assertEquals(this.hspa , mobileDtoFull.getHspa());
                Assertions.assertEquals(this.hspaPlus , mobileDtoFull.getHspaPlus());
                Assertions.assertEquals(this.lte , mobileDtoFull.getLte());
                Assertions.assertEquals(this.fiveG , mobileDtoFull.getFiveG());
                Assertions.assertEquals(this.bluetooth , mobileDtoFull.getBluetooth());
                Assertions.assertEquals(this.bluetoothVersion , mobileDtoFull.getBluetoothVersion());
                Assertions.assertEquals(this.audioOutput , mobileDtoFull.getAudioOutput());
                Assertions.assertEquals(this.audioOutputVersion , mobileDtoFull.getAudioOutputVersion());
                Assertions.assertEquals(this.wifi , mobileDtoFull.getWifi());
                Assertions.assertEquals(this.wifiVersion , mobileDtoFull.getWifiVersion());
                Assertions.assertEquals(this.connection , mobileDtoFull.getConnection());
                Assertions.assertEquals(this.nfc , mobileDtoFull.getNfc());
                Assertions.assertEquals(this.batteryType , mobileDtoFull.getBatteryType());
                Assertions.assertEquals(this.chargeTime , mobileDtoFull.getChargeTime());
                Assertions.assertNotNull(mobileDtoFull.getMainImage());
                Assertions.assertEquals(mobileDtoFull, mobileDtoFull.getMainImage().getMobileDto());
                Assertions.assertNotNull(mobileDtoFull.getNotMainImages());
                mobileDtoFull.getNotMainImages().forEach(image -> {
                    Assertions.assertEquals(mobileDtoFull, image.getMobileDtoFull());
                });

    }
}
