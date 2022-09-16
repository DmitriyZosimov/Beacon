package com.beacon.model.builder;

import com.beacon.model.builders.TaskBuilder;
import com.beacon.model.order.Task;
import com.beacon.model.order.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TaskBuilderTest {

    @Test
    public void shouldReturnTaskWithAllInputValues() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order());
        orders.add(new Order());
        orders.add(new Order());

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

        Assertions.assertEquals(1L, task.getTaskId());
        Assertions.assertTrue(task.getIsDeliveryToAddress());
        Assertions.assertEquals("first name", task.getFirstName());
        Assertions.assertEquals("last name", task.getLastName());
        Assertions.assertEquals("email@email.com", task.getEmail());
        Assertions.assertEquals("+1111111111111", task.getPhoneNumber());
        Assertions.assertEquals("Madrid", task.getCity());
        Assertions.assertEquals("first street", task.getStreet());
        Assertions.assertEquals("12", task.getBuilding());
        Assertions.assertEquals(1, task.getPorch());
        Assertions.assertEquals(4, task.getFloor());
        Assertions.assertEquals(40, task.getFlat());
        Assertions.assertEquals("I want ice cream", task.getComment());
        Assertions.assertEquals(3, task.getOrders().size());
    }
}
