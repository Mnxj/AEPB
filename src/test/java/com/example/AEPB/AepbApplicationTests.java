package com.example.AEPB;

import com.example.AEPB.excepition.AirCoinAmountBeyondLimitException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
		assertTrue(airCoin.compareAmountIsEqual(otherAirCoin));
	}
	@Test
	void should_return_equal_when_compare_two_airCoins_given_a_airCoin_amount_is_one_billion_and_another_airCoin_amount_is_one_billion_plus_one() {
		AirCoin airCoin = new AirCoin(1000000000L);
		AirCoin otherAirCoin = new AirCoin(1000000001L);
		assertThrows(AirCoinAmountBeyondLimitException.class, () -> airCoin.compareAmountIsEqual(otherAirCoin));
	}
	@Test
	void should_throw_exception_when_compare_two_airCoins_given_a_airCoin_amount_is_negative_1_and_another_airCoin_amount_is_negative_1() {
		AirCoin airCoin = new AirCoin(-1L);
		AirCoin otherAirCoin = new AirCoin(1L);
		assertThrows(AirCoinAmountBeyondLimitException.class, () -> airCoin.compareAmountIsEqual(otherAirCoin));
	}
}
