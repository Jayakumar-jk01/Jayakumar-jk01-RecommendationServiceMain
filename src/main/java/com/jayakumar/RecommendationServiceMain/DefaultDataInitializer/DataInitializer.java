package com.jayakumar.RecommendationServiceMain.DefaultDataInitializer;

import com.jayakumar.RecommendationServiceMain.Repository.CategoryRepository;
import com.jayakumar.RecommendationServiceMain.Repository.ProductRepository;
import com.jayakumar.RecommendationServiceMain.model.Category;
import com.jayakumar.RecommendationServiceMain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public DataInitializer(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create Categories
        Category tops = new Category();
        tops.setCategoryName("Tops");

        Category bottoms = new Category();
        bottoms.setCategoryName("Bottoms");

        Category outerwear = new Category();
        outerwear.setCategoryName("Outerwear");



        Category dresses = new Category();
        dresses.setCategoryName("Dresses");

        Category activewear = new Category();
        activewear.setCategoryName("Activewear");

        Category swimwear = new Category();
        swimwear.setCategoryName("Swimwear");

        Category formalwear = new Category();
        formalwear.setCategoryName("Formalwear");

        Category casualwear = new Category();
        casualwear.setCategoryName("Casualwear");

        Category sportswear = new Category();
        sportswear.setCategoryName("Sportswear");

        Category nightwear = new Category();
        nightwear.setCategoryName("Nightwear");

        categoryRepository.saveAll(List.of(tops, bottoms, outerwear, dresses, activewear, swimwear, formalwear, casualwear, sportswear, nightwear));


        // Create Products for each category (10 products per category)
        productRepository.saveAll(List.of(
                // Tops
                new Product(null, "T-Shirt", 19.99, "Red", "M", 4, 120, 45, 30, tops),
                new Product(null, "Shirt", 29.99, "Blue", "L", 5, 200, 80, 60, tops),
                new Product(null, "Blouse", 34.99, "White", "S", 4, 150, 60, 50, tops),
                new Product(null, "Tank Top", 15.99, "Black", "M", 3, 130, 50, 40, tops),
                new Product(null, "Sweater", 49.99, "Gray", "L", 5, 160, 70, 55, tops),
                new Product(null, "Hoodie", 39.99, "Green", "M", 4, 170, 75, 60, tops),
                new Product(null, "Button-Down Shirt", 59.99, "Yellow", "L", 5, 110, 40, 35, tops),
                new Product(null, "Crop Top", 19.99, "Pink", "S", 4, 140, 55, 45, tops),
                new Product(null, "Polo Shirt", 25.99, "Navy", "M", 5, 180, 65, 50, tops),
                new Product(null, "Turtleneck", 39.99, "Beige", "L", 5, 200, 85, 65, tops),

                // Bottoms
                new Product(null, "Jeans", 49.99, "Black", "M", 5, 300, 120, 100, bottoms),
                new Product(null, "Skirt", 39.99, "Pink", "S", 4, 180, 70, 40, bottoms),
                new Product(null, "Shorts", 24.99, "Green", "M", 3, 90, 25, 15, bottoms),
                new Product(null, "Chinos", 39.99, "Beige", "L", 5, 220, 90, 80, bottoms),
                new Product(null, "Leggings", 29.99, "Black", "S", 4, 160, 65, 50, bottoms),
                new Product(null, "Sweatpants", 35.99, "Gray", "M", 5, 250, 100, 75, bottoms),
                new Product(null, "Cargo Pants", 49.99, "Olive", "L", 4, 170, 60, 55, bottoms),
                new Product(null, "Jean Shorts", 29.99, "Light Blue", "S", 4, 150, 55, 40, bottoms),
                new Product(null, "Pencil Skirt", 44.99, "Black", "M", 5, 210, 85, 70, bottoms),
                new Product(null, "Track Pants", 32.99, "Navy", "L", 5, 180, 60, 45, bottoms),

                // Outerwear
                new Product(null, "Jacket", 79.99, "Brown", "L", 5, 250, 90, 70, outerwear),
                new Product(null, "Coat", 99.99, "Gray", "M", 4, 220, 85, 60, outerwear),
                new Product(null, "Sweater", 59.99, "Blue", "L", 4, 130, 50, 35, outerwear),
                new Product(null, "Blazer", 129.99, "Black", "S", 5, 170, 60, 50, outerwear),
                new Product(null, "Cardigan", 49.99, "White", "M", 4, 180, 70, 60, outerwear),
                new Product(null, "Raincoat", 89.99, "Yellow", "L", 3, 200, 80, 65, outerwear),
                new Product(null, "Parka", 129.99, "Olive", "M", 5, 220, 90, 75, outerwear),
                new Product(null, "Bomber Jacket", 79.99, "Red", "S", 5, 210, 80, 65, outerwear),
                new Product(null, "Fleece Jacket", 69.99, "Purple", "L", 5, 250, 100, 85, outerwear),
                new Product(null, "Windbreaker", 59.99, "Black", "M", 4, 160, 65, 55, outerwear),



                // Dresses
                new Product(null, "Maxi Dress", 59.99, "Red", "M", 5, 180, 60, 45, dresses),
                new Product(null, "Cocktail Dress", 89.99, "Black", "L", 4, 150, 80, 60, dresses),
                new Product(null, "A-Line Dress", 49.99, "Blue", "S", 5, 140, 55, 50, dresses),
                new Product(null, "Shift Dress", 59.99, "Green", "M", 4, 170, 65, 55, dresses),
                new Product(null, "Bodycon Dress", 69.99, "Pink", "L", 5, 180, 70, 65, dresses),
                new Product(null, "Mini Dress", 39.99, "Yellow", "S", 4, 150, 60, 50, dresses),
                new Product(null, "Empire Waist Dress", 79.99, "Purple", "M", 5, 160, 65, 55, dresses),
                new Product(null, "Peplum Dress", 49.99, "Orange", "L", 4, 140, 50, 45, dresses),
                new Product(null, "Boho Dress", 59.99, "Brown", "S", 5, 180, 75, 65, dresses),
                new Product(null, "Sundress", 39.99, "White", "M", 5, 200, 80, 70, dresses),

                // Activewear
                new Product(null, "Yoga Pants", 39.99, "Gray", "S", 5, 200, 85, 70, activewear),
                new Product(null, "Sports Bra", 24.99, "Pink", "M", 4, 160, 60, 45, activewear),
                new Product(null, "Running Shorts", 29.99, "Black", "S", 5, 170, 65, 55, activewear),
                new Product(null, "Gym Leggings", 39.99, "Blue", "M", 4, 180, 70, 60, activewear),
                new Product(null, "Training Shoes", 49.99, "Red", "9", 5, 200, 90, 75, activewear),
                new Product(null, "Sports Jacket", 59.99, "Gray", "L", 4, 160, 55, 45, activewear),
                new Product(null, "Compression Socks", 19.99, "White", "One Size", 5, 150, 60, 50, activewear),
                new Product(null, "Running Cap", 24.99, "Black", "One Size", 5, 130, 50, 40, activewear),
                new Product(null, "Athletic Shorts", 29.99, "Purple", "M", 4, 140, 55, 45, activewear),
                new Product(null, "Workout Tank", 19.99, "Pink", "S", 5, 180, 70, 60, activewear),

                //swimwear
                new Product(null, "One-Piece Swimsuit", 49.99, "Blue", "M", 5, 200, 80, 60, swimwear),
                new Product(null, "Bikini", 39.99, "Pink", "S", 4, 180, 70, 50, swimwear),
                new Product(null, "Swim Trunks", 29.99, "Red", "L", 5, 150, 60, 40, swimwear),
                new Product(null, "Tankini", 44.99, "Green", "M", 4, 170, 70, 55, swimwear),
                new Product(null, "Board Shorts", 34.99, "Black", "L", 5, 190, 75, 60, swimwear),
                new Product(null, "Rash Guard", 54.99, "Gray", "M", 5, 250, 90, 70, swimwear),
                new Product(null, "Swim Dress", 59.99, "Purple", "S", 4, 160, 65, 50, swimwear),
                new Product(null, "High-Waisted Bikini", 49.99, "Yellow", "M", 4, 200, 80, 65, swimwear),
                new Product(null, "Swim Shorts", 24.99, "Navy", "L", 5, 140, 55, 40, swimwear),
                new Product(null, "Cover-Up", 34.99, "White", "One Size", 4, 100, 40, 30, swimwear),

                // formalwear

                new Product(null, "Business Suit", 199.99, "Navy", "L", 5, 400, 180, 150, formalwear),
                new Product(null, "Blazer", 129.99, "Black", "M", 4, 300, 120, 100, formalwear),
                new Product(null, "Pencil Skirt", 49.99, "Gray", "S", 4, 200, 80, 60, formalwear),
                new Product(null, "Dress Shirt", 39.99, "White", "M", 5, 250, 100, 80, formalwear),
                new Product(null, "Trousers", 59.99, "Black", "L", 5, 220, 90, 70, formalwear),
                new Product(null, "Sheath Dress", 99.99, "Red", "M", 4, 180, 75, 60, formalwear),
                new Product(null, "Formal Gown", 149.99, "Blue", "L", 5, 350, 150, 120, formalwear),
                new Product(null, "Tuxedo", 249.99, "Black", "M", 5, 500, 200, 180, formalwear),
                new Product(null, "Tie", 19.99, "Silver", "One Size", 4, 100, 40, 30, formalwear),
                new Product(null, "Waistcoat", 74.99, "Charcoal", "M", 4, 160, 70, 55, formalwear),

                //casualwear

                new Product(null, "Graphic T-Shirt", 19.99, "White", "M", 5, 200, 80, 60, casualwear),
                new Product(null, "Denim Jacket", 59.99, "Blue", "L", 5, 300, 120, 100, casualwear),
                new Product(null, "Joggers", 34.99, "Gray", "M", 4, 250, 90, 70, casualwear),
                new Product(null, "Casual Shirt", 29.99, "Plaid", "M", 4, 180, 70, 50, casualwear),
                new Product(null, "Hooded Sweatshirt", 39.99, "Black", "L", 5, 200, 80, 65, casualwear),
                new Product(null, "Chino Shorts", 24.99, "Beige", "M", 4, 160, 60, 40, casualwear),
                new Product(null, "Flannel Shirt", 49.99, "Red", "L", 5, 300, 120, 100, casualwear),
                new Product(null, "Polo Shirt", 29.99, "Green", "M", 4, 220, 90, 70, casualwear),
                new Product(null, "Sweatpants", 34.99, "Navy", "L", 5, 250, 100, 80, casualwear),
                new Product(null, "Baseball Cap", 19.99, "Blue", "One Size", 4, 100, 40, 30, casualwear),


                //sportswear

                new Product(null, "Running Shoes", 89.99, "Black", "10", 5, 300, 120, 100, sportswear),
                new Product(null, "Sports T-shirt", 29.99, "Gray", "M", 4, 200, 80, 60, sportswear),
                new Product(null, "Compression Leggings", 49.99, "Blue", "S", 5, 250, 100, 80, sportswear),
                new Product(null, "Track Jacket", 59.99, "Red", "L", 4, 300, 120, 90, sportswear),
                new Product(null, "Training Shorts", 24.99, "Navy", "M", 4, 200, 80, 60, sportswear),
                new Product(null, "Tank Top", 19.99, "White", "L", 5, 180, 70, 50, sportswear),
                new Product(null, "Athletic Socks", 12.99, "Black", "One Size", 4, 150, 50, 40, sportswear),
                new Product(null, "Yoga Pants", 39.99, "Purple", "M", 5, 220, 90, 70, sportswear),
                new Product(null, "Sweat-Wicking T-Shirt", 34.99, "Green", "M", 5, 200, 80, 65, sportswear),
                new Product(null, "Headband", 9.99, "Pink", "One Size", 4, 100, 40, 30, sportswear),


                new Product(null, "Silk Pajama Set", 79.99, "Black", "M", 5, 200, 80, 60, nightwear),
                new Product(null, "Cotton Sleep Shirt", 29.99, "Pink", "S", 4, 180, 70, 50, nightwear),
                new Product(null, "Loungewear Shorts", 24.99, "Gray", "M", 4, 150, 60, 40, nightwear),
                new Product(null, "Flannel Pajamas", 49.99, "Red", "L", 5, 250, 100, 80, nightwear),
                new Product(null, "Robe", 54.99, "White", "M", 5, 200, 80, 60, nightwear),
                new Product(null, "Sleep Dress", 39.99, "Blue", "S", 4, 220, 90, 70, nightwear),
                new Product(null, "Nightgown", 34.99, "Lavender", "L", 4, 180, 75, 60, nightwear),
                new Product(null, "Button-Down Pajama Set", 59.99, "Green", "M", 5, 250, 100, 80, nightwear),
                new Product(null, "Thermal Pajamas", 44.99, "Navy", "L", 4, 190, 80, 65, nightwear),
                new Product(null, "Sleep Mask and Robe Set", 29.99, "Pink", "One Size", 4, 160, 65, 50, nightwear)

        ));
    }
}


//reference for product Model
//      public Product(Long productId, String productName, double price,
//        String color, String size, int rating, int views,
//        int likes, int purchases, Category category) {
//            this.productId = productId;
//            this.productName = productName;
//            this.price = price;
//            this.color = color;
//            this.size = size;
//            this.rating = rating;
//            this.views = views;
//            this.likes = likes;
//            this.purchases = purchases;
//            this.category = category;
//        }