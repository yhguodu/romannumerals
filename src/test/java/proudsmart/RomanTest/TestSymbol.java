package proudsmart.RomanTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import proudsmart.RomanTest.utils.RomanNumerals.Numerals;



public class TestSymbol {
	
	@Test
	public void testSymbol() {
		assertEquals(1,Numerals.I.getValue());
		assertEquals(5,Numerals.V.getValue());
		assertEquals(10,Numerals.X.getValue());
		assertEquals(50,Numerals.L.getValue());
		assertEquals(100,Numerals.C.getValue());
		assertEquals(500,Numerals.D.getValue());
		assertEquals(1000,Numerals.M.getValue());
	}
}
