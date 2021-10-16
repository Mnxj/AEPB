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
	void should_throw_exception_given_more_than_one_billion() {
		try {
			new AirCoin(1000000001L);
		} catch (AirCoinAmountBeyondLimitException e) {
			assertEquals("AirCoin amount beyond limit",e.getMessage());
		}
	}
	@Test
	void should_throw_exception_given_less_than_0() {
		try {
			new AirCoin(-1L);
		} catch (AirCoinAmountBeyondLimitException e) {
			assertEquals("AirCoin amount beyond limit",e.getMessage());
		}
	}

	@Test
	void should_throw_exception_given_null() {
		try {
			new AirCoin(null);
		} catch (AirCoinAmountBeyondLimitException e) {
			assertEquals("AirCoin amount can not be null",e.getMessage());
		}
	}
}
