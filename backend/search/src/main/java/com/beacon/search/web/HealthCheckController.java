package com.beacon.search.web;

import com.beacon.search.service.HealthCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HealthCheckController {

    private final HealthCheckService healthCheckService;

    @GetMapping("/statuscheck")
    public ResponseEntity<String> getStatusCheck() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/resourcecheck")
    public ResponseEntity<String> getResourceCheck() {
        return ResponseEntity.ok(healthCheckService.getResourceStatus().name());
    }
}
