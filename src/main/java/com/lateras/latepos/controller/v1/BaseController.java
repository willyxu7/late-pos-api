package com.lateras.latepos.controller.v1;

import com.lateras.latepos.model.response.CategoryResponse;
import com.lateras.latepos.model.response.DataResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class BaseController {

    public <T> ResponseEntity<List<T>> response(String message, List<T> response, HttpStatus httpStatus) {
        DataResponse<T> dataResponse = new DataResponse<>();

        dataResponse.setMessage(message);
        dataResponse.setData(response);

        return new ResponseEntity(dataResponse, httpStatus);
    }

    public <T> ResponseEntity<T> response(String message, T response, HttpStatus httpStatus){
        DataResponse<T> dataResponse = new DataResponse<>();

        List<T> parsedResponses = parseResponseToListResponse(response);

        dataResponse.setMessage(message);
        dataResponse.setData(parsedResponses);

        return new ResponseEntity(dataResponse, httpStatus);
    }

    private <T> List<T> parseResponseToListResponse(T response) {
        List<T> responses = new ArrayList<>();
        responses.add(response);

        return responses;
    }
}
