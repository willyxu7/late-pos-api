package com.lateras.latepos.modelmapper;

import com.lateras.latepos.entity.Variant;
import com.lateras.latepos.model.response.VariantResponse;

public interface VariantMapper {

    VariantResponse mapVariantToVariantResponse(Variant variant);

}
