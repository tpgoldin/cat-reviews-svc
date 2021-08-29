package com.tpg.cat.reviews.application.model;

import com.tpg.cat.reviews.domain.model.ReviewAttribute;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ScoreModel {
    ReviewAttribute reviewAttribute;
    int score;
}
