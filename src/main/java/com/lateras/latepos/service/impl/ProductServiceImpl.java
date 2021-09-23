package com.lateras.latepos.service.impl;

import com.lateras.latepos.entity.Category;
import com.lateras.latepos.entity.Product;
import com.lateras.latepos.exception.ProductNotFoundException;
import com.lateras.latepos.model.request.CreateProductRequest;
import com.lateras.latepos.model.request.CreateVariantRequest;
import com.lateras.latepos.model.request.UpdateProductRequest;
import com.lateras.latepos.model.response.ProductResponse;
import com.lateras.latepos.modelmapper.ProductMapper;
import com.lateras.latepos.respository.ProductRepository;
import com.lateras.latepos.service.CategoryService;
import com.lateras.latepos.service.ProductService;
import com.lateras.latepos.service.VariantService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final VariantService variantService;

    private final ProductMapper productMapper;


    @Override
    public List<ProductResponse> getProductResponses(Pageable pageable) {
        Page<Product> all = productRepository.findAll(pageable);
        List<Product> products = all.get().collect(Collectors.toList());


        return products.stream()
            .map(productMapper::mapProductToProductResponse)
            .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductResponseById(String id) {
        Optional<Product> productResponse = productRepository.findById(id);

        return productResponse
            .map(productMapper::mapProductToProductResponse)
            .orElseThrow(() -> new ProductNotFoundException("product with id: " + id + " not found"));
    }

    @Override
    public ProductResponse createProduct(CreateProductRequest createProductRequest) {
        Category category = categoryService.getCategoryById(createProductRequest.getCategoryId());

        Product product = new Product();
        product.setName(createProductRequest.getName());
        product.setCategory(category);
        product.setDescription(createProductRequest.getDescription());
        product = productRepository.save(product);

        for (CreateVariantRequest variantRequest : createProductRequest.getCreateVariantRequests()) {
            variantService.createVariant(variantRequest, product);
        }

        return productMapper.mapProductToProductResponse(product);
    }

    @Override
    public ProductResponse updateProduct(String id, UpdateProductRequest updateProductRequest) {
        Category category = categoryService.getCategoryById(updateProductRequest.getCategoryId());
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional
                .map(product -> {
                    product.setName(updateProductRequest.getName());
                    product.setCategory(category);
                    product.setDescription(updateProductRequest.getDescription());
                    productRepository.save(product);
                    return product;
                })
                .map(productMapper::mapProductToProductResponse)
                .orElseThrow(() -> new ProductNotFoundException("product with id: " + id + " not found"));
    }

    @Override
    public Void deleteProduct(String id) {
        if(!productRepository.existsById(id)) {
            throw new ProductNotFoundException("product with id: " + id + " not found");
        }

        productRepository.deleteById(id);

        return null;
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException("product with id: " + id + " not found"));
    }

}
