package com.lateras.latepos.service;

import com.lateras.latepos.entity.Product;
import com.lateras.latepos.model.request.CreateVariantRequest;
import com.lateras.latepos.model.request.UpdateVariantRequest;
import com.lateras.latepos.model.response.VariantResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VariantService {

//    List<VariantResponse> getVariants(Pageable pageable);

    void createVariant(CreateVariantRequest createVariantRequest, Product product);

    List<VariantResponse> getVariantResponsesBasedOnProduct(String productId);

    void updateVariant(String variantId, UpdateVariantRequest updateVariantRequest);
}
