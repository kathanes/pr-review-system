package com.pr.review.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pull_request_file")
@Getter
@Setter
public class PullRequestFile {

    @Id
    private String id;

    private String prId;

    private String fileName;

    @Lob
    private String oldContent;

    @Lob
    private String newContent;
}
