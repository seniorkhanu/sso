package com.company.enums;

import lombok.Getter;

@Getter
public enum ResponseStatusErrorMessage {
    CLIENT_ERROR(400, "Client Error"),
    UNKNOWN_ERROR(500, "Unknown Error"),
    USER_NOT_FOUND(404101, "User Not Found Error"),
    NULL_POINTER_EXCEPTION(500404, "Null Pointer Error");
    private final int code;
    private final String value;

    ResponseStatusErrorMessage(int code, String value) {
        this.code = code;
        this.value = value;
    }

}
