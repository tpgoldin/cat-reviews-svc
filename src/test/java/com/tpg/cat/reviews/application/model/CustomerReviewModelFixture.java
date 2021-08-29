package com.tpg.cat.reviews.application.model;

import java.time.LocalDateTime;

public interface CustomerReviewModelFixture {
    default CustomerReviewModel customerReviewModel(String title, LocalDateTime reviewDate,
                                                    boolean verifiedReview, String comments,
                                                    ScoreBreakdownModel scoreBreakdownModel,
                                                    String location) {
        return CustomerReviewModel.builder()
                .title(title)
                .verifiedReview(verifiedReview)
                .comments(comments)
                .scoreBreakdownModel(scoreBreakdownModel)
                .location(location)
            .build();
    }
}
