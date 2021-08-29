package com.tpg.cat.reviews.infrastructure.persistence;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="CUSTOMER_REVIEWS")
public class CustomerReviewEntity {
    @Id
    @Column(name="REVIEW_ID")
    private Long reviewId;

    @Column(name="COMPANY_REF")
    private String companyReference;

    @Column(name="TITLE")
    private String title;

    @Column(name="VERIFIED_REVIEW")
    private boolean verifiedReview;

    @Column(name="COMMENTS")
    private String comments;

    private LocalDateTime reviewDate;

    @Column(name="LOCATION")
    private String location;
}
