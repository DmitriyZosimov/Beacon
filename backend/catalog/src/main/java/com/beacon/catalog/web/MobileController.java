package com.beacon.catalog.web;

import com.beacon.catalog.service.MobileService;
import com.beacon.model.dtos.MobileDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mobile")
public class MobileController {

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
        List<MobileDto> list = mobileService.findAllMobileDtos();
        return ResponseEntity.ok(list);
    }
}
