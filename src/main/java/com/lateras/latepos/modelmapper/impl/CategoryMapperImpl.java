package com.lateras.latepos.modelmapper.impl;

import com.lateras.latepos.entity.Category;
import com.lateras.latepos.model.response.CategoryResponse;
import com.lateras.latepos.modelmapper.CategoryMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public CategoryResponse mapCategoryToCategoryResponse(Category category) {
        return CategoryResponse.builder()
            .id(category.getId())
            .name(category.getName())
            .description(category.getDescription())
            .build();
    }
}
