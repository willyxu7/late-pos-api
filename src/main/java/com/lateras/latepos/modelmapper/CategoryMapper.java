package com.lateras.latepos.modelmapper;

import com.lateras.latepos.entity.Category;
import com.lateras.latepos.model.response.CategoryResponse;

public interface CategoryMapper {
    CategoryResponse mapCategoryToCategoryResponse(Category category);
}
