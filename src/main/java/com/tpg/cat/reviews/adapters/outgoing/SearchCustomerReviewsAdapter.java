package com.tpg.cat.reviews.adapters.outgoing;

import com.tpg.cat.reviews.application.model.CustomerReviewModel;
import com.tpg.cat.reviews.application.model.ScoreBreakdownModel;
import com.tpg.cat.reviews.domain.queries.SearchCustomerReviews;
import com.tpg.cat.reviews.infrastructure.persistence.CustomerReviewEntity;
import com.tpg.cat.reviews.infrastructure.persistence.CustomerReviewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toUnmodifiableList;

@Service
@Slf4j
@RequiredArgsConstructor
public class SearchCustomerReviewsAdapter implements SearchCustomerReviews {
    @Autowired
    private final CustomerReviewsRepository customerReviewsRepository;

    @Override
    public List<CustomerReviewModel> findByCompanyReference(String companyReference) {
        List<CustomerReviewEntity> entities = customerReviewsRepository.findByCompanyReference(companyReference);

        return entities.stream().map(this::toModel).collect(toUnmodifiableList());
    }

    private CustomerReviewModel toModel(CustomerReviewEntity entity) {
        ScoreBreakdownModel scoreBreakdownModel = ScoreBreakdownModel.builder()
                .scoreModels(emptyList()).build();

        CustomerReviewModel customerReviewModel = CustomerReviewModel.builder()
                .title(entity.getTitle())
                .verifiedReview(entity.isVerifiedReview())
                .comments(entity.getComments())
                .location(entity.getLocation())
                .scoreBreakdownModel(scoreBreakdownModel)
                .build();

        log.debug("Customer review: {}", customerReviewModel);

        return customerReviewModel;
    }
}
