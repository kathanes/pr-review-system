package com.pr.review.service;

import com.pr.review.entity.Review;
import java.util.List;

public interface ReviewService {
    Review addReview(String prId, Review review);
    List<Review> getReviews(String prId);

}
