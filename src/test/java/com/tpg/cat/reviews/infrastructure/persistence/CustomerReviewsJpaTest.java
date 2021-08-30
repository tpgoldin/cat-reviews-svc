package com.tpg.cat.reviews.infrastructure.persistence;

import com.tpg.cat.reviews.domain.model.VerifiedReview;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

import static com.tpg.cat.reviews.domain.model.VerifiedReview.VERIFIED;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CustomerReviewsJpaTest implements CustomerReviewEntityFixture {
    private static final String COMPANY_REFERENCE = "HDDUE35674";

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CustomerReviewsRepository customerReviewsRepository;

    @BeforeEach
    public void setUp() {
        CustomerReviewEntity entity = customerReviewEntity(null, "Fixed loose connections",
                "Fixed loose connections in the fuse box", "CR8", COMPANY_REFERENCE, VERIFIED,
                LocalDateTime.now().minusMonths(1));

        entityManager.merge(entity);
    }

    @Test
    public void givenCustomerReviews_whenFindingByCompanyReference_thenExistingReviewsAreFound() {
        List<CustomerReviewEntity> actual = customerReviewsRepository.findByCompanyReference(COMPANY_REFERENCE);

        assertThat(actual).hasSize(1);

        assertThat(actual.get(0).getReviewId()).isGreaterThan(0L);
        assertThat(actual.get(0).getTitle()).isEqualTo("Fixed loose connections");
        assertThat(actual.get(0).getVerifiedReview()).isEqualTo(VERIFIED);
        assertThat(actual.get(0).getLocation()).isEqualTo("CR8");
    }
}
