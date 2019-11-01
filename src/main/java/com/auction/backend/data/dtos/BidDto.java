package com.auction.backend.data.dtos;

import com.auction.backend.data.models.Bid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor

public class BidDto {
    private UUID id;
    private UUID userId;
    private UUID listingId;
    private double amount;
    private Date dateOfBid;

    public BidDto(Bid bid){
        id = bid.getId();
        userId = bid.getUserId();
        listingId = bid.getListingId();
        amount = bid.getAmount();
        dateOfBid = bid.getDateOfBid();
    }
}
