package com.example.AEPB;

import com.example.AEPB.excepition.AirCoinAmountBeyondLimitException;

public class AirCoin {
    private static final long AMOUNT_MAX = 1000000000L;
    private static final long AMOUNT_MIN = 0L;
    private Long amount;

    public AirCoin(Long amount) {
        if (amount == null) {
            throw new AirCoinAmountBeyondLimitException("AirCoin amount can not be null");
        }
        if ( amount < AMOUNT_MIN  || amount > AMOUNT_MAX) {
            throw new AirCoinAmountBeyondLimitException("AirCoin amount beyond limit");
        }
        this.amount = amount;
    }

    public boolean compareAmountIsEqual(AirCoin otherAirCoin) {
        return this.amount.equals(otherAirCoin.amount);
    }
}
