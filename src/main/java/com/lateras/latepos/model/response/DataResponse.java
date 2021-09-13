package com.lateras.latepos.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class DataResponse<T> {
    private String message;
    private final List<Object> errors = new ArrayList<>();
    private List<T> data;
}
