package com.pr.review.repository;

import com.pr.review.entity.ReviewComment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ReviewCommentRepository extends JpaRepository<ReviewComment, String> {
    List<ReviewComment> findByReviewId(String reviewId);
}
