package com.tpg.cat.reviews.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum VerifiedReview {
    VERIFIED("Verified", "1"), NOT_VERIFIED("Not verified", "0");

    private final String description;
    private final String indicator;
}
