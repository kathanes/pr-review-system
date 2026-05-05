package com.pr.review.service.Impl;

import com.pr.review.config.AzureDevOpsConfig;
import com.pr.review.dto.AzurePRResponse;
import com.pr.review.entity.AzurePullRequest;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class AzureDevOpsServiceImpl {
    private final WebClient webClient;
    private final AzureDevOpsConfig config;

    String pat = "test";
    String auth = ":" + pat;
    String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
    public List<AzurePullRequest> fetchPullRequests() {

        String url = String.format(
                "%s/tfs/%s/%s/_apis/git/repositories/%s/pullrequests?reviewerId=test&_a=active&api-version=5.1",
                config.getBaseUrl(),
                config.getCollection(),
                config.getProject(),
                config.getRepoId()
        );
        AzurePRResponse response = webClient.get()
                .uri(url)
                .header(HttpHeaders.AUTHORIZATION, "Basic " + encodedAuth)
                .header(HttpHeaders.ACCEPT, "application/json")
                .retrieve()
                .bodyToMono(AzurePRResponse.class)
                .block();

        return response != null ? response.getValue() : Collections.emptyList();
    }
}
