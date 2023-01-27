package com.beacon.catalog.web;

import com.beacon.catalog.service.MobileService;
import com.beacon.model.dtos.MobileDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mobile")
public class MobileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MobileController.class);

    private MobileService mobileService;

    public MobileController(MobileService mobileService) {
        this.mobileService = mobileService;
    }

    /**
     * Get all existed mobile dtos.
     *
     * @return list with mobile dtos.
     */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MobileDto>> findAllMobiles() {
        LOGGER.info("All mobile finding");
        List<MobileDto> list = mobileService.findAllMobileDtos();
        return ResponseEntity.ok(list);
    }
}
