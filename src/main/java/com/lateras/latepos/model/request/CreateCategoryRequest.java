package com.lateras.latepos.model.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCategoryRequest {
    @NotNull(message = "Name must not be null")
    @NotEmpty(message = "Name must not be empty")
    private String name;
    private String description;
}
