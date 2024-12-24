package com.jayakumar.RecommendationServiceMain.Repository;

import com.jayakumar.RecommendationServiceMain.model.Category;
import com.jayakumar.RecommendationServiceMain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByCategory(Category category);
    Page<Product> findByCategoryOrderByRatingDesc(Category category, Pageable pageDetails);
    Page<Product> findByCategoryOrderByRatingAsc(Category category, Pageable pageDetails);
    Page<Product> findByCategoryOrderByPriceAsc(Category category, Pageable pageDetails);
    Page<Product> findByCategoryOrderByPriceDesc(Category category, Pageable pageDetails);


    Page<Product> findByCategoryOrderByProductIdAsc(Category category, Pageable pageDetails);

    Page<Product> findByCategoryOrderByProductIdDesc(Category category, Pageable pageDetails);
}
