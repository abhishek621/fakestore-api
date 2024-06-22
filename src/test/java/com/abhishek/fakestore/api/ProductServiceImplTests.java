package com.abhishek.fakestore.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import com.abhishek.fakestore.api.model.Product;
import com.abhishek.fakestore.api.service.impl.ProductServiceImpl;

@SpringBootTest
class ProductServiceImplTests {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private ProductServiceImpl productService;

	@Value("${fakestore.api.url}")
	private String apiUrl;

	Product product1;

	Product product2;

	@BeforeEach
	public void setUp() {
		productService = new ProductServiceImpl(restTemplate);
		product1 = new Product(1L, "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
				"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
				109.95);
		product2 = new Product(2L, "Mens Casual Premium Slim Fit T-Shirts",
				"Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.",
				22.3);

	}

	@Test
	void testGetAllProducts() {

		List<Product> expectedProducts = Arrays.asList(product1, product2);

		when(restTemplate.getForObject(apiUrl, Product[].class)).thenReturn(expectedProducts.toArray(new Product[0]));

		List<Product> actualProducts = productService.getAllProducts();

		assertNotNull(actualProducts);

	}
}
