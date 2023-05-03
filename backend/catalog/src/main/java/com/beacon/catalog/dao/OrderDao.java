package com.beacon.catalog.dao;

import com.beacon.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order, Long> {

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("UPDATE Order ord SET ord.mobileId = :newMobileId WHERE ord.mobileId IN :oldMobileIds")
    int updateMobileIdInBatch(@Param("oldMobileIds") Iterable<String> oldMobileIds, @Param("newMobileId") String newMobileId);

    List<Order> findAllByMobileIdIn(Iterable<String> ids);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("DELETE FROM Order ord WHERE ord.mobileId IN :mobileIds")
    int deleteAllByMobileIdIn(@Param("mobileIds") Iterable<String> mobileIds);
}
