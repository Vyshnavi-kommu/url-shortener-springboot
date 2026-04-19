package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "urls")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String shortCode;

    @Column(columnDefinition = "TEXT")
    private String longUrl;

    private LocalDateTime createdAt;
    private LocalDateTime expiryAt;

    private int clickCount;

    // getters + setters
}