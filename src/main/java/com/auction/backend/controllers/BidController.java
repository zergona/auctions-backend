package com.auction.backend.controllers;

import com.auction.backend.data.dtos.BidDto;
import com.auction.backend.data.dtos.ListingDto;
import com.auction.backend.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/bid")
public class BidController {
    @Autowired
    BidService bidService;

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable UUID id) {
        return bidService.findById(id);
    }

    @GetMapping
    public ResponseEntity getAll() {
        return bidService.findAll();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody BidDto bidDto) {
        return bidService.postNewBid(bidDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        return bidService.deleteBid(id);
    }
}
