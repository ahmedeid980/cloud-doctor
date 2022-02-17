package com.team.clouddoctor.exception;

import lombok.Getter;

public class MissingOrBadParameterException extends RuntimeException {

    @Getter
    private final long code;

    public MissingOrBadParameterException(String message, long code) {
        super(message);
        this.code = code;
    }

}
