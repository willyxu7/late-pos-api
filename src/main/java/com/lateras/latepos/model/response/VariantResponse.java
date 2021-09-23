package com.lateras.latepos.model.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class VariantResponse {
    private String id;
    private String name;
    private String productId;
    private BigDecimal price;
    private String sku;
    private String description;
}
