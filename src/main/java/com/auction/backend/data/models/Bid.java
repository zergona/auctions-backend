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
import java.util.UUID;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name="bid")
public class Bid {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private UUID userId;
    private UUID listingId;
    private double amount;
    private Date dateOfBid;
    public Bid(UUID id, UUID userId, UUID listingId, double amount, Date dateOfBid){
        this.id = id;
        this.userId = userId;
        this.listingId = listingId;
        this.amount = amount;
        this.dateOfBid = dateOfBid;
    }
}
