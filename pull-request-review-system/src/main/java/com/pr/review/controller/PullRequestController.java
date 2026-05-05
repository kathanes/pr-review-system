package com.pr.review.controller;

import com.pr.review.entity.AzurePullRequest;
import com.pr.review.entity.PullRequest;
import com.pr.review.service.Impl.AzureDevOpsServiceImpl;
import com.pr.review.service.PullRequestService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pr")
@RequiredArgsConstructor
public class PullRequestController {

    private final PullRequestService service;

    @PostMapping
    public ResponseEntity<PullRequest> create(@RequestBody PullRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<Page<PullRequest>> getAll(
            @RequestParam(required = false) String status,
            Pageable pageable) {
        return ResponseEntity.ok(service.getAll(status, pageable));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<PullRequest> updateStatus(
            @PathVariable String id,
            @RequestParam String status) {
        return ResponseEntity.ok(service.updateStatus(id, status));
    }

    private final AzureDevOpsServiceImpl azureDevOpsService;

    @GetMapping("azure")
    public ResponseEntity<List<AzurePullRequest>> getPRs() {
        return ResponseEntity.ok(azureDevOpsService.fetchPullRequests());
    }
}
