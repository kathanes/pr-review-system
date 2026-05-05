package com.pr.review.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pull_request")
@Getter
@Setter
public class PullRequest {

    @Id
    private String id;

    private String title;

    @Lob
    private String description;

    private String status;

    private LocalDateTime createdAt;
}
