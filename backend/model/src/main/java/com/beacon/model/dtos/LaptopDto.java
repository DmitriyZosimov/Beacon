package com.beacon.model.dtos;

import com.beacon.model.product.LaptopType;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class LaptopDto implements Serializable {

    private String computerId;

    private String brand;

    private String model;
    private String subModel;
    private String serialId;
    private String releaseYear;
    private LaptopType type;

    // Processor
    private String processorPlatform;
    private String processor;
    private String processorModel;
    private Integer processorNumber;
    private Integer processorThreadNumber;
    private Integer processorClockFrequency;
    private Integer processorMaxClockFrequency;
    private Integer processorTDP;

    // Construction
    private String caseMaterial;
    private String caseColor;
    private String lidMaterial;
    private String lidColor;
    private Boolean caseLighting;

    // Size
    private Double width;
    private Double length;
    private Double height;
    private Double weight;

    // Screen
    private Double screenSize;
    private String screenResolution;
    private Integer refreshRate;
    private String displayTechnology;
    private Integer displayBrightness;
    private String screenCover;
    private Boolean sensorDisplay;
    private String displayCharacteristics;

    // RAM
    private String ramType;
    private Integer ramClockFrequency;
    private Integer ram;
    private Integer ramMax;
    private Integer ramMaxSlots;
    private Integer ramFreeSlots;

    // Hard Disk
    private String storageType;
    private Integer storageCapacity;
    private Integer storageSlots;
    private String storageInterfaceType;
    private Boolean odd;

    // Graphics
    private Boolean discreteCoprocessor;
    private String graphicsModel;
    private Integer graphicsCapacity;
    private String graphicsCharacteristics;

    // Camera and Sound
    private Boolean camera;
    private Integer cameraResolution;
    private Boolean microphone;
    private Integer microphoneNumber;
    private Integer dynamicNumber;

    // Keyboard
    private Boolean numpad;
    private Boolean keyboardLighting;
    private String keyboardLightingColor;
    private Boolean touchpad;

    // Interfaces
    private Boolean nfc;
    private Boolean bluetooth;
    private String bluetoothVersion;
    private Boolean lan;
    private String lanVersion;
    private Boolean wifi;
    private String wifiVersion;
    private Boolean usb;
    private Integer usbNumber;
    private Boolean typeC;
    private Integer typeCNumber;
    private Boolean vga;
    private String vgaVersion;
    private Boolean hdmi;
    private String hdmiVersion;
    private Boolean jack;
    private Integer jackNumber;

    // Battery
    private Integer energyCapacity;
    private LocalTime workTime;
    private Boolean typeCCharge;

    // OS
    private Boolean os;
    private String osType;

    // images
    private ImageDto computerMainImage;
    private List<ImageDto> computerNotMainImages;

    public  void addNotMainImage(ImageDto imageDto) {
        if (this.computerNotMainImages == null) {
            this.computerNotMainImages = new ArrayList<>();
        }
        this.computerNotMainImages.add(imageDto);
    }
}
