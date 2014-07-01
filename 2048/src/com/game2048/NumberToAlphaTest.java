package com.game2048;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberToAlphaTest {

	@Test
	public void testIfRightAlphasAreReturned() {
		NumberToAlpha numberToAlpha = new NumberToAlpha();
		assertEquals('A', numberToAlpha.getMapNumberToAlpha(2));
		assertEquals('B', numberToAlpha.getMapNumberToAlpha(4));
		assertEquals('C', numberToAlpha.getMapNumberToAlpha(8));
		assertEquals('D', numberToAlpha.getMapNumberToAlpha(16));
		assertEquals('E', numberToAlpha.getMapNumberToAlpha(32));
		assertEquals('F', numberToAlpha.getMapNumberToAlpha(64));
		assertEquals('G', numberToAlpha.getMapNumberToAlpha(128));
		assertEquals('H', numberToAlpha.getMapNumberToAlpha(256));
		assertEquals('I', numberToAlpha.getMapNumberToAlpha(512));
		assertEquals('J', numberToAlpha.getMapNumberToAlpha(1024));
		assertEquals('K', numberToAlpha.getMapNumberToAlpha(2048));
	}
}
