package com.lis.projects.WebService.exception.model;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private String data;
    private HttpStatus httpStatus;

    public ErrorResponse(String data, HttpStatus httpStatus) {
        this.data = data;
        this.httpStatus = httpStatus;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
