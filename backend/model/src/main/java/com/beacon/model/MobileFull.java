package com.beacon.model;

import com.beacon.model.shop.Shop;
import com.beacon.model.tools.ToStringTool;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

/**
 * Contains additional information of mobile.
 */

@Entity
@Table(name = "mobile_full")
@NamedEntityGraph(name = "mobile-all", includeAllAttributes = true)
@Getter
@Setter
@NoArgsConstructor
public class MobileFull extends Mobile {

    @Column(name = "type")
    private String type;

    @Column(name = "os_version")
    private String osVersion;

    @Column(name = "processor_clock_frequency")
    private Integer processorClockFrequency;

    @Column(name = "cores_number")
    private Integer coresNumber;

    @Column(name = "technical_process")
    private Integer technicalProcess;

    @Column(name = "housing_material")
    private String housingMaterial;

    @Column(name = "sim_format")
    private String simFormat;

    @Column(name = "length")
    private Double length;

    @Column(name = "width")
    private Double width;

    @Column(name = "height")
    private Double height;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "main_cameras_number")
    private Integer mainCamerasNumber;

    @Column(name = "built_in_flash")
    private Boolean builtInFlash;

    @Column(name = "automatic_focus")
    private Boolean automaticFocus;

    @Column(name = "optical_stabilization")
    private Boolean opticalStabilization;

    @Column(name = "main_camera")
    private Boolean mainCamera;

    @Column(name = "main_camera_aperture")
    private String mainCameraAperture;

    @Column(name = "front_camera")
    private Boolean frontCamera;

    @Column(name = "front_camera_resolution")
    private String frontCameraResolution;

    @Column(name = "front_camera_aperture")
    private String frontCameraAperture;

    @Column(name = "gps")
    private Boolean gps;

    @Column(name = "glonass")
    private Boolean glonass;

    @Column(name = "beidou")
    private Boolean beidou;

    @Column(name = "edge")
    private Boolean edge;

    @Column(name = "hspa")
    private Boolean hspa;

    @Column(name = "hspa_plus")
    private Boolean hspaPlus;

    @Column(name = "lte")
    private Boolean lte;

    @Column(name = "five_g")
    private Boolean fiveG;

    @Column(name = "bluetooth")
    private Boolean bluetooth;

    @Column(name = "bluetooth_version")
    private String bluetoothVersion;

    @Column(name = "audio_output")
    private Boolean audioOutput;

    @Column(name = "audio_output_version")
    private String audioOutputVersion;

    @Column(name = "wifi")
    private Boolean wifi;

    @Column(name = "wifi_version")
    private String wifiVersion;

    @Column(name = "connection")
    private String connection;

    @Column(name = "nfc")
    private Boolean nfc;

    @Column(name = "battery_type")
    private String batteryType;

    @Column(name = "charge_time")
    private String chargeTime;

    // orphanRemoval = true is best practice by "Spring Boot Persistence Best Practices (Anghel Leonard)"
    @OneToMany(mappedBy = "mobileFull", cascade = CascadeType.ALL, orphanRemoval = true)
    @Where(clause = "main=2")
    @JsonManagedReference
    private Set<MobileNotMainImage> notMainImages;

    @ElementCollection
    @CollectionTable(name = "offers", joinColumns = @JoinColumn(name = "mobile_id"))
    @MapKeyJoinColumn(name = "shop_id")
    @Column(name = "price")
    private Map<Shop, Double> offers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

    @Override
    public String toString() {
        return new ToStringTool<>(this).getString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
