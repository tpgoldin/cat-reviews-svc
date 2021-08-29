package com.tpg.cat.reviews.adapters.outgoing;

import com.tpg.cat.reviews.infrastructure.persistence.CustomerReviewsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.tpg.cat.reviews.adapters.outgoing.SearchCustomerReviewsAdapterTestSpec.testSpec;

@ExtendWith(MockitoExtension.class)
public class SearchCustomerReviewsAdapterTest {
    @Mock
    private CustomerReviewsRepository customerReviewsRepository;

    @InjectMocks
    private SearchCustomerReviewsAdapter adapter;

    @Test
    public void givenCompanyReference_whenSearchingForExistingCustomerReviews_thenReviewsAreRetrieved() {
        testSpec()
            .given()
                .companyReference("JHKJ2344")
            .and()
                .customerReviewsRepository(customerReviewsRepository)
            .and()
                .searchCustomerReviewsAdapter(adapter)
            .when()
                .searchingForExistingCustomerReviews()
            .then()
                .customerReviewsAreRetrieved();
    }
}
