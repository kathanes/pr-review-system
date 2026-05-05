package com.pr.review.service.Impl;

import com.pr.review.entity.Review;
import com.pr.review.repository.ReviewRepository;
import com.pr.review.service.ReviewService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repository;

    public Review addReview(String prId, Review review) {
        review.setId(UUID.randomUUID().toString());
        review.setPrId(prId);
        review.setCreatedAt(LocalDateTime.now());

        return repository.save(review);
    }

    public List<Review> getReviews(String prId) {
        return repository.findByPrId(prId);
    }
}
