package com.lateras.latepos.service.impl;

import com.lateras.latepos.entity.Product;
import com.lateras.latepos.entity.Variant;
import com.lateras.latepos.exception.ProductNotFoundException;
import com.lateras.latepos.exception.VariantNotFoundException;
import com.lateras.latepos.model.request.CreateVariantRequest;
import com.lateras.latepos.model.request.UpdateVariantRequest;
import com.lateras.latepos.model.response.VariantResponse;
import com.lateras.latepos.modelmapper.VariantMapper;
import com.lateras.latepos.respository.VariantRepository;
import com.lateras.latepos.service.ProductService;
import com.lateras.latepos.service.VariantService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VariantServiceImpl implements VariantService {

//    private final ProductService productService;

    private final VariantRepository variantRepository;

    private final VariantMapper variantMapper;

//    @Override
//    public List<VariantResponse> getVariants(Pageable pageable) {
//        Page<Variant> all = variantRepository.findAll(pageable);
//        List<Variant> variants = all.get().collect(Collectors.toList());
//
//        return variants.stream()
//                .map(variantMapper::mapVariantToVariantResponse)
//                .collect(Collectors.toList());
//    }

    @Override
    public void createVariant(CreateVariantRequest createVariantRequest, Product product) {

        if(Objects.isNull(product)) {
            throw new ProductNotFoundException("product not found");
        }

        Variant variant = new Variant();
        variant.setName(createVariantRequest.getName());
        variant.setProduct(product);
        variant.setPrice(createVariantRequest.getPrice());
        variant.setSku(createVariantRequest.getSku());
        variant.setDescription(createVariantRequest.getDescription());
        variantRepository.save(variant);
    }

    @Override
    public List<VariantResponse> getVariantResponsesBasedOnProduct(String productId) {
        List<Variant> variants = variantRepository.findAllByProductId(productId);

        return variants.stream()
                .map(variantMapper::mapVariantToVariantResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void updateVariant(String variantId, UpdateVariantRequest updateVariantRequest) {
        Variant variant = variantRepository.findById(variantId)
                .orElseThrow(() -> new VariantNotFoundException("variant not found"));

        variant.setName(updateVariantRequest.getName());
        variant.setPrice(updateVariantRequest.getPrice());
        variant.setSku(updateVariantRequest.getSku());
        variant.setDescription(updateVariantRequest.getDescription());
        variantRepository.save(variant);
    }


}
