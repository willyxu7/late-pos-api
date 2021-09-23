package com.lateras.latepos.service;

import com.lateras.latepos.entity.Category;
import com.lateras.latepos.entity.Product;
import com.lateras.latepos.model.request.CreateCategoryRequest;
import com.lateras.latepos.model.request.CreateProductRequest;
import com.lateras.latepos.model.request.CreateVariantRequest;
import com.lateras.latepos.model.response.CategoryResponse;
import com.lateras.latepos.model.response.ProductResponse;
import com.lateras.latepos.model.response.VariantResponse;
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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private VariantService variantService;

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
    public void testCreateProductAndVariants() {
        CreateVariantRequest createVariantRequest = new CreateVariantRequest("Kopi Susu Es", BigDecimal.valueOf(10000), "", "");
        CreateVariantRequest createVariantRequest2 = new CreateVariantRequest("Kopi Susu Panas", BigDecimal.valueOf(8000), "", "");

        List<CreateVariantRequest> createVariantRequests = new ArrayList<>();
        createVariantRequests.add(createVariantRequest);
        createVariantRequests.add(createVariantRequest2);

        CreateProductRequest createProductRequest = new CreateProductRequest(
            "Kopi Susu",
            "c63a122b-36bd-4c38-b125-ff411cc407d4",
            "",
            createVariantRequests
        );

        ProductResponse productResponse = productService.createProduct(createProductRequest);

        List<VariantResponse> variantResponses = variantService.getVariantResponsesBasedOnProduct(productResponse.getId());

        System.out.println(variantResponses);
        Assertions.assertNotNull(variantResponses);

    }
}
