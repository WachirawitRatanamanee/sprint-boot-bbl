package com.wachirawit.interview.model;

public class GenericErrorResponse {
    private String message;

    public GenericErrorResponse() {}

    public GenericErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
