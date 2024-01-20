package com.company.controller;

import com.company.enums.ResponseStatusErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.company.exception.ResponseException.errorException;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @GetMapping
    public ResponseEntity<?> getUser() {

        throw errorException(HttpStatus.NOT_FOUND, "User not found!", ResponseStatusErrorMessage.USER_NOT_FOUND);
    }
}
