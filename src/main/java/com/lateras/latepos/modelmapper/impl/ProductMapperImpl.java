package com.lateras.latepos.modelmapper.impl;

import com.lateras.latepos.entity.Product;
import com.lateras.latepos.model.response.ProductResponse;
import com.lateras.latepos.modelmapper.ProductMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductResponse mapProductToProductResponse(Product product) {
        return ProductResponse.builder()
            .id(product.getId())
            .name(product.getName())
            .categoryName(product.getCategory().getName())
            .description(product.getDescription())
            .build();
    }
}
