package com.lateras.latepos.model.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CreateVariantRequest {
    @NotNull (message = "name must be not null")
    @NotEmpty (message = "name must be not empty")
    private String name;

    @NotNull(message = "price must be not null")
    @Min(value = 1)
    private BigDecimal price;

    private String sku;
    private String description;
}
