package com.jayakumar.RecommendationServiceMain.service;

import com.jayakumar.RecommendationServiceMain.model.ProductPurchase;
import com.jayakumar.RecommendationServiceMain.payload.ProductDTO;
import com.jayakumar.RecommendationServiceMain.payload.ProductResponse;

public interface ProductService {
    ProductResponse getAllProductsByCategory(Long categoryId, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder, Integer priceMin, Integer priceMax, Integer productRating, String productSize);

    ProductResponse getAllTrendingProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    ProductDTO viewProduct(Long productId);

    ProductDTO likeProduct(Long productId, Long userId);

    ProductPurchase purchaseProductById(Long productId, Long userId, Integer purchaseQuantity);
}
