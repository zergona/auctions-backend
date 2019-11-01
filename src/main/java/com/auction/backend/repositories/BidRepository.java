package com.auction.backend.repositories;

import com.auction.backend.data.models.Bid;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BidRepository extends CrudRepository<Bid, UUID> {
}
