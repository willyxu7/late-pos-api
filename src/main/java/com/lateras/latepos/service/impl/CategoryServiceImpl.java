package com.lateras.latepos.service.impl;

import com.lateras.latepos.exception.CategoryNotFoundException;
import com.lateras.latepos.model.request.CreateCategoryRequest;
import com.lateras.latepos.entity.Category;
import com.lateras.latepos.model.request.UpdateCategoryRequest;
import com.lateras.latepos.model.response.CategoryResponse;
import com.lateras.latepos.modelmapper.CategoryMapper;
import com.lateras.latepos.respository.CategoryRepository;
import com.lateras.latepos.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponse> getCategories(Pageable pageable) {
        Page<Category> all = categoryRepository.findAll(pageable);
        List<Category> categories = all.get().collect(Collectors.toList());

        return categories
            .stream()
            .map(categoryMapper::mapCategoryToCategoryResponse)
            .collect(Collectors.toList());
    }

    @Override
    public CategoryResponse getCategoryResponseById(String id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        return categoryOptional
            .map(categoryMapper::mapCategoryToCategoryResponse)
            .orElseThrow(() -> new CategoryNotFoundException("category not found"));
    }

    @Override
    public CategoryResponse createCategory(CreateCategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        category.setDescription(categoryRequest.getDescription());
        categoryRepository.save(category);

        return categoryMapper.mapCategoryToCategoryResponse(category);
    }

    @Override
    public CategoryResponse updateCategory(String id, UpdateCategoryRequest updateCategoryRequest) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return categoryOptional
            .map(category -> {
                category.setName(updateCategoryRequest.getName());
                category.setDescription(updateCategoryRequest.getDescription());
                categoryRepository.save(category);
                return category;
            })
            .map(categoryMapper::mapCategoryToCategoryResponse)
            .orElseThrow(() -> new CategoryNotFoundException("category not found"));
    }

    @Override
    public void deleteCategory(String id) {
        if(! categoryRepository.existsById(id)) {
            throw new CategoryNotFoundException("category not found");
        }

        categoryRepository.deleteById(id);
    }

    @Override
    public Category getCategoryById(String id) {
        return categoryRepository.findById(id)
            .orElseThrow(() -> new CategoryNotFoundException("category not found"));
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }


}
