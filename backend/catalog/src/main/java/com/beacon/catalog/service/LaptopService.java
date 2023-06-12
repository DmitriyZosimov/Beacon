package com.beacon.catalog.service;

import com.beacon.model.dtos.LaptopDto;
import com.beacon.model.dtos.LaptopPreviewDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface LaptopService {

    /**
     * Get all {@code LaptopDto}
     * @return list of laptop dtos
     */
    List<LaptopDto> findAllDto();

    /**
     * Get all {@code LaptopPreviewDto}
     * @return set of laptop dtos
     */
    Set<LaptopPreviewDto> findAllLaptopPreviewDto();

    /**
     * Get {@code LaptopDto} by parameter {@code computerId}
     * @param computerId - id of laptop
     * @return {@code Optional} of LaptopDto
     */
    Optional<LaptopDto> findDtoByComputerId(String computerId);
}
