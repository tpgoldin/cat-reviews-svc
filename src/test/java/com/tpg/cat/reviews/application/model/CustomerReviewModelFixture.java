package com.tpg.cat.reviews.application.model;

import com.tpg.cat.reviews.domain.model.VerifiedReview;

import java.time.LocalDateTime;

public interface CustomerReviewModelFixture {
    default CustomerReviewModel customerReviewModel(String title, LocalDateTime reviewDate,
                                                    VerifiedReview verifiedReview, String comments,
                                                    ScoreBreakdownModel scoreBreakdownModel,
                                                    String location) {
        return CustomerReviewModel.builder()
                .title(title)
                .verifiedReview(verifiedReview.getDescription())
                .comments(comments)
                .scoreBreakdownModel(scoreBreakdownModel)
                .location(location)
            .build();
    }
}
