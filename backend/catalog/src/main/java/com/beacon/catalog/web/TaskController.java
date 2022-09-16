package com.beacon.catalog.web;

import com.beacon.catalog.service.TaskService;
import com.beacon.model.order.Task;
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

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/shop/{id}/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List> findAllCustomsByShopIdInOrders(@PathVariable("id") Long shopId) {
        return ResponseEntity.ok(taskService.findAllByShopIdInOrders(shopId));
    }

    @PutMapping(value = "/shop/{id}/tasks", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateTask (@RequestBody Task task) {
        System.out.println(task);
        taskService.updateTaskState(task);
        return ResponseEntity.ok().build();
    }
}
