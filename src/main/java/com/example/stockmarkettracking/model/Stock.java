package com.example.stockmarkettracking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Public ID is required")
    @Column(nullable = false, unique = true)
    private String publicId;

    @NotBlank(message = "Symbol is required")
    @Pattern(regexp = "^[A-Z]{1,5}$", message = "Invalid stock symbol")
    @Column(nullable = false, unique = true)
    private String symbol;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @Positive(message = "Price must be positive")
    @Column(nullable = false)
    private double price;

    @ManyToMany(mappedBy = "stocks")
    private Set<User> users = new HashSet<>();
}
