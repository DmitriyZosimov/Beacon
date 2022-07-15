package com.beacon.model;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * MobileDtoFullBuilder is helpful for creating test.
 */
public class MobileDtoFullBuilder {

    private static MobileDtoFullBuilder INSTANCE = new MobileDtoFullBuilder();
    private String mobileId;
    private String brand;
    private String model;
    private String os;
    private String screenSize;
    private String displayResolution;
    private String displayTechnology;
    private Integer ram;
    private Integer storageCapacity;
    private String chipsetModel;
    private String cameraResolution;
    private String simCardSlot;
    private Integer battery;
    private String color;
    private String releaseYear;
    private String type;
    private String osVersion;
    private Integer processorClockFrequency;
    private Integer coresNumber;
    private Integer technicalProcess;
    private String housingMaterial;
    private String simFormat;
    private Integer length;
    private Integer width;
    private Integer height;
    private Integer weight;
    private Integer mainCamerasNumber;
    private Boolean builtInFlash;
    private Boolean automaticFocus;
    private Boolean opticalStabilization;
    private Boolean mainCamera;
    private String mainCameraAperture;
    private Boolean frontCamera;
    private String frontCameraResolution;
    private String frontCameraAperture;
    private Boolean gps;
    private Boolean glonass;
    private Boolean beidou;
    private Boolean edge;
    private Boolean hspa;
    private Boolean hspaPlus;
    private Boolean lte;
    private Boolean fiveG;
    private Boolean bluetooth;
    private String bluetoothVersion;
    private Boolean audioOutput;
    private String audioOutputVersion;
    private Boolean wifi;
    private String wifiVersion;
    private String connection;
    private Boolean nfc;
    private String batteryType;
    private String chargeTime;
    private MobileMainImage mainImage;
    private List<MobileNotMainImage> notMainImages;

    public static MobileDtoFullBuilder create() {
        return INSTANCE;
    }

