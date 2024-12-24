package com.jayakumar.RecommendationServiceMain;

import com.jayakumar.RecommendationServiceMain.Repository.CategoryRepository;
import com.jayakumar.RecommendationServiceMain.Repository.ProductRepository;
import com.jayakumar.RecommendationServiceMain.model.Category;
import com.jayakumar.RecommendationServiceMain.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RecommendationServiceMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecommendationServiceMainApplication.class, args);
	}


}
