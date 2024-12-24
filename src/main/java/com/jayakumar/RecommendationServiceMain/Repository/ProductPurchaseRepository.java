package com.jayakumar.RecommendationServiceMain.Repository;

import com.jayakumar.RecommendationServiceMain.model.ProductLike;
import com.jayakumar.RecommendationServiceMain.model.ProductPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductPurchaseRepository extends JpaRepository<ProductPurchase, Long> {
}
