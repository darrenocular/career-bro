package com.careerbro.career_bro.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.Instant;

@Entity
@Table(name = "job_listings")
@Data                    // Lombok: generates getters, setters, equals, hashCode, toString
@NoArgsConstructor       // Lombok: generates no-arg constructor (required by JPA)
@AllArgsConstructor      // Lombok: generates all-args constructor
public class JobListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String company;

    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JobSource source;

    @Column(nullable = false, unique = true)
    private String sourceUrl;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Integer salaryMin;
    private Integer salaryMax;

    @Column(nullable = false)
    private Boolean isActive = true;

    private Instant postedAt;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }
}
