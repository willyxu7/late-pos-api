package com.lateras.latepos.exception.advice;

import com.lateras.latepos.model.response.DataResponse;
import com.lateras.latepos.model.response.NotValidDetailResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class BaseExceptionAdvice {

    public ResponseEntity<Object> response(String message, List<NotValidDetailResponse> notValidResponses, HttpStatus httpStatus){
        DataResponse<NotValidDetailResponse> notValidResponseDataResponse = new DataResponse<>();

        notValidResponseDataResponse.setMessage(message);
        notValidResponseDataResponse.getErrors().add(notValidResponses);

        return new ResponseEntity<Object>(notValidResponseDataResponse, httpStatus);
    }
}
