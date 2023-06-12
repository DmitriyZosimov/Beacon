package com.beacon.catalog.web;

import com.beacon.catalog.service.LaptopService;
import com.beacon.model.dtos.LaptopDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController("/laptop")
@RequiredArgsConstructor
public class LaptopController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LaptopController.class);

    private final LaptopService laptopService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<?>> findAll(@RequestParam(value = "preview", required = false) boolean preview) {
        LOGGER.debug("find all laptops with param preview={}", preview);
        if (preview) {
            return ResponseEntity.ok(laptopService.findAllLaptopPreviewDto());
        } else {
            return ResponseEntity.ok(laptopService.findAllDto());
        }
    }

    @GetMapping(value = "/{computerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LaptopDto> findByComputerId(@PathVariable("computerId") String computerId) {
        LOGGER.debug("find laptop by computer id = {}", computerId);
        Optional<LaptopDto> laptopDto = laptopService.findDtoByComputerId(computerId);
        return laptopDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
