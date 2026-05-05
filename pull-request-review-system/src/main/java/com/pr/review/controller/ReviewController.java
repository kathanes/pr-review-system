package com.pr.review.controller;

import com.pr.review.entity.Review;
import com.pr.review.service.ReviewService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pr/{prId}/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;

    @PostMapping
    public ResponseEntity<Review> addReview(
            @PathVariable String prId,
            @RequestBody Review review) {

        return ResponseEntity.ok(service.addReview(prId, review));
    }

    @GetMapping
    public ResponseEntity<List<Review>> getReviews(@PathVariable String prId) {
        return ResponseEntity.ok(service.getReviews(prId));
    }
}
