package com.example.AEPB;

public class AirCoin {
    private Long amount;

    public AirCoin(Long amount) {
        this.amount = amount;
    }

    public boolean compareAmountIsEqual(AirCoin otherAirCoin) {

        return this.amount.equals(otherAirCoin.amount);
    }
}
