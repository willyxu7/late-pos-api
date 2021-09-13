package com.lateras.latepos.service.impl;

import com.lateras.latepos.exception.CategoryNotFoundException;
import com.lateras.latepos.model.request.CreateCategoryRequest;
import com.lateras.latepos.entity.Category;
import com.lateras.latepos.model.request.UpdateCategoryRequest;
import com.lateras.latepos.model.response.CategoryResponse;
import com.lateras.latepos.modelmapper.CategoryMapper;
import com.lateras.latepos.respository.CategoryRepository;
import com.lateras.latepos.service.CategoryService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponse> getCategories(Pageable pageable) {
        Page<Category> all = categoryRepository.findAll(pageable);
        List<Category> categories = all.get().collect(Collectors.toList());

        return categories
            .stream()
            .map(category -> categoryMapper.mapCategoryToCategoryResponse(category))
            .collect(Collectors.toList());
    }

    @Override
    public CategoryResponse getCategoryById(String id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        return categoryOptional
            .map(category -> categoryMapper.mapCategoryToCategoryResponse(category))
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
                return category;
            })
            .map(category -> categoryMapper.mapCategoryToCategoryResponse(category))
            .orElseThrow(() -> {
                throw new RuntimeException();
            });
    }

    @Override
    public void deleteCategory(String id) {
        categoryRepository.deleteById(id);
    }

}
