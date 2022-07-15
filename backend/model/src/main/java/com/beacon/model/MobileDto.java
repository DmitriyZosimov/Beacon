package com.beacon.model;

import com.beacon.model.tools.ToStringTool;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Mobile Dto is a model with small information of mobile. It must be the same like MobileDto class in mobile_dto.ts in
 * frontend in project Market.
 */

@Entity
@Table(name = "mobile_dto")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
public class MobileDto {

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

    @OneToOne(mappedBy = "mobileDto", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private MobileMainImage mainImage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MobileDto mobileDto = (MobileDto) o;

        if (mobileId != null ? !mobileId.equals(mobileDto.mobileId) : mobileDto.mobileId != null) return false;
        if (brand != null ? !brand.equals(mobileDto.brand) : mobileDto.brand != null) return false;
        if (model != null ? !model.equals(mobileDto.model) : mobileDto.model != null) return false;
        if (os != null ? !os.equals(mobileDto.os) : mobileDto.os != null) return false;
        if (screenSize != null ? !screenSize.equals(mobileDto.screenSize) : mobileDto.screenSize != null) return false;
        if (displayResolution != null ? !displayResolution.equals(mobileDto.displayResolution) : mobileDto.displayResolution != null)
            return false;
        if (displayTechnology != null ? !displayTechnology.equals(mobileDto.displayTechnology) : mobileDto.displayTechnology != null)
            return false;
        if (ram != null ? !ram.equals(mobileDto.ram) : mobileDto.ram != null) return false;
        if (storageCapacity != null ? !storageCapacity.equals(mobileDto.storageCapacity) : mobileDto.storageCapacity != null)
            return false;
        if (chipsetModel != null ? !chipsetModel.equals(mobileDto.chipsetModel) : mobileDto.chipsetModel != null)
            return false;
        if (cameraResolution != null ? !cameraResolution.equals(mobileDto.cameraResolution) : mobileDto.cameraResolution != null)
            return false;
        if (simCardSlot != null ? !simCardSlot.equals(mobileDto.simCardSlot) : mobileDto.simCardSlot != null)
            return false;
        if (battery != null ? !battery.equals(mobileDto.battery) : mobileDto.battery != null) return false;
        return color != null ? color.equals(mobileDto.color) : mobileDto.color == null;
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
        return result;
    }
}
