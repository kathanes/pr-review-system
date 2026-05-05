package com.pr.review.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "review_comment")
@Getter
@Setter
public class ReviewComment {

    @Id
    private String id;

    private String reviewId;

    private String fileId;

    private Integer lineNumber;

    @Lob
    private String comment;
}
