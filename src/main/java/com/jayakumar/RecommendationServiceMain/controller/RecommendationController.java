package com.jayakumar.RecommendationServiceMain.controller;


import com.jayakumar.RecommendationServiceMain.config.AppConstants;
import com.jayakumar.RecommendationServiceMain.exception.APIException;
import com.jayakumar.RecommendationServiceMain.model.Product;
import com.jayakumar.RecommendationServiceMain.model.ProductPurchase;
import com.jayakumar.RecommendationServiceMain.payload.ProductDTO;
import com.jayakumar.RecommendationServiceMain.payload.ProductResponse;
import com.jayakumar.RecommendationServiceMain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RecommendationController {

    @Autowired
    private ProductService productService;

    @GetMapping("/recommendation/category/{categoryId}")
    public ResponseEntity<ProductResponse> getUserRecommedationProductsByCategory(@PathVariable Long categoryId,
                                                                                  @RequestParam(name = "pageNumber",defaultValue = AppConstants.page_Number,required = false)Integer pageNumber,
                                                                                  @RequestParam(name = "pageSize",defaultValue = AppConstants.page_Size,required = false)Integer pageSize,
                                                                                  @RequestParam(name = "sortBy",defaultValue = AppConstants.sort_Product_By,required = false)String sortBy,
                                                                                  @RequestParam(name = "sortOrder",defaultValue = AppConstants.sort_Dir,required = false)String sortOrder,
                                                                                  @RequestParam(name = "priceMin",defaultValue = AppConstants.price_Min,required = false)Integer priceMin,
                                                                                  @RequestParam(name = "priceMax",defaultValue = AppConstants.price_Max,required = false)Integer priceMax,
                                                                                  @RequestParam(name = "minProductRating",defaultValue = AppConstants.product_rating_min,required = false)Integer minProductRating,
                                                                                  @RequestParam(name = "productSize",defaultValue = AppConstants.product_size,required = false)String productSize)
    {

        ProductResponse productResponse=productService.getAllProductsByCategory(categoryId,pageNumber,
                pageSize,sortBy,sortOrder,priceMin,priceMax,minProductRating,productSize);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);


    }

    @GetMapping("/recommendation/user")
    public ResponseEntity<ProductResponse> getPersonalRecommendation( @RequestParam(name = "pageNumber",defaultValue = AppConstants.page_Number,required = false)Integer pageNumber,
                                                                      @RequestParam(name = "pageSize",defaultValue = AppConstants.page_Size,required = false)Integer pageSize)
    {

        String sortBy="relevanceScore";
        String sortOrder="desc";

        ProductResponse productResponse=productService.getAllTrendingProducts(pageNumber,pageSize,sortBy,sortOrder);

        return  new ResponseEntity<>(productResponse,HttpStatus.OK);
    }

    @PutMapping("/events/view/{productId}")
    public ResponseEntity<ProductDTO> viewProductById(@PathVariable Long productId)
    {
        ProductDTO productDTO=productService.viewProduct(productId);

        return  new ResponseEntity<>(productDTO,HttpStatus.OK);
    }

    @PutMapping("/events/like/{productId}")
    public ResponseEntity<ProductDTO> likeProduct(@PathVariable Long productId,
                                                  @RequestParam(name = "userId",defaultValue = AppConstants.user_Id,required = false)Long userId) {

        if(userId<0)
        {
            throw new APIException("Please Provide your userId in request Parameter and userId is greater than or equal to 0 ");
        }
        ProductDTO updatedProduct = productService.likeProduct(productId, userId);
        return ResponseEntity.ok(updatedProduct);
    }

    @PutMapping("/events/purchase/{productId}")
    public  ResponseEntity<ProductPurchase> purchaseProductById(@PathVariable Long productId,
                                                                @RequestParam(name = "userId",defaultValue = AppConstants.user_Id,required = false)Long userId,
                                                                @RequestParam(name = "purchaseQuantity",defaultValue = AppConstants.purchase_quantity,required = false)Integer purchaseQuantity)
    {

        if(userId<0)
        {
            throw new APIException("Please Enter your userId in RequestParameter");
        }
        ProductPurchase productPurchase=productService.purchaseProductById(productId,userId,purchaseQuantity);

        return new ResponseEntity<>(productPurchase,HttpStatus.OK);
    }


}
