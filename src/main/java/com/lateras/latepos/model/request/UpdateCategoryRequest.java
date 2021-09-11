package com.lateras.latepos.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateCategoryRequest {
    private String name;
    private String description;
}
