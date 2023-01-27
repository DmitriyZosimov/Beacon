package com.beacon.catalog.web;

import com.beacon.catalog.service.MobileFullService;
import com.beacon.model.MobileFull;
import com.beacon.model.tools.MobileIdToUrlPathConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/mobile")
public class MobileFullController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MobileFullController.class);

    private MobileFullService mobileFullService;

    public MobileFullController(MobileFullService mobileFullService) {
        this.mobileFullService = mobileFullService;
    }

    /**
     * Get mobile dto with full description by mobile id. If this mobile does not exist, return 404 status.
     *
     * @param brand is a brand field and also the first part of mobileId.
     * @param id    is the second part of mobileId.
     * @return mobile dto with full description or status 404
     */
    @GetMapping("/{brand}/{id}")
    public ResponseEntity findMobileFullById(@PathVariable(name = "brand") String brand,
                                             @PathVariable(name = "id") String id) {
        LOGGER.info("Mobile finding by brand {} and id {}", brand, id);
        Optional<MobileFull> mobileFull = mobileFullService.findMobileFullById(brand + id);
        return ResponseEntity.of(mobileFull);
    }

    /**
     * Save a new mobile dto full model in database
     *
     * @param mobileFull entity to save
     * @return status 201 if entity is saved, or 400 with message.
     */
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createMobileFull(@RequestBody MobileFull mobileFull) {
        LOGGER.info("MobileFull creating");
        MobileFull saved = mobileFullService.saveMobileFull(mobileFull);
        if (saved.getMainImage() == null && saved.getMobileId() != null || saved.getMainImage().getImageId() != null) {
            return ResponseEntity
                    .created(ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("{id}")
                            .buildAndExpand(MobileIdToUrlPathConverter.convert(saved))
                            .toUri())
                    .build();
        } else {
            LOGGER.error("MobileFull was not created: {}", mobileFull.toString());
            return ResponseEntity.badRequest().body("The mistake was happened in saving entity. Retry the request later...");
        }
    }
}
