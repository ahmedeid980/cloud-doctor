package com.team.clouddoctor.dto;

import lombok.Data;

@Data
public class CommonResponseDto {

    private long code;
    private boolean success;
    private String message;
    private Object data;
}
