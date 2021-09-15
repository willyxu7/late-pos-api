package com.lateras.latepos.model.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class UpdateCategoryRequest {
    @NotNull(message = "name must not be null")
    @NotEmpty(message = "name must not be empty")
    private String name;

    private String description;
}
