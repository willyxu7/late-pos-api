package com.lateras.latepos.controller.v1;

import com.lateras.latepos.model.request.CreateCategoryRequest;
import com.lateras.latepos.model.request.UpdateCategoryRequest;
import com.lateras.latepos.model.response.CategoryResponse;
import com.lateras.latepos.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController extends BaseController{

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getCategories(Pageable pageable) {
        return response("success get categories", categoryService.getCategories(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable(value = "id") String id) {
        return response("success get category", categoryService.getCategoryResponseById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CreateCategoryRequest categoryRequest) {
        return response("success create category", categoryService.createCategory(categoryRequest), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(
            @PathVariable(value = "id") String id,
            @Valid @RequestBody UpdateCategoryRequest updateCategoryRequest)
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
