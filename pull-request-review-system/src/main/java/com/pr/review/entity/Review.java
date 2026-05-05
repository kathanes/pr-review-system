package com.pr.review.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "review")
@Getter
@Setter
public class Review {

    @Id
    private String id;

    private String prId;

    private String reviewerId;

    private String status; // APPROVED / CHANGES_REQUESTED / COMMENTED

    @Lob
    private String comment;

    private LocalDateTime createdAt;
}
