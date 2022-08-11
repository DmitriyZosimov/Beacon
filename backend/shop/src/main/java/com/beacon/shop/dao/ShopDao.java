package com.beacon.shop.dao;

import com.beacon.model.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopDao extends JpaRepository<Shop, Long> {
}
