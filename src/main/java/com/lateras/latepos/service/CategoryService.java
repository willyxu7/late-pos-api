package com.lateras.latepos.service;

import com.lateras.latepos.model.request.CreateCategoryRequest;
import com.lateras.latepos.entity.Category;
import com.lateras.latepos.model.request.UpdateCategoryRequest;
import com.lateras.latepos.model.response.CategoryResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getCategories(Pageable pageable);

    CategoryResponse getCategoryById(String id);

    void createCategory(CreateCategoryRequest categoryRequest);

    CategoryResponse updateCategory(String id, UpdateCategoryRequest updateCategoryRequest);

    void deleteCategory(String id);
}
