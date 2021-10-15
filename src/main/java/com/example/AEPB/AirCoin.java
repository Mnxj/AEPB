package com.example.AEPB;

import com.example.AEPB.excepition.AirCoinAmountBeyondLimitException;

public class AirCoin {
    private static final long AMOUNT_MAX = 1000000000L;
    private static final long AMOUNT_MIN = 0L;
    private Long amount;

    public AirCoin(Long amount) {
        this.amount = amount;
    }

    public boolean compareAmountIsEqual(AirCoin otherAirCoin) {
        if (this.amount < AMOUNT_MIN || otherAirCoin.amount < AMOUNT_MIN || this.amount > AMOUNT_MAX || otherAirCoin.amount > AMOUNT_MAX) {
            throw new AirCoinAmountBeyondLimitException("AirCoin amount beyond limit");
        }
        return this.amount.equals(otherAirCoin.amount);
    }
}
