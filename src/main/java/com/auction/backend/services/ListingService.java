package com.auction.backend.services;

import com.auction.backend.SecurityConfig;
import com.auction.backend.data.dtos.ListingDto;
import com.auction.backend.data.dtos.UserDto;
import com.auction.backend.data.models.Listing;
import com.auction.backend.data.models.User;
import com.auction.backend.repositories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

@Service
public class ListingService {
    @Autowired
    ListingRepository listingRepository;

    public ResponseEntity<Listing> findAll() {
        Iterable<Listing> all = listingRepository.findAll();
        return new ResponseEntity(all, HttpStatus.OK);
    }

    public ResponseEntity<Listing> findById(@PathVariable UUID id) {
        Optional<Listing> listing = listingRepository.findById(id);
        if (listing.isPresent()) {
            return new ResponseEntity(new ListingDto(listing.get()), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Listing> postNewListing(@RequestBody ListingDto listingDto) {
        listingRepository.save(new Listing());
        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity<Listing> updateListing(UUID id, ListingDto listingDto) {
        Listing listing = listingRepository.findById(id).get();
        if (listing != null) {
            listing.setCurrentPrice(listingDto.getCurrentPrice());
            //TODO: addbidder
            listing.setSubcategory(listingDto.getSubcategory());
            return new ResponseEntity(HttpStatus.OK);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Listing> deleteListing(UUID id) {
        Optional<Listing> listing = listingRepository.findById(id);
        if (listing.isPresent()) {
            listingRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
