package com.tpg.cat.reviews.application.model;

import com.tpg.cat.reviews.domain.model.ReviewAttribute;

import java.util.List;

import static com.tpg.cat.reviews.domain.model.ReviewAttribute.TIMEKEEPING;
import static com.tpg.cat.reviews.domain.model.ReviewAttribute.WORKMANSHIP;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public interface ScoreBreakdownModelFixture extends ScoreModelFixture {
    default ScoreBreakdownModel scoreBreakdownModel(List<ReviewAttribute> reviewAttributes) {
        List<ScoreModel> scoreModels = reviewAttributes.stream().map(ra -> scoreModel(ra, 10)).collect(toList());

        return ScoreBreakdownModel.builder().scoreModels(scoreModels).build();
    }
}
