package com.tpg.cat.reviews.infrastructure.persistence;

import com.tpg.cat.reviews.domain.model.VerifiedReview;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class VerifiedReviewConverter implements AttributeConverter<VerifiedReview, String> {
    @Override
    public String convertToDatabaseColumn(VerifiedReview value) {
        if (value == null) { return null; }

        return value.getIndicator();
    }

    @Override
    public VerifiedReview convertToEntityAttribute(String value) {
        if (value == null) { return null; }

        return Stream.of(VerifiedReview.values())
                .filter(vr -> value.equals(vr.getIndicator()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
