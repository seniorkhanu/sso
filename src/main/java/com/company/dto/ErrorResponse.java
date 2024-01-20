package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private int errorCode;
    private String message;
    private String error;
    private String errorMessage;
    private String time;
    private String path;
}