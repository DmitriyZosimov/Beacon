package com.beacon.model.order;

import com.beacon.model.builders.TaskBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskTest {

    @Test
    public void shouldCreateClone() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1L, null, "test1", 10L, 100.0, 1, LocalDate.now(), null));
        orders.add(new Order(2L, null, "test2", 11L, 200.0, 2, LocalDate.now(), null));
        orders.add(new Order(3L, null, "test3", 12L, 300.0, 2, LocalDate.now(), null));

        Task task = TaskBuilder.create()
                .withTaskId(1L)
                .withFirstName("first name")
                .withLastName("last name")
                .withEmail("email@email.com")
                .withPhoneNumber("+1111111111111")
                .withCity("Madrid")
                .withStreet("first street")
                .withBuilding("12")
                .withPorch(1)
                .withFloor(4)
                .withFlat(40)
                .withComment("I want ice cream")
                .withOrders(orders)
                .build();

        Task clonedTask = task.clone();
        Assertions.assertEquals(task.getTaskId(), clonedTask.getTaskId());
        Assertions.assertEquals(task.getFirstName(), clonedTask.getFirstName());
        Assertions.assertEquals(task.getLastName(), clonedTask.getLastName());
        Assertions.assertEquals(task.getEmail(), clonedTask.getEmail());
        Assertions.assertEquals(task.getPhoneNumber(), clonedTask.getPhoneNumber());
        Assertions.assertEquals(task.getCity(), clonedTask.getCity());
        Assertions.assertEquals(task.getStreet(), clonedTask.getStreet());
        Assertions.assertEquals(task.getBuilding(), clonedTask.getBuilding());
        Assertions.assertEquals(task.getPorch(), clonedTask.getPorch());
        Assertions.assertEquals(task.getFlat(), clonedTask.getFlat());
        Assertions.assertEquals(task.getFloor(), clonedTask.getFloor());
        Assertions.assertEquals(task.getComment(), clonedTask.getComment());
        Assertions.assertEquals(task.getState(), clonedTask.getState());
        Assertions.assertEquals(task.getIsDeliveryToAddress(), clonedTask.getIsDeliveryToAddress());
        Assertions.assertEquals(task.getOrders(), clonedTask.getOrders());

        task.setTaskId(2L);
        task.setFirstName("new first name");
        task.setLastName("new last name");
        task.setEmail("new email");
        task.setPhoneNumber("new phone number");
        task.setCity("new city");
        task.setState(TaskState.COMPLETED);
        task.setStreet("new street");
        task.setBuilding("100");
        task.setPorch(20);
        task.setFloor(21);
        task.setFlat(210);
        task.setComment("new comment");
        List<Order> newOrders = new ArrayList<>();
        newOrders.add(new Order(10L, null, "new test", 101L, 155.0, 1, LocalDate.now(), null));
        task.setOrders(newOrders);
        task.setIsDeliveryToAddress(false);

        Assertions.assertNotEquals(task.getTaskId(), clonedTask.getTaskId());
        Assertions.assertNotEquals(task.getFirstName(), clonedTask.getFirstName());
        Assertions.assertNotEquals(task.getLastName(), clonedTask.getLastName());
        Assertions.assertNotEquals(task.getEmail(), clonedTask.getEmail());
        Assertions.assertNotEquals(task.getPhoneNumber(), clonedTask.getPhoneNumber());
        Assertions.assertNotEquals(task.getCity(), clonedTask.getCity());
        Assertions.assertNotEquals(task.getStreet(), clonedTask.getStreet());
        Assertions.assertNotEquals(task.getBuilding(), clonedTask.getBuilding());
        Assertions.assertNotEquals(task.getPorch(), clonedTask.getPorch());
        Assertions.assertNotEquals(task.getFlat(), clonedTask.getFlat());
        Assertions.assertNotEquals(task.getFloor(), clonedTask.getFloor());
        Assertions.assertNotEquals(task.getComment(), clonedTask.getComment());
        Assertions.assertNotEquals(task.getState(), clonedTask.getState());
        Assertions.assertNotEquals(task.getIsDeliveryToAddress(), clonedTask.getIsDeliveryToAddress());
        Assertions.assertNotEquals(task.getOrders(), clonedTask.getOrders());
    }
}
