package com.beacon.search.web;

import com.beacon.model.MobileDto;
import com.beacon.search.service.MobileSearchService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("search")
@CrossOrigin
public class MobileSearchController {

    private MobileSearchService searchService;

    public MobileSearchController(MobileSearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MobileDto>> search(@RequestParam(name = "query") String query) {
        return ResponseEntity.ok(searchService.search(query));
    }
}
