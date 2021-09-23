package com.lateras.latepos.modelmapper.impl;

import com.lateras.latepos.entity.Variant;
import com.lateras.latepos.model.response.VariantResponse;
import com.lateras.latepos.modelmapper.VariantMapper;
import org.springframework.stereotype.Service;

@Service
public class VariantMapperImpl implements VariantMapper {

    @Override
    public VariantResponse mapVariantToVariantResponse(Variant variant) {
        return VariantResponse.builder()
                .id(variant.getId())
                .name(variant.getName())
                .productId(variant.getProduct().getId())
                .price(variant.getPrice())
                .sku(variant.getSku())
                .description(variant.getDescription())
                .build();
    }
}
