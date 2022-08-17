package com.beacon.catalog.service;

import com.beacon.model.Mobile;

import java.util.List;

/**
 * The service layout is to use one transaction for several connection to a database if it is needed.
 */
public interface MobileService {

    /**
     * Find all mobiles
     *
     * @return list with all mobiles in a database
     */
    List<Mobile> findAllMobiles();
}
