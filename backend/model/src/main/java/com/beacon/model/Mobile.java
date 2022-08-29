package com.beacon.model;

import com.beacon.model.tools.ToStringTool;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Mobile is a model with small information of mobile.
 */

@Entity
@Table(name = "mobile")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
public class Mobile {

    @Id
    @Column(name = "mobile_id", nullable = false, unique = true)
    private String mobileId;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "os")
    private String os;

    @Column(name = "screen_size")
    private String screenSize;

    @Column(name = "display_resolution")
    private String displayResolution;

    @Column(name = "display_technology")
    private String displayTechnology;

    @Column(name = "ram")
    private Integer ram;

    @Column(name = "storage_capacity")
    private Integer storageCapacity;

    @Column(name = "chipset_model")
    private String chipsetModel;

    @Column(name = "camera_resolution")
    private String cameraResolution;

    @Column(name = "sim_card_slot")
    private String simCardSlot;

    @Column(name = "battery")
    private Integer battery;

    @Column(name = "color")
    private String color;

    @Column(name = "release_year")
    private String releaseYear;

    @OneToOne(mappedBy = "mobile", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private MobileMainImage mainImage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mobile mobile = (Mobile) o;

        if (mobileId != null ? !mobileId.equals(mobile.mobileId) : mobile.mobileId != null) return false;
        if (brand != null ? !brand.equals(mobile.brand) : mobile.brand != null) return false;
        if (model != null ? !model.equals(mobile.model) : mobile.model != null) return false;
        if (os != null ? !os.equals(mobile.os) : mobile.os != null) return false;
        if (screenSize != null ? !screenSize.equals(mobile.screenSize) : mobile.screenSize != null) return false;
        if (displayResolution != null ? !displayResolution.equals(mobile.displayResolution) : mobile.displayResolution != null)
            return false;
        if (displayTechnology != null ? !displayTechnology.equals(mobile.displayTechnology) : mobile.displayTechnology != null)
            return false;
        if (ram != null ? !ram.equals(mobile.ram) : mobile.ram != null) return false;
        if (storageCapacity != null ? !storageCapacity.equals(mobile.storageCapacity) : mobile.storageCapacity != null)
            return false;
        if (chipsetModel != null ? !chipsetModel.equals(mobile.chipsetModel) : mobile.chipsetModel != null)
            return false;
        if (cameraResolution != null ? !cameraResolution.equals(mobile.cameraResolution) : mobile.cameraResolution != null)
            return false;
        if (simCardSlot != null ? !simCardSlot.equals(mobile.simCardSlot) : mobile.simCardSlot != null)
            return false;
        if (battery != null ? !battery.equals(mobile.battery) : mobile.battery != null) return false;
        if (releaseYear != null ? !releaseYear.equals(mobile.releaseYear) : mobile.releaseYear != null)
            return false;
        return color != null ? color.equals(mobile.color) : mobile.color == null;
    }

    @Override
    public String toString() {
        return new ToStringTool<>(this).getString();
    }

    @Override
    public int hashCode() {
        int result = mobileId != null ? mobileId.hashCode() : 0;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (os != null ? os.hashCode() : 0);
        result = 31 * result + (screenSize != null ? screenSize.hashCode() : 0);
        result = 31 * result + (displayResolution != null ? displayResolution.hashCode() : 0);
        result = 31 * result + (displayTechnology != null ? displayTechnology.hashCode() : 0);
        result = 31 * result + (ram != null ? ram.hashCode() : 0);
        result = 31 * result + (storageCapacity != null ? storageCapacity.hashCode() : 0);
        result = 31 * result + (chipsetModel != null ? chipsetModel.hashCode() : 0);
        result = 31 * result + (cameraResolution != null ? cameraResolution.hashCode() : 0);
        result = 31 * result + (simCardSlot != null ? simCardSlot.hashCode() : 0);
        result = 31 * result + (battery != null ? battery.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (releaseYear != null ? releaseYear.hashCode() : 0);
        return result;
    }
}
