package com.beacon.model.product;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "laptop")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = "laptop-all", includeAllAttributes = true),
        @NamedEntityGraph(name = "laptop-test", attributeNodes = {
                @NamedAttributeNode("computerId"),
                @NamedAttributeNode("brand"),
                @NamedAttributeNode("model"),
                @NamedAttributeNode("subModel"),
                @NamedAttributeNode("serialId"),
                @NamedAttributeNode("releaseYear"),
                @NamedAttributeNode("type")
        })
})
public class Laptop extends Computer {

    @Id
    @Column(name = "computer_id", nullable = false, unique = true)
    private String computerId;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;
    private String subModel;

    @NaturalId
    @Column(name = "serial_id", nullable = false, updatable = false, unique = true)
    private String serialId;
    private String releaseYear;
    @Enumerated
    private LaptopType type;
    
    // Processor
    private String processorPlatform;
    private String processor;
    private String processorModel;
    private Integer processorNumber;
    private Integer processorThreadNumber;
    private Integer processorClockFrequency;
    private Integer processorMaxClockFrequency;
    @Column(name = "processor_tdp")
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

    @OneToOne(orphanRemoval = true, mappedBy = "computer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private ComputerMainImage computerMainImage;

    @OneToMany(mappedBy = "computer", orphanRemoval = true, cascade = CascadeType.ALL)
    @Where(clause = "main=2")
    @JsonManagedReference
    private List<ComputerNotMainImage> computerNotMainImages;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laptop laptop = (Laptop) o;

        if (!computerId.equals(laptop.computerId)) return false;
        return serialId.equals(laptop.serialId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(computerId, serialId);
    }
}