package com.example.stockmarkettracking.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "markets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MarketType marketType;

    @Enumerated(EnumType.STRING)
    private Country country;

    @Column(nullable = false)
    private String location;

    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL)
    private Set<Stock> stocks = new HashSet<>();
}
