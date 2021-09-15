package com.lateras.latepos.exception.advice;

import com.lateras.latepos.model.response.NotFoundResponse;
import com.lateras.latepos.model.response.NotValidDetailResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ApiExceptionAdvice extends BaseExceptionAdvice{

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Object methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<NotValidDetailResponse> notValidResponses = methodArgumentNotValidException
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(this::mapObjectErrorToNotValidResponse)
                .collect(Collectors.toList());

        return response("Unprocessable Entity", notValidResponses, HttpStatus.BAD_REQUEST);
    }

    public NotValidDetailResponse mapObjectErrorToNotValidResponse(ObjectError objectError) {
        return new NotValidDetailResponse(
            objectError instanceof FieldError ? ((FieldError) objectError).getField() : objectError.getObjectName(),
            objectError.getDefaultMessage()
        );
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public Object notFoundException(IllegalArgumentException illegalArgumentException) {
        NotFoundResponse notFoundResponse = new NotFoundResponse();
        notFoundResponse.setMessage(illegalArgumentException.getMessage());

        return new ResponseEntity<>(notFoundResponse, HttpStatus.NOT_FOUND);
    }
}
