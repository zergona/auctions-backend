package com.auction.backend.data.dtos;


import com.auction.backend.data.models.Listing;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ListingDto {
    private UUID id;
    private UUID seller;
    private UUID subcategory;
    private double startingPrice;
    private double currentPrice;
    private Date dateOfPublishing;
    private Date dateOfSale;
    //TODO: private Optional<Bid> bidders = bidService.getAllWithListingId;

    public ListingDto(Listing listing){
        //TODO: constructor
    }
}
