package com.beacon.catalog.service;

import com.beacon.model.MobileDto;

import java.util.List;

/**
 * The service layout is to use one transaction for several connection to a database if it is needed.
 */
public interface MobileDtoService {

    /**
     * Find all mobile dtos
     * @return list with all mobile dtos in a database
     */
    List<MobileDto> findAllMobileDtos();
}
