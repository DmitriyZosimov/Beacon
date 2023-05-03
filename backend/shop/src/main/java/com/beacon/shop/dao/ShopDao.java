package com.beacon.shop.dao;

import com.beacon.model.shop.Shop;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopDao extends JpaRepository<Shop, Long> {

    @EntityGraph(value = "shop-all", type = EntityGraph.EntityGraphType.FETCH)
    @Override
    List<Shop> findAll();

    @EntityGraph(value = "shop-all", type = EntityGraph.EntityGraphType.FETCH)
    @Override
    Optional<Shop> findById(Long aLong);
}
