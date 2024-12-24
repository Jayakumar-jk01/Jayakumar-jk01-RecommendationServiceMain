package com.jayakumar.RecommendationServiceMain.Repository;

import com.jayakumar.RecommendationServiceMain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
