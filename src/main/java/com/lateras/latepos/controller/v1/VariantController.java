package com.lateras.latepos.controller.v1;

import com.lateras.latepos.model.request.CreateVariantRequest;
import com.lateras.latepos.model.response.VariantResponse;
import com.lateras.latepos.service.VariantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/variants")
@AllArgsConstructor
public class VariantController extends BaseController{

    private final VariantService variantService;

//    @PostMapping
//    public ResponseEntity<VariantResponse> createVariant(@Valid @RequestBody CreateVariantRequest createVariantRequest) {
//        return response("success create variant", variantService.createVariant(createVariantRequest), HttpStatus.OK);
//    }

    @GetMapping("/{product_id}")
    public ResponseEntity<List<VariantResponse>> getVariantsBasedOnProduct(@PathVariable(value = "product_id") String productId) {
        return response("success get variants", variantService.getVariantResponsesBasedOnProduct(productId), HttpStatus.OK);
    }

}
