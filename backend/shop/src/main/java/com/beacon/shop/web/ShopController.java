package com.beacon.shop.web;

import com.beacon.model.shop.Shop;
import com.beacon.shop.service.ShopService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
@CrossOrigin
public class ShopController {

    private ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    /**
     * Attempt to find a shop by his id.
     *
     * @param id - identification number.
     * @return {@code Shop} and {@code HttpStatus#OK} if shop is found, or {@code HttpStatus#NotFound}
     */
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shop> getShopById(@PathVariable("id") Long id) {
        return ResponseEntity.of(shopService.findShopById(id));
    }
}
