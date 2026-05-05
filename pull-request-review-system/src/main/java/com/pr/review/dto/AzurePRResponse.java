package com.pr.review.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pr.review.entity.AzurePullRequest;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AzurePRResponse {
    private List<AzurePullRequest> value;
}
