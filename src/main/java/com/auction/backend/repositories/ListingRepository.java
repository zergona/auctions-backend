package com.auction.backend.repositories;

import com.auction.backend.data.models.Listing;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ListingRepository extends CrudRepository<Listing, UUID> {
}
