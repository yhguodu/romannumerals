package proudsmart.RomanTest;

import static org.junit.Assert.*;

import org.junit.Test;

import proudsmart.RomanTest.utils.RomanNumerals;

public class TestNumerals {
	
	@Test
	public void test() {
		assertEquals("MCMXLIV",RomanNumerals.convertDecimalToRomanNumbers(1944));
		assertEquals("MCMIII",RomanNumerals.convertDecimalToRomanNumbers(1903));
	}
}
