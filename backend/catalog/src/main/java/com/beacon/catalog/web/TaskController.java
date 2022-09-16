package com.beacon.catalog.web;

import com.beacon.catalog.service.TaskService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
}
