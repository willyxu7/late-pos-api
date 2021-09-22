package com.lateras.latepos.model.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UpdateProductRequest {
    @NotNull (message = "category_id must no be null")
    @NotEmpty (message = "category_id must no be empty")
    private String categoryId;

    @NotNull (message = "name must no be null")
    @NotEmpty (message = "name must no be empty")
    private String name;

    private String description;
}
