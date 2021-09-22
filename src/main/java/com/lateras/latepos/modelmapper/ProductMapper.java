package com.lateras.latepos.modelmapper;

import com.lateras.latepos.entity.Product;
import com.lateras.latepos.model.response.ProductResponse;

public interface ProductMapper {

    public ProductResponse mapProductToProductResponse(Product product);
}
