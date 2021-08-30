package com.tpg.cat.reviews.infrastructure.persistence;

import com.tpg.cat.reviews.domain.model.VerifiedReview;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="CUSTOMER_REVIEWS")
public class CustomerReviewEntity {
    @Id
    @Column(name="REVIEW_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_reviews_seq_gen")
    @SequenceGenerator(name="cust_reviews_seq_gen", sequenceName = "cust_reviews_seq", allocationSize = 1)
    private Long reviewId;

    @Column(name="COMPANY_REF")
    private String companyReference;

    @Column(name="TITLE")
    private String title;

    @Column(name="VERIFIED_REVIEW")
    @Enumerated(value=EnumType.STRING)
    private VerifiedReview verifiedReview;

    @Column(name="COMMENTS")
    private String comments;

    @Column(name="REVIEW_DATE", columnDefinition = "TIMESTAMP")
    private LocalDateTime reviewDate;

    @Column(name="LOCATION")
    private String location;
}
