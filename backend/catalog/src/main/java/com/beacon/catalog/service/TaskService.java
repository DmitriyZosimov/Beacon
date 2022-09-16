package com.beacon.catalog.service;

import com.beacon.model.order.Task;

import java.util.List;

public interface TaskService {

    /**
     * Find all tasks who have orders in this {@code Shop}
     * @param shopId shop identifier
     * @return list of {@code Task}
     */
    List<Task> findAllByShopIdInOrders(Long shopId);

    /**
     * Save task with orders
     * @param task incoming {@code Task}
     * @return true if task was saved, or Exception
     * @throws RuntimeException if task was not save
     */
    boolean saveTask(Task task);

    /**
     * Update incoming task in DB.
     * @param task incoming entity that will be updated
     * @return 1 if state was updated, 0 if is not.
     */
    int updateTaskState(Task task);
}
