package com.lateras.latepos.model.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UpdateVariantRequest {

    @NotNull
    @NotEmpty
    private String name;

    @Min(value = 1)
    private BigDecimal price;

    private String sku;
    private String description;

}
