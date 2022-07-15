package com.beacon.catalog.web;

import com.beacon.model.MobileDtoFull;
import com.beacon.catalog.service.MobileDtoFullService;
import com.beacon.model.tools.MobileIdToUrlPathConverter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/mobile")
@CrossOrigin
public class MobileDtoFullController {

    private MobileDtoFullService mobileDtoFullService;

    public MobileDtoFullController(MobileDtoFullService mobileDtoFullService) {
        this.mobileDtoFullService = mobileDtoFullService;
    }

    /**
     * Get mobile dto with full description by mobile id. If this mobile does not exist, return 404 status.
     *
     * @param brand is a brand field and also the first part of mobileId.
     * @param id    is the second part of mobileId.
     * @return mobile dto with full description or status 404
     */
    @GetMapping("/{brand}/{id}")
    public ResponseEntity findMobileDtoFullById(@PathVariable(name = "brand") String brand,
                                                @PathVariable(name = "id") String id) {
        Optional<MobileDtoFull> mobileDtoFull = mobileDtoFullService.findMobileDtoFullById(brand + id);
        return ResponseEntity.of(mobileDtoFull);
    }

    /**
     * Save a new mobile dto full model in database
     * @param mobileDtoFull entity to save
     * @return status 201 if entity is saved, or 400 with message.
     */
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createMobileDtoFull(@RequestBody MobileDtoFull mobileDtoFull) {
        MobileDtoFull saved = mobileDtoFullService.saveMobileDtoFull(mobileDtoFull);
        return saved.getMainImage() == null && saved.getMobileId() != null || saved.getMainImage().getImageId() != null ? ResponseEntity
                .created(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("{id}")
                        .buildAndExpand(MobileIdToUrlPathConverter.convert(saved))
                        .toUri())
                .build() :
                ResponseEntity.badRequest().body("The mistake was happened in saving entity. Retry the request later...");
    }
}
