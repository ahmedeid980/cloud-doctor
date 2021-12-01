package com.team.clouddoctor.exception;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException{

    @Getter
    private final long code;

    public EntityNotFoundException(String message, long code) {
        super(message);
        this.code = code;
    }
}