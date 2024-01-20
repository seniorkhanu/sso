package com.company.exception;

import com.company.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.company.enums.ResponseStatusErrorMessage.NULL_POINTER_EXCEPTION;
import static com.company.enums.ResponseStatusErrorMessage.UNKNOWN_ERROR;
import static com.company.exception.ResponseException.errorException;
import static com.company.utils.DataTimeUtils.customDateNow;

@RestControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(ResponseException.class)
    public ResponseEntity<?> handleResponseException(ResponseException e,
                                                     HttpServletRequest request) {
        final String requestURI = request.getRequestURI();
        String date = customDateNow();
        ErrorResponse response = ErrorResponse.builder()
                .message(e.getMessage())
                .error(e.getStatus().getReasonPhrase())
                .errorCode(e.getError().getCode())
                .errorMessage(e.getError().getValue())
                .time(date)
                .path(requestURI)
                .build();
        return new ResponseEntity<>(response, e.getStatus());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointer(NullPointerException e,
                                               HttpServletRequest request) {
        return handleResponseException(
                errorException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), NULL_POINTER_EXCEPTION),
                request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e,
                                             HttpServletRequest request) {
        return handleResponseException(
                errorException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), UNKNOWN_ERROR),
                request);
    }
}
