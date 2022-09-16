package com.beacon.catalog;

import com.beacon.model.builders.OrderBuilder;
import com.beacon.model.builders.TaskBuilder;
import com.beacon.model.order.Order;
import com.beacon.model.order.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public interface TestTaskBuilder {

    String MOBILE_ID = "honor508128black";
    Long SHOP_ID = 1L;
    Double PRICE = 1000.1;
    Long Task_ID = 1L;
    Boolean IS_DELIVERY_ADDRESS = true;
    String FIRST_NAME = "FirstName";
    String LAST_NAME = "LastName";
    String EMAIL = "email@email.com";
    String PHONE_NUMBER = "+1111111111";
    String CITY = "Madrid";
    String STREET = "Street bolivar";
    String BUILDING = "111";
    Integer FLAT = 35;
    Integer PORCH = 2;
    Integer FLOOR = 3;
    String COMMENT = "This is a comment";
    Task TASK = prepareTask();

    default Task buildTaskBeforeSave() {
        Order order = OrderBuilder.create().withMobileId(MOBILE_ID).withShopId(SHOP_ID).withPrice(PRICE).withCount(2)
                .withTask(TASK).build();
        TASK.setTaskId(null);
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        TASK.setOrders(orders);
        return TASK;
    }

    private static Task prepareTask() {
        return TaskBuilder.create().withTaskId(Task_ID).withDeliveryToAddress(IS_DELIVERY_ADDRESS)
        .withFirstName(FIRST_NAME).withLastName(LAST_NAME).withEmail(EMAIL).withPhoneNumber(PHONE_NUMBER)
        .withCity(CITY).withStreet(STREET).withBuilding(BUILDING).withFlat(FLAT).withPorch(PORCH).withFloor(FLOOR)
                .withComment(COMMENT).build();
    }

    default Task buildRandomTaskBeforeSaving(Order ...orders) {
        Task task = TaskBuilder.create()
                .withFirstName(getRandomString())
                .withLastName(getRandomString())
                .withPhoneNumber(getRandomPhoneNumber())
                .withEmail(getRandomEmail())
                .withCity(getRandomString())
                .withStreet(getRandomString())
                .withBuilding(getRandomInteger().toString())
                .withPorch(getRandomInteger())
                .withFloor(getRandomInteger())
                .withFlat(getRandomInteger())
                .withComment(getRandomString())
                .withOrders(Arrays.asList(orders))
                .build();
        task.getOrders().forEach(order -> order.setTask(task));
        return task;
    }

    default Order buildRandomOrderBeforeSaving() {
        return OrderBuilder.create()
                .withMobileId(getRandomMobileId())
                .withShopId(getRandomLong(7L))
                .withCount(getRandomInteger())
                .withPrice(getRandomDouble())
                .build();
    }

    private String getRandomMobileId() {
        List<String> mobileIds = List.of("honor508128black", "pocox3pro8256green");
        Random random = new Random();
        return mobileIds.get(random.nextInt(mobileIds.size()));
    }

    private String getRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    private Integer getRandomInteger() {
        Random random = new Random();
        return random.nextInt(100);
    }

    private Long getRandomLong(long rightLimit) {
        long leftLimit = 1L;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }

    private Double getRandomDouble() {
        double leftLimit = 100.0;
        double rightLimit = 10000.0;
        double result =  leftLimit + Math.random() * (rightLimit - leftLimit);
        result = result * 100;
        result = Math.round(result) / 100;
        return result;
    }

    private String getRandomPhoneNumber() {
        int leftLimit = 48; // letter 'a'
        int rightLimit = 57; // letter 'z'
        int targetStringLength = 7;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return "+ " + generatedString;
    }

    private String getRandomEmail() {
        return getRandomString() + "@email.com";
    }
}
