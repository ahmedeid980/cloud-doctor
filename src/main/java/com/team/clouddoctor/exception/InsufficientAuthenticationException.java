package com.team.clouddoctor.exception;

import lombok.Getter;

public class InsufficientAuthenticationException extends RuntimeException{

    @Getter
    private final long code;

    public InsufficientAuthenticationException(String message, long code) {
        super(message);
        this.code = code;
    }
}