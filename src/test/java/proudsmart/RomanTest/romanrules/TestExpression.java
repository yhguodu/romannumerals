package proudsmart.RomanTest.romanrules;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import proudsmart.RomanTest.romanrules.NumeralsPatternRule;
import proudsmart.RomanTest.romanrules.RomanCrule;
import proudsmart.RomanTest.romanrules.RomanIrule;
import proudsmart.RomanTest.romanrules.RomanRepeatRule;
import proudsmart.RomanTest.romanrules.RomanRule;
import proudsmart.RomanTest.romanrules.RomanVLDrule;
import proudsmart.RomanTest.romanrules.RomanXrule;
import proudsmart.RomanTest.utils.RomanError;


public class TestExpression {
	
	private List<RomanRule> ruleChain;
	private RomanRule rule;
	private RomanRule repeatRule;
	
	private RomanRule iRule;
	private RomanRule xRule;
	private RomanRule cRule;
	private RomanRule vldRule;
	
	@Before 
	public void setUp() {
		ruleChain = new ArrayList<RomanRule>();
		rule = new NumeralsPatternRule();
		repeatRule = new RomanRepeatRule();
		
		iRule = new RomanIrule() ;
		xRule = new RomanXrule();
		cRule = new RomanCrule();
		vldRule = new RomanVLDrule();
		
		
		ruleChain.add(rule);
		ruleChain.add(repeatRule);
		ruleChain.add(iRule);
		ruleChain.add(xRule);
		ruleChain.add(cRule);
		ruleChain.add(vldRule);
			
	}
	
	@Test
	public void testNumeralPatternRule() {
		try{
			rule.verifyFor("ABCDEFG");
		}
		catch(Exception e) {
			assertEquals(e.getMessage(),RomanError.NemeralsError.getMessage());
		}
				
		assertTrue(rule.verifyFor("IICCMM"));
		
		assertTrue(rule.verifyFor("I"));
		
		try{
			rule.verifyFor("IVXLCMDAAIVXLCMD");
		}
		catch(Exception e) {
			assertEquals(e.getMessage(),RomanError.NemeralsError.getMessage());
		}
		
		assertTrue(rule.verifyFor("IVXLCMD"));
	}
	
	@Test
	public void testRepeatRule() {
		assertTrue(repeatRule.verifyFor("IVXLCMD"));
		
		assertTrue(repeatRule.verifyFor("III"));
		
		assertTrue(repeatRule.verifyFor("IIIXXXCCCMMM"));
		
		try{
			repeatRule.verifyFor("IIIIVVD");
		}
		catch(Exception e) {
			assertEquals(e.getMessage(),RomanError.IXCMRepeatedError.getMessage());
		}
	
		try{
			repeatRule.verifyFor("IIIXXXCCCCMMM");
		}
		catch(Exception e) {
			assertEquals(e.getMessage(),RomanError.IXCMRepeatedError.getMessage());
		}
		
		try{
			repeatRule.verifyFor("IIIXXXDDCCCMMM");
		}
		catch(Exception e) {
			assertEquals(e.getMessage(),RomanError.DLVRepeatedError.getMessage());
		}
	}
	
	@Test
	public void testIrule() {
		assertTrue(iRule.verifyFor("VII"));
		
		try {
			iRule.verifyFor("IC");
		}
		catch(Exception e) {
			assertEquals(e.getMessage(),RomanError.NumeralIError.getMessage());
		}
	}
}
