package proudsmart.RomanTest.romanrules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import proudsmart.RomanTest.utils.RomanError;

public class TestRuleChain {
	private RomanRuleChain ruleChain;
	
	@Before
	public void setUp() {
		ruleChain = new RomanRuleChain();
		ruleChain.initRuleChain();
		
	}
	
	@Test
	public void test() {
		try{
			ruleChain.verifyFor("ABCDEFG");
		}
		catch(Exception e) {
			assertEquals(e.getMessage(),RomanError.NemeralsError.getMessage());
		}
		
		try{
			ruleChain.verifyFor("IIII");
		}
		catch(Exception e) {
			assertEquals(e.getMessage(),RomanError.IXCMRepeatedError.getMessage());
		}
		
		assertTrue(ruleChain.verifyFor("VII"));
		
		try {
			ruleChain.verifyFor("IC");
		}
		catch(Exception e) {
			assertEquals(e.getMessage(),RomanError.NumeralIError.getMessage());
		}
	}
}
