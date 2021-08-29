package com.tpg.cat.reviews.application.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class CustomerReviewModel {
    String title;
    LocalDateTime reviewDate;
    boolean verifiedReview;
    String comments;
    ScoreBreakdownModel scoreBreakdownModel;
    String location;
}
