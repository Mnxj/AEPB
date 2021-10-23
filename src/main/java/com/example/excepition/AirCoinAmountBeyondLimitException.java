package com.example.excepition;

public class AirCoinAmountBeyondLimitException extends  RuntimeException{
    public AirCoinAmountBeyondLimitException(String message) {
        super(message);
    }
}
