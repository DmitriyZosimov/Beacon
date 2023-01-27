package com.beacon.catalog.web;

import com.beacon.catalog.service.TaskService;
import com.beacon.model.order.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    private TaskService taskService;

    public CartController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createTask(@RequestBody Task task) {
        LOGGER.info("Task creation");
        if (this.taskService.saveTask(task)){
            return ResponseEntity.created(null).build();
        } else {
            LOGGER.error("Task was not created: {}", task);
            return ResponseEntity.badRequest().body("Something went wrong. Try to send request later");
        }
    }
}
