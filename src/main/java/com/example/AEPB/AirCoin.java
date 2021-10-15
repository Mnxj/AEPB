package com.example.AEPB;

import com.example.AEPB.excepition.AirCoinAmountBeyondLimitException;

public class AirCoin {
    private static final long AMOUNT_MAX = 1000000000L;
    private Long amount;

    public AirCoin(Long amount) {
        this.amount = amount;
    }

    public boolean compareAmountIsEqual(AirCoin otherAirCoin) {
        if (this.amount > AMOUNT_MAX || otherAirCoin.amount > AMOUNT_MAX) {
            throw new AirCoinAmountBeyondLimitException("AirCoin amount beyond limit");
        }
        return this.amount.equals(otherAirCoin.amount);
    }
}
