package com.lateras.latepos.model.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.lateras.latepos.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CreateProductRequest {

    @NotNull(message = "name must no be null")
    @NotEmpty(message = "name must not be empty")
    private String name;

    @NotNull(message = "category must not be null")
    @NotEmpty(message = "category must not be empty")
    private String categoryId;

    private String description;
}
