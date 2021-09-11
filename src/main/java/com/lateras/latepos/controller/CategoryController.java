package com.lateras.latepos.controller;

import com.lateras.latepos.model.request.CreateCategoryRequest;
import com.lateras.latepos.entity.Category;
import com.lateras.latepos.model.request.UpdateCategoryRequest;
import com.lateras.latepos.model.response.CategoryResponse;
import com.lateras.latepos.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getCategories(Pageable pageable) {
        List<CategoryResponse> categories =  categoryService.getCategories(pageable);
        return new ResponseEntity<List<CategoryResponse>>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable(value = "id") String id) {
        CategoryResponse category = categoryService.getCategoryById(id);
        return new ResponseEntity<CategoryResponse>(category, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createCategory(@RequestBody CreateCategoryRequest categoryRequest) throws URISyntaxException {
        categoryService.createCategory(categoryRequest);
        return ResponseEntity.created(new URI("/v1/categories")).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(
            @PathVariable(value = "id") String id,
            @RequestBody UpdateCategoryRequest updateCategoryRequest)
    {
        CategoryResponse category = categoryService.updateCategory(id, updateCategoryRequest);
        return new ResponseEntity<CategoryResponse>(category, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable(value = "id") String id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}
