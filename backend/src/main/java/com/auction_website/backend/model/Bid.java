package com.auction_website.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data @NoArgsConstructor
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "bidder_id", referencedColumnName = "id")
    private Bidder bidder;
    private Timestamp time;
    private BigDecimal amount;

    public Bid(Item item, Bidder bidder, Timestamp time, BigDecimal amount) {
        this.item = item;
        this.bidder = bidder;
        this.time = time;
        this.amount = amount;
    }

}