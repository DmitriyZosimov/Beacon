package com.beacon.shop.service;

import com.beacon.shop.model.Shop;

import java.util.Optional;

/**
 * A service class is to allow work with shops in database.
 */
public interface ShopService {

    /**
     * Attempt to find a shop by his id.
     *
     * @param id identification number.
     * @return {@code Optional} with {@code Shop} if find, or without it.
     */
    Optional<Shop> findShopById(Long id);
}
