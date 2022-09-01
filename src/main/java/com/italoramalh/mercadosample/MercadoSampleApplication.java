package com.italoramalh.mercadosample;

import com.italoramalh.mercadosample.models.Cart;
import com.italoramalh.mercadosample.models.Category;
import com.italoramalh.mercadosample.models.Product;
import com.italoramalh.mercadosample.models.User;
import com.italoramalh.mercadosample.repositories.UserRepository;
import com.italoramalh.mercadosample.services.CartService;
import com.italoramalh.mercadosample.services.CategoryService;
import com.italoramalh.mercadosample.services.ProductService;
import com.italoramalh.mercadosample.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class MercadoSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercadoSampleApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserService userService, CartService cartService, ProductService productService, CategoryService categoryService){
		return (args)-> {
			User user = User.builder().email("jesselindinho100@gmail.com").name("jesse franklin").username("josuefrancisco").build();
			userService.save(user);
			Category category = Category.builder().description("Produtos sem açucar").name("Integrais").build();
			Product product = Product.builder().available(true).categoryId(category.getId()).name("Pão integral - SevenBoys").description("Pão sem gorduras e gluten").build();

			Cart cart = Cart.builder().user(user).build();
			Set<Product> productSet = new HashSet<>();
			cart.setProducts(productSet);
			cart.addProduct(product);
			categoryService.save(category);
			productService.save(product);
			cartService.save(cart);
		};
	}
}