    public MobileDtoFullBuilder setMobileId(String mobileId) {
        this.mobileId = mobileId;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setBrand(String brand) {
        this.brand = brand;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setModel(String model) {
        this.model = model;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setOs(String os) {
        this.os = os;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setScreenSize(String screenSize) {
        this.screenSize = screenSize;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setDisplayResolution(String displayResolution) {
        this.displayResolution = displayResolution;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setDisplayTechnology(String displayTechnology) {
        this.displayTechnology = displayTechnology;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setRam(Integer ram) {
        this.ram = ram;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setStorageCapacity(Integer storageCapacity) {
        this.storageCapacity = storageCapacity;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setChipsetModel(String chipsetModel) {
        this.chipsetModel = chipsetModel;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setCameraResolution(String cameraResolution) {
        this.cameraResolution = cameraResolution;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setSimCardSlot(String simCardSlot) {
        this.simCardSlot = simCardSlot;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setBattery(Integer battery) {
        this.battery = battery;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setColor(String color) {
        this.color = color;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setType(String type) {
        this.type = type;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setOsVersion(String osVersion) {
        this.osVersion = osVersion;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setProcessorClockFrequency(Integer processorClockFrequency) {
        this.processorClockFrequency = processorClockFrequency;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setCoresNumber(Integer coresNumber) {
        this.coresNumber = coresNumber;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setTechnicalProcess(Integer technicalProcess) {
        this.technicalProcess = technicalProcess;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setHousingMaterial(String housingMaterial) {
        this.housingMaterial = housingMaterial;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setSimFormat(String simFormat) {
        this.simFormat = simFormat;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setLength(Integer length) {
        this.length = length;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setWidth(Integer width) {
        this.width = width;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setHeight(Integer height) {
        this.height = height;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setWeight(Integer weight) {
        this.weight = weight;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setMainCamerasNumber(Integer mainCamerasNumber) {
        this.mainCamerasNumber = mainCamerasNumber;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setBuiltInFlash(Boolean builtInFlash) {
        this.builtInFlash = builtInFlash;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setAutomaticFocus(Boolean automaticFocus) {
        this.automaticFocus = automaticFocus;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setOpticalStabilization(Boolean opticalStabilization) {
        this.opticalStabilization = opticalStabilization;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setMainCamera(Boolean mainCamera) {
        this.mainCamera = mainCamera;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setMainCameraAperture(String mainCameraAperture) {
        this.mainCameraAperture = mainCameraAperture;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setFrontCamera(Boolean frontCamera) {
        this.frontCamera = frontCamera;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setFrontCameraResolution(String frontCameraResolution) {
        this.frontCameraResolution = frontCameraResolution;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setFrontCameraAperture(String frontCameraAperture) {
        this.frontCameraAperture = frontCameraAperture;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setGps(Boolean gps) {
        this.gps = gps;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setGlonass(Boolean glonass) {
        this.glonass = glonass;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setBeidou(Boolean beidou) {
        this.beidou = beidou;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setEdge(Boolean edge) {
        this.edge = edge;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setHspa(Boolean hspa) {
        this.hspa = hspa;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setHspaPlus(Boolean hspaPlus) {
        this.hspaPlus = hspaPlus;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setLte(Boolean lte) {
        this.lte = lte;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setFiveG(Boolean fiveG) {
        this.fiveG = fiveG;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setBluetoothVersion(String bluetoothVersion) {
        this.bluetoothVersion = bluetoothVersion;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setAudioOutput(Boolean audioOutput) {
        this.audioOutput = audioOutput;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setAudioOutputVersion(String audioOutputVersion) {
        this.audioOutputVersion = audioOutputVersion;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setWifi(Boolean wifi) {
        this.wifi = wifi;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setWifiVersion(String wifiVersion) {
        this.wifiVersion = wifiVersion;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setConnection(String connection) {
        this.connection = connection;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setNfc(Boolean nfc) {
        this.nfc = nfc;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setBatteryType(String batteryType) {
        this.batteryType = batteryType;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setChargeTime(String chargeTime) {
        this.chargeTime = chargeTime;
        return INSTANCE;
    }

    public MobileDtoFullBuilder setMainImage(File file) {
        this.mainImage = new MobileMainImage();
        this.mainImage.setImage(readImage(file));
        return INSTANCE;
    }

    public MobileDtoFullBuilder setNotMainImages(File... files) {
        this.notMainImages = Arrays.stream(files).map(file -> {
            MobileNotMainImage image = new MobileNotMainImage();
            image.setImage(readImage(file));
            return image;
        }).collect(LinkedList::new, LinkedList::offer, LinkedList::addAll);
        return INSTANCE;
    }

    public MobileDtoFull build() {
        MobileDtoFull mobileDtoFull = new MobileDtoFull();
        mobileDtoFull.setMobileId(this.mobileId);
        mobileDtoFull.setBrand(this.brand);
        mobileDtoFull.setModel(this.model);
        mobileDtoFull.setOs(this.os);
        mobileDtoFull.setScreenSize(this.screenSize);
        mobileDtoFull.setDisplayResolution(this.displayResolution);
        mobileDtoFull.setDisplayTechnology(this.displayTechnology);
        mobileDtoFull.setRam(this.ram);
        mobileDtoFull.setStorageCapacity(this.storageCapacity);
        mobileDtoFull.setChipsetModel(this.chipsetModel);
        mobileDtoFull.setCameraResolution(this.cameraResolution);
        mobileDtoFull.setSimCardSlot(this.simCardSlot);
        mobileDtoFull.setBattery(this.battery);
        mobileDtoFull.setColor(this.color);
        mobileDtoFull.setReleaseYear(this.releaseYear);
        mobileDtoFull.setType(this.type);
        mobileDtoFull.setOsVersion(this.osVersion);
        mobileDtoFull.setProcessorClockFrequency(this.processorClockFrequency);
        mobileDtoFull.setCoresNumber(this.coresNumber);
        mobileDtoFull.setTechnicalProcess(this.technicalProcess);
        mobileDtoFull.setHousingMaterial(this.housingMaterial);
        mobileDtoFull.setSimFormat(this.simFormat);
        mobileDtoFull.setLength(this.length);
        mobileDtoFull.setWidth(this.width);
        mobileDtoFull.setHeight(this.height);
        mobileDtoFull.setWeight(this.weight);
        mobileDtoFull.setMainCamerasNumber(this.mainCamerasNumber);
        mobileDtoFull.setBuiltInFlash(this.builtInFlash);
        mobileDtoFull.setAutomaticFocus(this.automaticFocus);
        mobileDtoFull.setOpticalStabilization(this.opticalStabilization);
        mobileDtoFull.setMainCamera(this.mainCamera);
        mobileDtoFull.setMainCameraAperture(this.mainCameraAperture);
        mobileDtoFull.setFrontCamera(this.frontCamera);
        mobileDtoFull.setFrontCameraResolution(this.frontCameraResolution);
        mobileDtoFull.setFrontCameraAperture(this.frontCameraAperture);
        mobileDtoFull.setGps(this.gps);
        mobileDtoFull.setGlonass(this.glonass);
        mobileDtoFull.setBeidou(this.beidou);
        mobileDtoFull.setEdge(this.edge);
        mobileDtoFull.setHspa(this.hspa);
        mobileDtoFull.setHspaPlus(this.hspaPlus);
        mobileDtoFull.setLte(this.lte);
        mobileDtoFull.setFiveG(this.fiveG);
        mobileDtoFull.setBluetooth(this.bluetooth);
        mobileDtoFull.setBluetoothVersion(this.bluetoothVersion);
        mobileDtoFull.setAudioOutput(this.audioOutput);
        mobileDtoFull.setAudioOutputVersion(this.audioOutputVersion);
        mobileDtoFull.setWifi(this.wifi);
        mobileDtoFull.setWifiVersion(this.wifiVersion);
        mobileDtoFull.setConnection(this.connection);
        mobileDtoFull.setNfc(this.nfc);
        mobileDtoFull.setBatteryType(this.batteryType);
        mobileDtoFull.setChargeTime(this.chargeTime);
        mobileDtoFull.setMainImage(this.mainImage);
        this.mainImage.setMobileDto(mobileDtoFull);

        mobileDtoFull.setNotMainImages(this.notMainImages);
        this.notMainImages.forEach(image -> image.setMobileDtoFull(mobileDtoFull));
        return mobileDtoFull;
    }

    private byte[] readImage(File file) {
        byte[] image = null;
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            image = inputStream.readAllBytes();
        } catch (FileNotFoundException e) {
            System.err.println("File was not found: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
