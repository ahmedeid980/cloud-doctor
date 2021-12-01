package com.team.clouddoctor.enums;


public enum MessageEnum {
    LOGIN_ERROR(100, "email required");

    public String message;

    public int code;

    private MessageEnum(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
