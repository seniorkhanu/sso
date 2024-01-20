package com.company.exception;

import com.company.enums.ResponseStatusErrorMessage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import static com.company.enums.ResponseStatusErrorMessage.CLIENT_ERROR;
import static com.company.enums.ResponseStatusErrorMessage.UNKNOWN_ERROR;


@Getter
@Setter
public class ResponseException extends RuntimeException {
    private final HttpStatus status;
    private final String message;
    private final ResponseStatusErrorMessage error;

    public ResponseException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
        this.error = status.is4xxClientError() ? CLIENT_ERROR : UNKNOWN_ERROR;
    }

    public ResponseException(HttpStatus status, String message, ResponseStatusErrorMessage error) {
        this.status = status;
        this.message = message;
        this.error = error;
    }


    public static ResponseException errorException(String message) {
        return new ResponseException(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    public static ResponseException errorException(HttpStatus status, String message) {
        return new ResponseException(status, message);
    }

    public static ResponseException errorException(HttpStatus status, String message, ResponseStatusErrorMessage errorCode) {
        return new ResponseException(status, message, errorCode);
    }

}
