package com.lateras.latepos.service;

import com.lateras.latepos.entity.Category;
import com.lateras.latepos.entity.Product;
import com.lateras.latepos.model.request.CreateCategoryRequest;
import com.lateras.latepos.model.request.CreateProductRequest;
import com.lateras.latepos.model.response.CategoryResponse;
import com.lateras.latepos.model.response.ProductResponse;
import com.lateras.latepos.respository.CategoryRepository;
import com.lateras.latepos.respository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class ProductServiceTest {

    @Mock
    private ProductService productService;

    @BeforeEach
    void setUp() {

    }

    @Test
    public void testSuccessGetProducts()
    {
        Pageable pageable = Mockito.mock(Pageable.class);

        List<ProductResponse> productResponses = productService.getProductResponses(pageable);

        Assertions.assertNotNull(productResponses);
    }

    @Test
    public void testSuccessCreateProduct() {

        Category category = new Category();
        category.setId("55b20695-b9ae-4c37-a4d5-56e9f8e3d110");
        category.setName("Kopi");

        CreateProductRequest createProductRequest = new CreateProductRequest(
            "Kopi Susu Es",
            "55b20695-b9ae-4c37-a4d5-56e9f8e3d110",
            "Test Insert Product Kopi Susu Es"
        );

        Mockito.when(productService.createProduct(createProductRequest))
                .thenReturn(new ProductResponse("123","Kopi Susu Es", category.getName(), "test"));

        ProductResponse productResponse = productService.createProduct(createProductRequest);

        System.out.println(productResponse);
        Assertions.assertNotNull(productResponse);
        Assertions.assertSame("Kopi Susu Es", productResponse.getName());
    }
}
