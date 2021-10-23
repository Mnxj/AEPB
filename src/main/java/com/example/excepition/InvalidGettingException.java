package com.example.excepition;

public class InvalidGettingException extends RuntimeException {
    public InvalidGettingException(String msg) {
        super(msg);
    }
}
