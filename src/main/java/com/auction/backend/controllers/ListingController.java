package com.auction.backend.controllers;

import com.auction.backend.data.dtos.ListingDto;
import com.auction.backend.data.dtos.UserDto;
import com.auction.backend.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/listing")
public class ListingController {
    @Autowired
    ListingService listingService;

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable UUID id) {
        return listingService.findById(id);
    }

    @GetMapping
    public ResponseEntity getAll() {
        return listingService.findAll();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ListingDto listingDto) {
        return listingService.postNewListing(listingDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody ListingDto listingDto) {
        return listingService.updateListing(id, listingDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        return listingService.deleteListing(id);
    }
}
