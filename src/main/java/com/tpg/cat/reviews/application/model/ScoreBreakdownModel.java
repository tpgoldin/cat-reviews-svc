package com.tpg.cat.reviews.application.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Value
@Builder
public class ScoreBreakdownModel {
    List<ScoreModel> scoreModels;

    public double getAverageReviewAttributeScore() {
        if (scoreModels.isEmpty()) return 0.0;

        return scoreModels.stream()
                .mapToDouble(x -> Integer.valueOf(x.getScore()).doubleValue())
                    .average().orElse(0.0);
    }
}
