package com.tpg.cat.reviews.infrastructure.persistence;

import java.time.LocalDateTime;

public interface CustomerReviewEntityFixture {
    default CustomerReviewEntity customerReviewEntity(Long reviewId, String title,
                                                      String comments, String companyRef,
                                                      boolean verifiedReview, LocalDateTime reviewDate) {
        CustomerReviewEntity entity = new CustomerReviewEntity();
        entity.setReviewId(reviewId);
        entity.setTitle(title);
        entity.setComments(comments);
        entity.setCompanyReference(companyRef);
        entity.setReviewDate(reviewDate);
        entity.setVerifiedReview(verifiedReview);

        return entity;
    }
}
