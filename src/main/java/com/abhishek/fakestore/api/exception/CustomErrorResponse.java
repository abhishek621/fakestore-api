package com.abhishek.fakestore.api.exception;

import lombok.Data;

@Data
public class CustomErrorResponse {
    private String code;
    private String message;
    private String developerMessage;
    private String moreInfo;

}