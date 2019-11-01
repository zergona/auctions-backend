package com.auction.backend.services;

import com.auction.backend.SecurityConfig;
import com.auction.backend.data.dtos.BidDto;
import com.auction.backend.data.dtos.UserDto;
import com.auction.backend.data.models.Bid;
import com.auction.backend.data.models.User;
import com.auction.backend.repositories.BidRepository;
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
public class BidService {
    @Autowired
    BidRepository bidRepository;

    public ResponseEntity<Bid> findAll() {
        Iterable<Bid> all = bidRepository.findAll();
        return new ResponseEntity(all, HttpStatus.OK);
    }

    public ResponseEntity<Bid> findById(@PathVariable UUID id) {
        Optional<Bid> bid = bidRepository.findById(id);
        if (bid.isPresent()) {
            return new ResponseEntity(new BidDto(bid.get()), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Bid> postNewBid(@RequestBody BidDto bidDto) {
        bidRepository.save(new Bid(bidDto.getId(), bidDto.getUserId(), bidDto.getListingId(), bidDto.getAmount(), bidDto.getDateOfBid()));
        return new ResponseEntity(HttpStatus.OK);
    }


    public ResponseEntity<Bid> deleteBid(UUID id) {
        Optional<Bid> bid = bidRepository.findById(id);
        if (bid.isPresent()) {
            bidRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
