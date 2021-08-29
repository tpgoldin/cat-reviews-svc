package com.tpg.cat.reviews.application.controller;

import com.tpg.cat.reviews.application.model.CustomerReviewModel;
import com.tpg.cat.reviews.domain.queries.SearchCustomerReviews;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.tpg.cat.reviews.application.view.LogicalViews.COMPANY_SUMMARY_VIEW;
import static com.tpg.cat.reviews.application.view.LogicalViews.CUSTOMER_REVIEWS_VIEW;

@Controller
@RequestMapping("/checkatrade/trade")
@RequiredArgsConstructor
public class CustomerReviewsQueryController {
    @Autowired
    private SearchCustomerReviews searchCustomerReviews;

    @GetMapping("/reviews")
    public String customerReviewsFor(@RequestParam(name="companyReference") String companyReference, Model model) {

        List<CustomerReviewModel> customerReviews = searchCustomerReviews.findByCompanyReference(companyReference);

        model.addAttribute("customerReviews", customerReviews);

        return COMPANY_SUMMARY_VIEW;
    }
}
