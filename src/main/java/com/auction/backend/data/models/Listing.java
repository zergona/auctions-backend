package com.auction.backend.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
//TODO: import java.util.Optional;
import java.util.Optional;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name="listing")
public class Listing {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private UUID seller;
    private UUID subcategory;
    private double startingPrice;
    private double currentPrice;
    private Date dateOfPublishing;
    private Date dateOfSale;
    private Optional<Bid> bidders;

    //TODO: constructor

}