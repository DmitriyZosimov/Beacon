package com.beacon.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class ImageDto implements Serializable {

    private Long imageId;
    private byte[] image;
}
