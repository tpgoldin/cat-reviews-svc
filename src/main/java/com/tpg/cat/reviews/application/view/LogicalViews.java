package com.tpg.cat.reviews.application.view;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogicalViews {
    public static final String COMPANY_SUMMARY_VIEW = "companySummary";
    public static final String CUSTOMER_REVIEWS_VIEW = "customerReviews";
}