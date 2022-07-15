package com.beacon.catalog.web;

import com.beacon.model.MobileDto;
import com.beacon.catalog.service.MobileDtoService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mobile")
@CrossOrigin
public class MobileDtoController {

    private MobileDtoService mobileDtoService;

    public MobileDtoController(MobileDtoService mobileDtoService) {
        this.mobileDtoService = mobileDtoService;
    }

    /**
     * Get all existed mobile dtos.
     * @return list with mobile dtos.
     */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MobileDto>> findAllMobileDtos() {
        List<MobileDto> list = mobileDtoService.findAllMobileDtos();
        return ResponseEntity.ok(list);
    }
}
