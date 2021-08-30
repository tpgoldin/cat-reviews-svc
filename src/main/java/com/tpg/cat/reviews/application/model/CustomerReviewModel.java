package com.tpg.cat.reviews.application.model;

import com.tpg.cat.reviews.domain.model.VerifiedReview;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class CustomerReviewModel {
    String title;
    LocalDateTime reviewDate;
    String verifiedReview;
    String comments;
    ScoreBreakdownModel scoreBreakdownModel;
    String location;
}
