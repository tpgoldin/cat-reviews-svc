package com.tpg.cat.reviews.application.model;

import com.tpg.cat.reviews.domain.model.ReviewAttribute;

public interface ScoreModelFixture {
    default ScoreModel scoreModel(ReviewAttribute reviewAttribute, int score) {
        return ScoreModel.builder()
                .reviewAttribute(reviewAttribute)
                .score(score)
            .build();
    }
}
