package com.tpg.cat.reviews.adapters.outgoing;

import com.tpg.cat.reviews.GivenWhenThen;
import com.tpg.cat.reviews.application.model.CustomerReviewModel;
import com.tpg.cat.reviews.infrastructure.persistence.CustomerReviewEntityFixture;
import com.tpg.cat.reviews.infrastructure.persistence.CustomerReviewsRepository;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchCustomerReviewsAdapterTestSpec implements GivenWhenThen<SearchCustomerReviewsAdapterTestSpec>, CustomerReviewEntityFixture {
    private static final LocalDateTime NOW = LocalDateTime.now();

    public static SearchCustomerReviewsAdapterTestSpec testSpec() {
        return new SearchCustomerReviewsAdapterTestSpec();
    }

    private CustomerReviewsRepository customerReviewsRepository;

    private String companyReference;

    private SearchCustomerReviewsAdapter searchCustomerReviewsAdapter;

    private List<CustomerReviewModel> actual;

    @Override
    public SearchCustomerReviewsAdapterTestSpec and() {
        return this;
    }

    @Override
    public SearchCustomerReviewsAdapterTestSpec given() {
        return this;
    }

    public SearchCustomerReviewsAdapterTestSpec customerReviewsRepository(CustomerReviewsRepository repository) {
        this.customerReviewsRepository = repository;

        return this;
    }

    public SearchCustomerReviewsAdapterTestSpec companyReference(String companyReference) {
        this.companyReference = companyReference;

        return this;
    }

    public SearchCustomerReviewsAdapterTestSpec searchCustomerReviewsAdapter(SearchCustomerReviewsAdapter adapter) {
        this.searchCustomerReviewsAdapter = adapter;

        return this;
    }

    @Override
    public SearchCustomerReviewsAdapterTestSpec when() {
        return this;
    }

    public SearchCustomerReviewsAdapterTestSpec searchingForExistingCustomerReviews() {
        Mockito.when(customerReviewsRepository.findByCompanyReference(companyReference))
                .thenReturn(singletonList(customerReviewEntity(1312L, "Fixed loose connection",
                        "Fixed loose connections in fuse box.", companyReference,
                        true, NOW.minusDays(10))));

        actual = searchCustomerReviewsAdapter.findByCompanyReference(companyReference);

        return this;
    }

    @Override
    public SearchCustomerReviewsAdapterTestSpec then() {
        return this;
    }

    public SearchCustomerReviewsAdapterTestSpec customerReviewsAreRetrieved() {
        verify(customerReviewsRepository).findByCompanyReference(companyReference);

        assertThat(actual).isNotEmpty();
//        assertThat(actual.get(0).getScoreBreakdownModel().getScoreModels()).isNotEmpty();

        return this;
    }
}
