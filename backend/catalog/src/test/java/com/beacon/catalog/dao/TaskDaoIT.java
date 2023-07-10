package com.beacon.catalog.dao;

import com.beacon.catalog.TestConfig;
import com.beacon.catalog.TestTaskBuilder;
import com.beacon.catalog.config.DaoConfiguration;
import com.beacon.model.order.Task;
import com.beacon.model.order.TaskState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

@DataJpaTest
@ContextConfiguration(classes = {DaoConfiguration.class, TestConfig.class})
public class TaskDaoIT implements TestTaskBuilder {

    @Autowired
    TaskDao taskDao;

    @Test
    public void shouldReturnOrderedListOfTask() {
        AtomicReference<TaskState> currentState = new AtomicReference(TaskState.NEW);
        AtomicLong currentTaskId = new AtomicLong(0L);
        long shopId = 1L;
        List<Task> tasks = taskDao.findAllByShopIdInOrders(shopId);
        Assertions.assertFalse(tasks.isEmpty());
        tasks.forEach(task -> {
            if (!task.getState().equals(currentState.get())) {
                if (TaskState.NEW.equals(currentState.get())) {
                    Assertions.assertEquals(TaskState.IN_PROGRESS, task.getState());
                } else if (TaskState.IN_PROGRESS.equals(currentState.get())) {
                    Assertions.assertEquals(TaskState.COMPLETED, task.getState());
                } else if (TaskState.COMPLETED.equals(currentState.get())) {
                    Assertions.assertEquals(TaskState.CANCELLED, task.getState());
                }
                currentState.set(task.getState());
                currentTaskId.set(0L);
            } else {
                Assertions.assertTrue(currentTaskId.get() <= task.getTaskId());
                currentTaskId.set(task.getTaskId());
            }
        });
    }

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

    @Test
    public void shouldUpdateStateByTaskId() {
        Optional<Task> optionalTask = taskDao.findById(1L);
        Assertions.assertTrue(optionalTask.isPresent());

        Task task = optionalTask.get();
        Assertions.assertEquals(1, taskDao.updateStateByTaskId(task.getTaskId(), TaskState.COMPLETED));
    }
}
