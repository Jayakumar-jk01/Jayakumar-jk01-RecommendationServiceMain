package com.jayakumar.RecommendationServiceMain.Repository;

import com.jayakumar.RecommendationServiceMain.model.ProductLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductLikeRepository extends JpaRepository<ProductLike, Long> {
    boolean existsByProductIdAndUserId(Long productId, Long userId);
}