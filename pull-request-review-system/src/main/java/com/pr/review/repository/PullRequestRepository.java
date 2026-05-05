package com.pr.review.repository;

import com.pr.review.entity.PullRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PullRequestRepository extends JpaRepository<PullRequest, String> {
    Page<PullRequest> findByStatus(String status, Pageable pageable);
}
