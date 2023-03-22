package com.beacon.model.dtos;

import com.beacon.model.MobileMainImage;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * It is a dto of {@code Mobile}. The dto includes all fields of {@code Mobile} and count of offers and minimal price.
 */
@Getter
@NoArgsConstructor
public class MobileDto {

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

    private Integer relevant;

    private MobileMainImage mainImage;

    private Long countOfOffers;

    private Double minimalPrice;

    public MobileDto(String mobileId, String brand, String model, String os, String screenSize, String displayResolution,
                     String displayTechnology, Integer ram, Integer storageCapacity, String chipsetModel,
                     String cameraResolution, String simCardSlot, Integer battery, String color, String releaseYear,
                     Integer relevant, Long imageId, byte[] image, Long countOfOffers, Double minimalPrice) {
        this.mobileId = mobileId;
        this.brand = brand;
        this.model = model;
        this.os = os;
        this.screenSize = screenSize;
        this.displayResolution = displayResolution;
        this.displayTechnology = displayTechnology;
        this.ram = ram;
        this.storageCapacity = storageCapacity;
        this.chipsetModel = chipsetModel;
        this.cameraResolution = cameraResolution;
        this.simCardSlot = simCardSlot;
        this.battery = battery;
        this.color = color;
        this.releaseYear = releaseYear;
        this.relevant = relevant;
        this.countOfOffers = countOfOffers;
        this.minimalPrice = minimalPrice;
        this.mainImage = new MobileMainImage(imageId, image);
    }
}
