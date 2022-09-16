package com.beacon.model.builders;

import com.beacon.model.order.Order;
import com.beacon.model.order.Task;
import com.beacon.model.order.TaskState;

import java.util.List;

public class TaskBuilder {

    private static TaskBuilder INSTANCE;

    private Long taskId;
    private Boolean isDeliveryToAddress = true;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String city;
    private String street;
    private String building;
    private Integer flat;
    private Integer porch;
    private Integer floor;
    private String comment;
    private TaskState state = TaskState.NEW;
    private List<Order> orders;

    public static TaskBuilder create() {
        INSTANCE = new TaskBuilder();
        return INSTANCE;
    }

    public TaskBuilder withTaskId(Long taskId) {
        this.taskId = taskId;
        return INSTANCE;
    }

    public TaskBuilder withDeliveryToAddress(Boolean deliveryToAddress) {
        isDeliveryToAddress = deliveryToAddress;
        return INSTANCE;
    }

    public TaskBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return INSTANCE;
    }

    public TaskBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return INSTANCE;
    }

    public TaskBuilder withEmail(String email) {
        this.email = email;
        return INSTANCE;
    }

    public TaskBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return INSTANCE;
    }

    public TaskBuilder withCity(String city) {
        this.city = city;
        return INSTANCE;
    }

    public TaskBuilder withStreet(String street) {
        this.street = street;
        return INSTANCE;
    }

    public TaskBuilder withBuilding(String building) {
        this.building = building;
        return INSTANCE;
    }

    public TaskBuilder withFlat(Integer flat) {
        this.flat = flat;
        return INSTANCE;
    }

    public TaskBuilder withPorch(Integer porch) {
        this.porch = porch;
        return INSTANCE;
    }

    public TaskBuilder withFloor(Integer floor) {
        this.floor = floor;
        return INSTANCE;
    }

    public TaskBuilder withComment(String comment) {
        this.comment = comment;
        return INSTANCE;
    }

    public TaskBuilder withOrders(List<Order> orders) {
        this.orders = orders;
        return INSTANCE;
    }

    public TaskBuilder withState(TaskState state) {
        this.state = state;
        return INSTANCE;
    }

    public Task build() {
        return new Task(taskId, isDeliveryToAddress, firstName, lastName, email, phoneNumber, city, street
        , building, flat, porch, floor, comment, state, orders);
    }
}
