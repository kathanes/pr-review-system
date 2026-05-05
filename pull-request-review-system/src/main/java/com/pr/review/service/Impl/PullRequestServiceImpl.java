package com.pr.review.service.Impl;

import com.pr.review.entity.PullRequest;
import com.pr.review.repository.PullRequestRepository;
import com.pr.review.service.PullRequestService;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PullRequestServiceImpl implements PullRequestService {

    private final PullRequestRepository repository;

    public PullRequest create(PullRequest request) {
        request.setId(UUID.randomUUID().toString());
        request.setStatus("OPEN");
        request.setCreatedAt(LocalDateTime.now());
        return repository.save(request);
    }

    public Page<PullRequest> getAll(String status, Pageable pageable) {
        if (status != null) {
            return repository.findByStatus(status, pageable);
        }
        return repository.findAll(pageable);
    }

    public PullRequest updateStatus(String id, String status) {
        PullRequest pr = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("PR not found"));

        pr.setStatus(status);
        return repository.save(pr);
    }
}
