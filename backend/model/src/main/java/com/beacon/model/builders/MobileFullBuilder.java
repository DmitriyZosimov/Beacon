package com.beacon.model.builders;

import com.beacon.model.MobileFull;
import com.beacon.model.MobileMainImage;
import com.beacon.model.MobileNotMainImage;

import java.io.*;
import java.util.*;

/**
 * MobileFullBuilder is helpful for creating test.
 */
public class MobileFullBuilder {

    private static MobileFullBuilder INSTANCE;
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
    private Double length;
    private Double width;
    private Double height;
    private Double weight;
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
    private Set<MobileNotMainImage> notMainImages;

    public static MobileFullBuilder create() {
        INSTANCE = new MobileFullBuilder();
        return INSTANCE;
    }

    public MobileFullBuilder setMobileId(String mobileId) {
        this.mobileId = mobileId;
        return INSTANCE;
    }

    public MobileFullBuilder setBrand(String brand) {
        this.brand = brand;
        return INSTANCE;
    }

    public MobileFullBuilder setModel(String model) {
        this.model = model;
        return INSTANCE;
    }

    public MobileFullBuilder setOs(String os) {
        this.os = os;
        return INSTANCE;
    }

    public MobileFullBuilder setScreenSize(String screenSize) {
        this.screenSize = screenSize;
        return INSTANCE;
    }

    public MobileFullBuilder setDisplayResolution(String displayResolution) {
        this.displayResolution = displayResolution;
        return INSTANCE;
    }

    public MobileFullBuilder setDisplayTechnology(String displayTechnology) {
        this.displayTechnology = displayTechnology;
        return INSTANCE;
    }

    public MobileFullBuilder setRam(Integer ram) {
        this.ram = ram;
        return INSTANCE;
    }

    public MobileFullBuilder setStorageCapacity(Integer storageCapacity) {
        this.storageCapacity = storageCapacity;
        return INSTANCE;
    }

    public MobileFullBuilder setChipsetModel(String chipsetModel) {
        this.chipsetModel = chipsetModel;
        return INSTANCE;
    }

    public MobileFullBuilder setCameraResolution(String cameraResolution) {
        this.cameraResolution = cameraResolution;
        return INSTANCE;
    }

    public MobileFullBuilder setSimCardSlot(String simCardSlot) {
        this.simCardSlot = simCardSlot;
        return INSTANCE;
    }

    public MobileFullBuilder setBattery(Integer battery) {
        this.battery = battery;
        return INSTANCE;
    }

    public MobileFullBuilder setColor(String color) {
        this.color = color;
        return INSTANCE;
    }

