package com.beacon.model.dtos;

import com.beacon.model.product.ComputerMainImage;
import com.beacon.model.product.LaptopType;

import java.util.List;

public interface LaptopPreviewDto {

    String getComputerId();
    String getBrand();
    String getModel();
    String getSubModel();
    String getSerialId();
    LaptopType getType();
    byte[] getImage();

}
