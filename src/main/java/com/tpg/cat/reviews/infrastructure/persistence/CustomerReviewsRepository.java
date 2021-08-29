package com.tpg.cat.reviews.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerReviewsRepository extends JpaRepository<CustomerReviewEntity, Long> {
    List<CustomerReviewEntity> findByCompanyReference(String companyRef);
}
