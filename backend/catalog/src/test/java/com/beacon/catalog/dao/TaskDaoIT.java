package com.beacon.catalog.dao;

import com.beacon.catalog.TestTaskBuilder;
import com.beacon.catalog.config.DaoConfiguration;
import com.beacon.model.order.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@ContextConfiguration(classes = DaoConfiguration.class)
public class TaskDaoIT implements TestTaskBuilder {

    @Autowired
    TaskDao taskDao;

    @Test
    public void shouldReturnSavedTask() {
        Task task = taskDao.saveAndFlush(buildTaskBeforeSave());
        Assertions.assertNotNull(task.getTaskId());
        task.getOrders().forEach(order -> Assertions.assertNotNull(order.getOrderId()));
    }

    @Test
    public void shouldReturnSavedTaskByFindingById() {
        Optional<Task> foundTask = taskDao.findById(1L);
        Assertions.assertNotNull(foundTask.get());
        Assertions.assertEquals(1L, foundTask.get().getTaskId());
    }

    @Test
    public void shouldReturnTasksWithOrdersWhereShopIdEqualsIncomingShopId() {
        List<Task> tasks = taskDao.findAllByShopIdInOrders(1L);
        Assertions.assertFalse(tasks.isEmpty());
        tasks.forEach(task -> {
            task.getOrders().forEach(order -> Assertions.assertEquals(1L, order.getShopId()));
        });
    }
}
