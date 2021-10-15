package com.example.AEPB;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HelloTest {

	@Test
	void should_no_null() {

		Hello hello = new Hello();
		assertNotNull(hello);
	}
}
class AirCoinTest {

	@Test
	void should_return_equal_when_compare_two_airCoins_given_a_airCoin_amount_is_0_and_another_airCoin_amount_is_0() {
		AirCoin airCoin = new AirCoin(0L);
		AirCoin otherAirCoin = new AirCoin(0L);
		Assertions.assertTrue(airCoin.compareAmountIsEqual(otherAirCoin));
	}
}
