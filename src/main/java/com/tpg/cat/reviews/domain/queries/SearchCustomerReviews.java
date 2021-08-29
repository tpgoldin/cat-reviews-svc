package com.tpg.cat.reviews.domain.queries;

import com.tpg.cat.reviews.application.model.CustomerReviewModel;

import java.util.List;

public interface SearchCustomerReviews {
    List<CustomerReviewModel> findByCompanyReference(String companyReference);
}
