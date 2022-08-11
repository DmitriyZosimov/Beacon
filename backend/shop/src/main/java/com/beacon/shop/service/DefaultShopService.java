package com.beacon.shop.service;

import com.beacon.shop.dao.ShopDao;
import com.beacon.model.shop.Shop;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Default implementation of {@code ShopService}
 */
@Transactional
@Service
public class DefaultShopService implements ShopService {

    private ShopDao shopDao;

    public DefaultShopService(ShopDao shopDao) {
        this.shopDao = shopDao;
    }


    @Override
    public Optional<Shop> findShopById(Long id) {
        return shopDao.findById(id);
    }
}
