package com.beacon.catalog.web;

import com.beacon.catalog.service.TaskService;
import com.beacon.model.order.Task;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    private TaskService taskService;

    public CartController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createTask(@RequestBody Task Task) {
        return this.taskService.saveTask(Task) ? ResponseEntity.created(null).build()
                : ResponseEntity.badRequest().body("Something went wrong. Try to send request later");
    }
}
