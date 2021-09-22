package com.lateras.latepos.service;

import com.lateras.latepos.entity.Product;
import com.lateras.latepos.model.request.CreateProductRequest;
import com.lateras.latepos.model.request.UpdateProductRequest;
import com.lateras.latepos.model.response.ProductResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    List<ProductResponse> getProductResponses(Pageable pageable);

    ProductResponse getProductResponseById(String id);

    ProductResponse createProduct(CreateProductRequest createProductRequest);

    ProductResponse updateProduct(String id, UpdateProductRequest updateProductRequest);

    Void deleteProduct(String id);

    Product getProductById(String id);
}
