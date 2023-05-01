package com.beacon.model;

import com.beacon.model.shop.Shop;
import com.beacon.model.tools.ToStringTool;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

/**
 * Contains additional information of mobile.
 */

@Entity
@Table(name = "mobile_full")
@Data
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
    @OneToMany(mappedBy = "mobileFull", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @Where(clause = "main=2")
    @JsonManagedReference
    private List<MobileNotMainImage> notMainImages;

    @ElementCollection
    @CollectionTable(name = "offers", joinColumns = @JoinColumn(name = "mobile_id"))
    @MapKeyJoinColumn(name = "shop_id")
    @Column(name = "price")
    private Map<Shop, Double> offers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MobileFull that = (MobileFull) o;

        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (osVersion != null ? !osVersion.equals(that.osVersion) : that.osVersion != null) return false;
        if (processorClockFrequency != null ? !processorClockFrequency.equals(that.processorClockFrequency) : that.processorClockFrequency != null)
            return false;
        if (coresNumber != null ? !coresNumber.equals(that.coresNumber) : that.coresNumber != null) return false;
        if (technicalProcess != null ? !technicalProcess.equals(that.technicalProcess) : that.technicalProcess != null)
            return false;
        if (housingMaterial != null ? !housingMaterial.equals(that.housingMaterial) : that.housingMaterial != null)
            return false;
        if (simFormat != null ? !simFormat.equals(that.simFormat) : that.simFormat != null) return false;
        if (length != null ? !length.equals(that.length) : that.length != null) return false;
        if (width != null ? !width.equals(that.width) : that.width != null) return false;
        if (height != null ? !height.equals(that.height) : that.height != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (mainCamerasNumber != null ? !mainCamerasNumber.equals(that.mainCamerasNumber) : that.mainCamerasNumber != null)
            return false;
        if (builtInFlash != null ? !builtInFlash.equals(that.builtInFlash) : that.builtInFlash != null) return false;
        if (automaticFocus != null ? !automaticFocus.equals(that.automaticFocus) : that.automaticFocus != null)
            return false;
        if (opticalStabilization != null ? !opticalStabilization.equals(that.opticalStabilization) : that.opticalStabilization != null)
            return false;
        if (mainCamera != null ? !mainCamera.equals(that.mainCamera) : that.mainCamera != null) return false;
        if (mainCameraAperture != null ? !mainCameraAperture.equals(that.mainCameraAperture) : that.mainCameraAperture != null)
            return false;
        if (frontCamera != null ? !frontCamera.equals(that.frontCamera) : that.frontCamera != null) return false;
        if (frontCameraResolution != null ? !frontCameraResolution.equals(that.frontCameraResolution) : that.frontCameraResolution != null)
            return false;
        if (frontCameraAperture != null ? !frontCameraAperture.equals(that.frontCameraAperture) : that.frontCameraAperture != null)
            return false;
        if (gps != null ? !gps.equals(that.gps) : that.gps != null) return false;
        if (glonass != null ? !glonass.equals(that.glonass) : that.glonass != null) return false;
        if (beidou != null ? !beidou.equals(that.beidou) : that.beidou != null) return false;
        if (edge != null ? !edge.equals(that.edge) : that.edge != null) return false;
        if (hspa != null ? !hspa.equals(that.hspa) : that.hspa != null) return false;
        if (hspaPlus != null ? !hspaPlus.equals(that.hspaPlus) : that.hspaPlus != null) return false;
        if (lte != null ? !lte.equals(that.lte) : that.lte != null) return false;
        if (fiveG != null ? !fiveG.equals(that.fiveG) : that.fiveG != null) return false;
        if (bluetooth != null ? !bluetooth.equals(that.bluetooth) : that.bluetooth != null) return false;
        if (bluetoothVersion != null ? !bluetoothVersion.equals(that.bluetoothVersion) : that.bluetoothVersion != null)
            return false;
        if (audioOutput != null ? !audioOutput.equals(that.audioOutput) : that.audioOutput != null) return false;
        if (audioOutputVersion != null ? !audioOutputVersion.equals(that.audioOutputVersion) : that.audioOutputVersion != null)
            return false;
        if (wifi != null ? !wifi.equals(that.wifi) : that.wifi != null) return false;
        if (wifiVersion != null ? !wifiVersion.equals(that.wifiVersion) : that.wifiVersion != null) return false;
        if (connection != null ? !connection.equals(that.connection) : that.connection != null) return false;
        if (nfc != null ? !nfc.equals(that.nfc) : that.nfc != null) return false;
        if (batteryType != null ? !batteryType.equals(that.batteryType) : that.batteryType != null) return false;
        return chargeTime != null ? chargeTime.equals(that.chargeTime) : that.chargeTime == null;
    }

    @Override
    public String toString() {
        return new ToStringTool<>(this).getString();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (osVersion != null ? osVersion.hashCode() : 0);
        result = 31 * result + (processorClockFrequency != null ? processorClockFrequency.hashCode() : 0);
        result = 31 * result + (coresNumber != null ? coresNumber.hashCode() : 0);
        result = 31 * result + (technicalProcess != null ? technicalProcess.hashCode() : 0);
        result = 31 * result + (housingMaterial != null ? housingMaterial.hashCode() : 0);
        result = 31 * result + (simFormat != null ? simFormat.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (mainCamerasNumber != null ? mainCamerasNumber.hashCode() : 0);
        result = 31 * result + (builtInFlash != null ? builtInFlash.hashCode() : 0);
        result = 31 * result + (automaticFocus != null ? automaticFocus.hashCode() : 0);
        result = 31 * result + (opticalStabilization != null ? opticalStabilization.hashCode() : 0);
        result = 31 * result + (mainCamera != null ? mainCamera.hashCode() : 0);
        result = 31 * result + (mainCameraAperture != null ? mainCameraAperture.hashCode() : 0);
        result = 31 * result + (frontCamera != null ? frontCamera.hashCode() : 0);
        result = 31 * result + (frontCameraResolution != null ? frontCameraResolution.hashCode() : 0);
        result = 31 * result + (frontCameraAperture != null ? frontCameraAperture.hashCode() : 0);
        result = 31 * result + (gps != null ? gps.hashCode() : 0);
        result = 31 * result + (glonass != null ? glonass.hashCode() : 0);
        result = 31 * result + (beidou != null ? beidou.hashCode() : 0);
        result = 31 * result + (edge != null ? edge.hashCode() : 0);
        result = 31 * result + (hspa != null ? hspa.hashCode() : 0);
        result = 31 * result + (hspaPlus != null ? hspaPlus.hashCode() : 0);
        result = 31 * result + (lte != null ? lte.hashCode() : 0);
        result = 31 * result + (fiveG != null ? fiveG.hashCode() : 0);
        result = 31 * result + (bluetooth != null ? bluetooth.hashCode() : 0);
        result = 31 * result + (bluetoothVersion != null ? bluetoothVersion.hashCode() : 0);
        result = 31 * result + (audioOutput != null ? audioOutput.hashCode() : 0);
        result = 31 * result + (audioOutputVersion != null ? audioOutputVersion.hashCode() : 0);
        result = 31 * result + (wifi != null ? wifi.hashCode() : 0);
        result = 31 * result + (wifiVersion != null ? wifiVersion.hashCode() : 0);
        result = 31 * result + (connection != null ? connection.hashCode() : 0);
        result = 31 * result + (nfc != null ? nfc.hashCode() : 0);
        result = 31 * result + (batteryType != null ? batteryType.hashCode() : 0);
        result = 31 * result + (chargeTime != null ? chargeTime.hashCode() : 0);
        return result;

    }
}
