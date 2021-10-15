package com.example.AEPB.excepition;

public class AirCoinAmountBeyondLimitException extends  RuntimeException{
    public AirCoinAmountBeyondLimitException(String message) {
        super(message);
    }
}
