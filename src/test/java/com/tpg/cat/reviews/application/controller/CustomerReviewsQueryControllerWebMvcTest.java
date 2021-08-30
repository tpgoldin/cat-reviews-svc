package com.tpg.cat.reviews.application.controller;

import com.tpg.cat.reviews.application.model.CustomerReviewModel;
import com.tpg.cat.reviews.application.model.CustomerReviewModelFixture;
import com.tpg.cat.reviews.application.model.ScoreBreakdownModel;
import com.tpg.cat.reviews.application.model.ScoreBreakdownModelFixture;
import com.tpg.cat.reviews.domain.model.VerifiedReview;
import com.tpg.cat.reviews.domain.queries.SearchCustomerReviews;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static com.tpg.cat.reviews.domain.model.ReviewAttribute.TIMEKEEPING;
import static com.tpg.cat.reviews.domain.model.ReviewAttribute.WORKMANSHIP;
import static com.tpg.cat.reviews.domain.model.VerifiedReview.VERIFIED;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = CustomerReviewsQueryController.class)
public class CustomerReviewsQueryControllerWebMvcTest implements ScoreBreakdownModelFixture, CustomerReviewModelFixture {
    private static final LocalDateTime NOW = LocalDateTime.now();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SearchCustomerReviews searchCustomerReviews;

    @Test
    public void givenUserWantsToViewCompanyReviews_whenQueryingACompanyReviews_thenCompanyReviewsAreDisplayed() throws Exception {
        ScoreBreakdownModel scoreBreakdownModel = scoreBreakdownModel(asList(TIMEKEEPING, WORKMANSHIP));

        List<CustomerReviewModel> customerReviews = singletonList(customerReviewModel("Installed an inline bathroom extractor fan",
                NOW.minusMonths(2), VERIFIED,"Very pleased with the work carried out.",
                scoreBreakdownModel, "CR8"));

        String companyRef = "SKDJF1285";

        when(searchCustomerReviews.findByCompanyReference(companyRef)).thenReturn(customerReviews);

        mockMvc.perform(get("/checkatrade/trade/reviews")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("companyReference", companyRef))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(model().attribute("customerReviews", customerReviews))
            .andExpect(view().name("companySummary"));
    }
}
