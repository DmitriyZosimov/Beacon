package com.beacon.catalog.dao;

import com.beacon.model.order.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDao extends JpaRepository<Task, Long> {

    /**
     * Find all tasks who have orders in definite shop.
     * First find all orders in this shop. And then join with all Tasks.
     * @param shopId incoming shop identifier.
     * @return list of Tasks.
     */
    @Query(value = "SELECT * FROM task t WHERE t.task_id IN "
            + "(SELECT o.task_id FROM orders o WHERE o.shop_id=:shop_id)",
            nativeQuery = true)
    List<Task> findAllByShopIdInOrders(@Param("shop_id") Long shopId);
}
