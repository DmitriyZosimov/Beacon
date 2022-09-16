package com.beacon.catalog.service;

import com.beacon.catalog.dao.TaskDao;
import com.beacon.model.builders.OrderBuilder;
import com.beacon.model.builders.TaskBuilder;
import com.beacon.model.order.Order;
import com.beacon.model.order.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceMockito {

    @InjectMocks
    TaskServiceImpl taskService;
    @Mock
    TaskDao taskDao;

    @Test
    public void shouldSplitIntoSubTasksAndSaveThemSeparately() {
        Task savedTask1 = new Task();
        savedTask1.setTaskId(1L);

        Task savedTask2 = new Task();
        savedTask2.setTaskId(2L);

        when(taskDao.saveAllAndFlush(any())).then(invocation -> {
            AtomicLong taskIdGenerator = new AtomicLong(0L);
            AtomicLong orderIdGenerator = new AtomicLong(0L);
            List<Task> list = invocation.getArgument(0);
            list.forEach(task -> {
                task.getOrders().forEach(order -> {
                    Assertions.assertEquals(task, order.getTask());
                    order.setOrderId(orderIdGenerator.incrementAndGet());
                });
                task.setTaskId(taskIdGenerator.incrementAndGet());
            });
            return list;
        });

        Task incomingTask = TaskBuilder.create().build();
        List<Order> orders = new LinkedList<>();
        orders.add(OrderBuilder.create().withTask(incomingTask).withShopId(1L).withMobileId("mobile1").withPrice(100.0).withCount(1).build());
        orders.add(OrderBuilder.create().withTask(incomingTask).withShopId(2L).withMobileId("mobile2").withPrice(200.0).withCount(2).build());
        orders.add(OrderBuilder.create().withTask(incomingTask).withShopId(2L).withMobileId("mobile3").withPrice(300.0).withCount(2).build());
        incomingTask.setOrders(orders);
        Assertions.assertTrue(taskService.saveTask(incomingTask));

        verifyNoMoreInteractions(taskDao);
    }

    @Test
    public void shouldThrowException() {
        Task savedTask1 = new Task();
        savedTask1.setTaskId(1L);

        Task savedTask2 = new Task();
        savedTask2.setTaskId(2L);

        when(taskDao.saveAllAndFlush(any())).then(invocation -> {
            List<Task> list = invocation.getArgument(0);
            list.forEach(task -> {
                task.getOrders().forEach(order -> {
                    Assertions.assertEquals(task, order.getTask());
                });
            });
            return list;
        });

        Task incomingTask = TaskBuilder.create().build();
        List<Order> orders = new LinkedList<>();
        orders.add(OrderBuilder.create().withTask(incomingTask).withShopId(1L).withMobileId("mobile1").withPrice(100.0).withCount(1).build());
        orders.add(OrderBuilder.create().withTask(incomingTask).withShopId(2L).withMobileId("mobile2").withPrice(200.0).withCount(2).build());
        orders.add(OrderBuilder.create().withTask(incomingTask).withShopId(2L).withMobileId("mobile3").withPrice(300.0).withCount(2).build());
        incomingTask.setOrders(orders);
        Executable executable = () -> taskService.saveTask(incomingTask);
        Assertions.assertThrowsExactly(RuntimeException.class, executable);

        verifyNoMoreInteractions(taskDao);
    }
}