    public MobileFullBuilder setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
        return INSTANCE;
    }

    public MobileFullBuilder setType(String type) {
        this.type = type;
        return INSTANCE;
    }

    public MobileFullBuilder setOsVersion(String osVersion) {
        this.osVersion = osVersion;
        return INSTANCE;
    }

    public MobileFullBuilder setProcessorClockFrequency(Integer processorClockFrequency) {
        this.processorClockFrequency = processorClockFrequency;
        return INSTANCE;
    }

    public MobileFullBuilder setCoresNumber(Integer coresNumber) {
        this.coresNumber = coresNumber;
        return INSTANCE;
    }

    public MobileFullBuilder setTechnicalProcess(Integer technicalProcess) {
        this.technicalProcess = technicalProcess;
        return INSTANCE;
    }

    public MobileFullBuilder setHousingMaterial(String housingMaterial) {
        this.housingMaterial = housingMaterial;
        return INSTANCE;
    }

    public MobileFullBuilder setSimFormat(String simFormat) {
        this.simFormat = simFormat;
        return INSTANCE;
    }

    public MobileFullBuilder setLength(Double length) {
        this.length = length;
        return INSTANCE;
    }

    public MobileFullBuilder setWidth(Double width) {
        this.width = width;
        return INSTANCE;
    }

    public MobileFullBuilder setHeight(Double height) {
        this.height = height;
        return INSTANCE;
    }

    public MobileFullBuilder setWeight(Double weight) {
        this.weight = weight;
        return INSTANCE;
    }

    public MobileFullBuilder setMainCamerasNumber(Integer mainCamerasNumber) {
        this.mainCamerasNumber = mainCamerasNumber;
        return INSTANCE;
    }

    public MobileFullBuilder setBuiltInFlash(Boolean builtInFlash) {
        this.builtInFlash = builtInFlash;
        return INSTANCE;
    }

    public MobileFullBuilder setAutomaticFocus(Boolean automaticFocus) {
        this.automaticFocus = automaticFocus;
        return INSTANCE;
    }

    public MobileFullBuilder setOpticalStabilization(Boolean opticalStabilization) {
        this.opticalStabilization = opticalStabilization;
        return INSTANCE;
    }

    public MobileFullBuilder setMainCamera(Boolean mainCamera) {
        this.mainCamera = mainCamera;
        return INSTANCE;
    }

    public MobileFullBuilder setMainCameraAperture(String mainCameraAperture) {
        this.mainCameraAperture = mainCameraAperture;
        return INSTANCE;
    }

    public MobileFullBuilder setFrontCamera(Boolean frontCamera) {
        this.frontCamera = frontCamera;
        return INSTANCE;
    }

    public MobileFullBuilder setFrontCameraResolution(String frontCameraResolution) {
        this.frontCameraResolution = frontCameraResolution;
        return INSTANCE;
    }

    public MobileFullBuilder setFrontCameraAperture(String frontCameraAperture) {
        this.frontCameraAperture = frontCameraAperture;
        return INSTANCE;
    }

    public MobileFullBuilder setGps(Boolean gps) {
        this.gps = gps;
        return INSTANCE;
    }

    public MobileFullBuilder setGlonass(Boolean glonass) {
        this.glonass = glonass;
        return INSTANCE;
    }

    public MobileFullBuilder setBeidou(Boolean beidou) {
        this.beidou = beidou;
        return INSTANCE;
    }

    public MobileFullBuilder setEdge(Boolean edge) {
        this.edge = edge;
        return INSTANCE;
    }

    public MobileFullBuilder setHspa(Boolean hspa) {
        this.hspa = hspa;
        return INSTANCE;
    }

    public MobileFullBuilder setHspaPlus(Boolean hspaPlus) {
        this.hspaPlus = hspaPlus;
        return INSTANCE;
    }

    public MobileFullBuilder setLte(Boolean lte) {
        this.lte = lte;
        return INSTANCE;
    }

    public MobileFullBuilder setFiveG(Boolean fiveG) {
        this.fiveG = fiveG;
        return INSTANCE;
    }

    public MobileFullBuilder setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
        return INSTANCE;
    }

    public MobileFullBuilder setBluetoothVersion(String bluetoothVersion) {
        this.bluetoothVersion = bluetoothVersion;
        return INSTANCE;
    }

    public MobileFullBuilder setAudioOutput(Boolean audioOutput) {
        this.audioOutput = audioOutput;
        return INSTANCE;
    }

    public MobileFullBuilder setAudioOutputVersion(String audioOutputVersion) {
        this.audioOutputVersion = audioOutputVersion;
        return INSTANCE;
    }

    public MobileFullBuilder setWifi(Boolean wifi) {
        this.wifi = wifi;
        return INSTANCE;
    }

    public MobileFullBuilder setWifiVersion(String wifiVersion) {
        this.wifiVersion = wifiVersion;
        return INSTANCE;
    }

    public MobileFullBuilder setConnection(String connection) {
        this.connection = connection;
        return INSTANCE;
    }

    public MobileFullBuilder setNfc(Boolean nfc) {
        this.nfc = nfc;
        return INSTANCE;
    }

    public MobileFullBuilder setBatteryType(String batteryType) {
        this.batteryType = batteryType;
        return INSTANCE;
    }

    public MobileFullBuilder setChargeTime(String chargeTime) {
        this.chargeTime = chargeTime;
        return INSTANCE;
    }

    public MobileFullBuilder setMainImage(File file) {
        this.mainImage = new MobileMainImage();
        this.mainImage.setImage(readImage(file));
        return INSTANCE;
    }

    public MobileFullBuilder setNotMainImages(File... files) {
        this.notMainImages = Arrays.stream(files).map(file -> {
            MobileNotMainImage image = new MobileNotMainImage();
            image.setImage(readImage(file));
            return image;
        }).collect(LinkedHashSet::new, LinkedHashSet::add, LinkedHashSet::addAll);
        return INSTANCE;
    }

    public MobileFull build() {
        MobileFull mobileFull = new MobileFull();
        mobileFull.setMobileId(this.mobileId);
        mobileFull.setBrand(this.brand);
        mobileFull.setModel(this.model);
        mobileFull.setOs(this.os);
        mobileFull.setScreenSize(this.screenSize);
        mobileFull.setDisplayResolution(this.displayResolution);
        mobileFull.setDisplayTechnology(this.displayTechnology);
        mobileFull.setRam(this.ram);
        mobileFull.setStorageCapacity(this.storageCapacity);
        mobileFull.setChipsetModel(this.chipsetModel);
        mobileFull.setCameraResolution(this.cameraResolution);
        mobileFull.setSimCardSlot(this.simCardSlot);
        mobileFull.setBattery(this.battery);
        mobileFull.setColor(this.color);
        mobileFull.setReleaseYear(this.releaseYear);
        mobileFull.setType(this.type);
        mobileFull.setOsVersion(this.osVersion);
        mobileFull.setProcessorClockFrequency(this.processorClockFrequency);
        mobileFull.setCoresNumber(this.coresNumber);
        mobileFull.setTechnicalProcess(this.technicalProcess);
        mobileFull.setHousingMaterial(this.housingMaterial);
        mobileFull.setSimFormat(this.simFormat);
        mobileFull.setLength(this.length);
        mobileFull.setWidth(this.width);
        mobileFull.setHeight(this.height);
        mobileFull.setWeight(this.weight);
        mobileFull.setMainCamerasNumber(this.mainCamerasNumber);
        mobileFull.setBuiltInFlash(this.builtInFlash);
        mobileFull.setAutomaticFocus(this.automaticFocus);
        mobileFull.setOpticalStabilization(this.opticalStabilization);
        mobileFull.setMainCamera(this.mainCamera);
        mobileFull.setMainCameraAperture(this.mainCameraAperture);
        mobileFull.setFrontCamera(this.frontCamera);
        mobileFull.setFrontCameraResolution(this.frontCameraResolution);
        mobileFull.setFrontCameraAperture(this.frontCameraAperture);
        mobileFull.setGps(this.gps);
        mobileFull.setGlonass(this.glonass);
        mobileFull.setBeidou(this.beidou);
        mobileFull.setEdge(this.edge);
        mobileFull.setHspa(this.hspa);
        mobileFull.setHspaPlus(this.hspaPlus);
        mobileFull.setLte(this.lte);
        mobileFull.setFiveG(this.fiveG);
        mobileFull.setBluetooth(this.bluetooth);
        mobileFull.setBluetoothVersion(this.bluetoothVersion);
        mobileFull.setAudioOutput(this.audioOutput);
        mobileFull.setAudioOutputVersion(this.audioOutputVersion);
        mobileFull.setWifi(this.wifi);
        mobileFull.setWifiVersion(this.wifiVersion);
        mobileFull.setConnection(this.connection);
        mobileFull.setNfc(this.nfc);
        mobileFull.setBatteryType(this.batteryType);
        mobileFull.setChargeTime(this.chargeTime);
        mobileFull.setMainImage(this.mainImage);
        if (this.mainImage != null) {
            this.mainImage.setMobile(mobileFull);
        }

        mobileFull.setNotMainImages(this.notMainImages);
        if (this.notMainImages != null) {
            this.notMainImages.forEach(image -> image.setMobileFull(mobileFull));
        }
        return mobileFull;
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
