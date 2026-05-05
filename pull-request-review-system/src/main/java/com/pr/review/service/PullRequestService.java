package com.pr.review.service;

import com.pr.review.entity.PullRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PullRequestService {
    PullRequest create(PullRequest request);
    Page<PullRequest> getAll(String status, Pageable pageable);

    PullRequest updateStatus(String id, String status);
}
