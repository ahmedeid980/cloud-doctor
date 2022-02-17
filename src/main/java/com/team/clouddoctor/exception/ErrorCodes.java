package com.team.clouddoctor.exception;

import lombok.Getter;

public enum ErrorCodes {

	USER_ID_REQUIRED(1, "user id required"),
	USER_PARAM_REQUIRED(2, "user parameters [name , email required ");

	public String message;

    public int code;

	ErrorCodes(int value, String name) {
		this.message = name;
		this.code = value;
	}

	public static String getErrorMessage(int id) {
		for (ErrorCodes e : values()) {
			if (e.code == id)
				return e.getMessage();
		}
		return null;
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
