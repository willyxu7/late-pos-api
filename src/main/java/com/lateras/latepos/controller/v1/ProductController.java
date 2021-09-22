package com.lateras.latepos.controller.v1;

import com.lateras.latepos.model.request.CreateProductRequest;
import com.lateras.latepos.model.request.UpdateProductRequest;
import com.lateras.latepos.model.response.ProductResponse;
import com.lateras.latepos.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "api/v1/products")
public class ProductController extends BaseController{

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts(Pageable pageable) {
        return response("success get products", productService.getProductResponses(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody CreateProductRequest createProductRequest) {
        return response("success create product", productService.createProduct(createProductRequest), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable(value = "id") String id) {
        return response("success get product", productService.getProductResponseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable(value = "id") String id,
            @Valid @RequestBody UpdateProductRequest updateProductRequest
    ) {
        return response("success update product", productService.updateProduct(id, updateProductRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") String id) {
        return response("success delete product", productService.deleteProduct(id), HttpStatus.NO_CONTENT);
    }

}
