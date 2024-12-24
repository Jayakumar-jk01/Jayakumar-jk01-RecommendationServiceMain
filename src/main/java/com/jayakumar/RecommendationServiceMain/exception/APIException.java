package com.jayakumar.RecommendationServiceMain.exception;

public class APIException extends RuntimeException{
    String message;

    public APIException() {
    }

    public APIException(String message) {
        super(message);
        this.message = message;
    }
}
