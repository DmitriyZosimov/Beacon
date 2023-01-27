package com.beacon.catalog.web;

import com.beacon.catalog.service.TaskService;
import com.beacon.model.order.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class TaskController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/shop/{id}/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List> findAllCustomsByShopIdInOrders(@PathVariable("id") Long shopId) {
        LOGGER.info("All customs finding by shop id {} in order", shopId);
        return ResponseEntity.ok(taskService.findAllByShopIdInOrders(shopId));
    }

    @PutMapping(value = "/shop/{id}/tasks", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateTask (@RequestBody Task task) {
        LOGGER.info("Task update");
        taskService.updateTaskState(task);
        return ResponseEntity.ok().build();
    }
}
