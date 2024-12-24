package com.jayakumar.RecommendationServiceMain.service;

import com.jayakumar.RecommendationServiceMain.Repository.CategoryRepository;
import com.jayakumar.RecommendationServiceMain.Repository.ProductLikeRepository;
import com.jayakumar.RecommendationServiceMain.Repository.ProductPurchaseRepository;
import com.jayakumar.RecommendationServiceMain.Repository.ProductRepository;
import com.jayakumar.RecommendationServiceMain.exception.APIException;
import com.jayakumar.RecommendationServiceMain.exception.ResourceNotFoundException;
import com.jayakumar.RecommendationServiceMain.model.Category;
import com.jayakumar.RecommendationServiceMain.model.Product;
import com.jayakumar.RecommendationServiceMain.model.ProductLike;
import com.jayakumar.RecommendationServiceMain.model.ProductPurchase;
import com.jayakumar.RecommendationServiceMain.payload.ProductDTO;
import com.jayakumar.RecommendationServiceMain.payload.ProductResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductLikeRepository productLikeRepository;

    @Autowired
    private ProductPurchaseRepository productPurchaseRepository;

    @Override
    public ProductResponse getAllProductsByCategory(Long categoryId, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder, Integer priceMin, Integer priceMax,
                                                    Integer minProductRating, String productSize) {
        Category category=categoryRepository.findById(categoryId).orElseThrow(
                ()->new ResourceNotFoundException("Category","categoryid",categoryId)
        );

        Sort sortByAndOrder=sortOrder.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():
                Sort.by(sortBy).descending();
        Pageable pageDetails= PageRequest.of(pageNumber,pageSize,sortByAndOrder);
        Page<Product> pageProducts=productRepository.findByCategoryOrderByRatingDesc(category, pageDetails);

        if(sortBy.equals("rating"))
        {
            if(sortOrder.equals("desc")) {


            }
            else{
                pageProducts=productRepository.findByCategoryOrderByRatingAsc(category, pageDetails);
            }
        }
        else if(sortBy.equals("price"))
        {
            if(sortOrder.equals("asc"))
            {
                pageProducts=productRepository.findByCategoryOrderByPriceAsc(category, pageDetails);
            }
            else{
                pageProducts=productRepository.findByCategoryOrderByPriceDesc(category, pageDetails);
            }
        }
        else{
            if(sortOrder.equals("asc"))
            {
                pageProducts=productRepository.findByCategoryOrderByProductIdAsc(category, pageDetails);
            }
            else{
                pageProducts=productRepository.findByCategoryOrderByProductIdDesc(category, pageDetails);
            }
        }
        Page<Product> finalPageProducts=filterPageProducts(pageProducts, priceMin, priceMax, minProductRating,productSize, pageDetails);

        List<Product> products=finalPageProducts.getContent();

        List<ProductDTO> productDTOS=products.stream().map(product -> modelMapper.map(product,ProductDTO.class))
                .toList();



        ProductResponse productResponse=new ProductResponse();

        productResponse.setContent(productDTOS);
        productResponse.setPageNumber(finalPageProducts.getNumber());
        productResponse.setPageSize(finalPageProducts.getSize());
        productResponse.setTotalPages(finalPageProducts.getTotalPages());
        productResponse.setTotalElements(finalPageProducts.getTotalElements());
        productResponse.setLastPage(finalPageProducts.isLast());

        return productResponse;

    }

    @Override
    public ProductResponse getAllTrendingProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

        List<Product> productsInDB=productRepository.findAll();
        double likesWeight = 0.4;
        double purchasesWeight = 0.5;
        double viewsWeight = 0.1;

        Sort sortByAndOrder=sortOrder.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():
                Sort.by(sortBy).descending();
        Pageable pageDetails= PageRequest.of(pageNumber,pageSize,sortByAndOrder);

        List<Product> products=productsInDB.stream() .peek(product -> {
                    double relevanceScore = (likesWeight * product.getLikes()) +
                            (purchasesWeight * product.getPurchases()) +
                            (viewsWeight * product.getViews());
                    product.setRelevanceScore(relevanceScore);
                })
                .sorted((p1, p2) -> Double.compare(p2.getRelevanceScore(), p1.getRelevanceScore()))
                .collect(Collectors.toList());



        Page<Product> finalPaginatedProducts= getPaginatedProducts(products, pageDetails);
        List<Product> trendingProducts=finalPaginatedProducts.getContent();
        List<ProductDTO> productDTOS=trendingProducts.stream().map(product -> modelMapper.map(product,ProductDTO.class))
                .toList();



        ProductResponse productResponse=new ProductResponse();

        productResponse.setContent(productDTOS);
        productResponse.setPageNumber(finalPaginatedProducts.getNumber());
        productResponse.setPageSize(finalPaginatedProducts.getSize());
        productResponse.setTotalPages(finalPaginatedProducts.getTotalPages());
        productResponse.setTotalElements(finalPaginatedProducts.getTotalElements());
        productResponse.setLastPage(finalPaginatedProducts.isLast());



        return productResponse;
    }

    @Override
    public ProductDTO viewProduct(Long productId) {
        Product productFromDB=productRepository.findById(productId)
                .orElseThrow(()->new ResourceNotFoundException("Product","ProductId",productId));


        productFromDB.setViews(productFromDB.getViews()+1);
       Product savedProduct= productRepository.save(productFromDB);
       ProductDTO savedProductDTO=modelMapper.map(savedProduct,ProductDTO.class);

       return savedProductDTO;




    }

    @Override
    public ProductDTO likeProduct(Long productId, Long userId) {

        Product productFromDB=productRepository.findById(productId)
                .orElseThrow(()->new ResourceNotFoundException("Product","ProductId",productId));

        if (productLikeRepository.existsByProductIdAndUserId(productId, userId)) {
            throw new APIException("You have already liked the product!!!!");


        }

        productFromDB.setLikes(productFromDB.getLikes()+1);

     Product savedProduct=productRepository.save(productFromDB);



        ProductLike productLike = new ProductLike();
        productLike.setProductId(productId);
        productLike.setUserId(userId);
        productLikeRepository.save(productLike);

        ProductDTO productDTO=modelMapper.map(savedProduct,ProductDTO.class);

        return  productDTO;



    }

    @Override
    public ProductPurchase purchaseProductById(Long productId, Long userId, Integer purchaseQuantity) {
        Product productFromDB=productRepository.findById(productId)
                .orElseThrow(()->new ResourceNotFoundException("Product","ProductId",productId));

        productFromDB.setPurchases(productFromDB.getPurchases()+1);

        Product savedProduct=productRepository.save(productFromDB);

       Double totalAmount=purchaseQuantity*productFromDB.getPrice();

       ProductPurchase productPurchase=new ProductPurchase();
       productPurchase.setProductName(savedProduct.getProductName());
       productPurchase.setQuantity(purchaseQuantity);
       productPurchase.setTotPrice(totalAmount);
       productPurchase.setUserId(userId);

       ProductPurchase savedProductPurchase=productPurchaseRepository.save(productPurchase);



       return savedProductPurchase;




    }


    private Page<Product> filterPageProducts(Page<Product> pageProducts, Integer priceMin, Integer priceMax, Integer minProductRating, String productSize, Pageable pageable) {

        List<Product> filteredProducts = pageProducts.getContent().stream()
                .filter(product -> (priceMin == null || product.getPrice() >= priceMin))
                .filter(product -> (productSize.isEmpty() || product.getSize().equals(productSize)))
                .filter(product -> (priceMax == null || product.getPrice() <= priceMax))
                .filter(product -> (minProductRating == null || product.getRating() >= minProductRating))
                .collect(Collectors.toList());


        return new PageImpl<>(filteredProducts, pageable, filteredProducts.size());
    }


    public Page<Product> getPaginatedProducts(List<Product> products, Pageable pageable) {
        // Calculate the starting and ending indices for the current page
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), products.size());

        // Check if the starting index exceeds the total size
        if (start > products.size()) {
            return new PageImpl<>(List.of(), pageable, products.size());
        }

        // Get the sublist for the current page
        List<Product> paginatedProducts = products.subList(start, end);

        // Return a Page object
        return new PageImpl<>(paginatedProducts, pageable, products.size());
    }

}
