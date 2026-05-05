package com.pr.review.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AzurePullRequest {

    private Integer pullRequestId;
    private String title;
    private String description;
    private String status;

    private Identity createdBy;
    private Repository repository;

    private List<Reviewer> reviewers;
}
