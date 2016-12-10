package proudsmart.RomanTest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

import proudsmart.RomanTest.lineparser.LineType;
import proudsmart.RomanTest.romanrules.RomanRuleChain;
import proudsmart.RomanTest.utils.ProductInfo;

public class TestParserFactory {
	private ParserFactory parserFactory;
	
	private String[] testStr = {
			"glob is I",
			"prok is V",
			"pish is X",
			"tegj is L",
			"glob glob Silver is 34 Credits",
			"glob prok Gold is 57800 Credits",
			"pish pish Iron is 3910 Credits",
			"how much is pish tegj glob glob ?",
			"how many Credits is glob prok Silver ?",
			"how many Credits is glob prok Gold ?",
			"how many Credits is glob prok Iron ?",
			"how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"
	};
	
	@Before
	public void setUp() {
		Map<String,String> symbolMap = new HashMap<String,String>();
		Map<String,ProductInfo> productMap= new HashMap<String,ProductInfo>();
		RomanRuleChain ruleChain = new RomanRuleChain();
		ruleChain.initRuleChain();
		
		parserFactory = ParserFactory.newInstance();
		parserFactory.initParser(symbolMap, productMap, ruleChain);
	}
	
	@Test
	public void testParserInput() {
		String input1 = "tegjj is A";
		String input2 = "tegjj is I";
		assertTrue(Pattern.matches(LineType.Assignment.getPattern(), input2));
		assertTrue(Pattern.matches(LineType.Assignment.getPattern(), input1));
		
		String input3 = "glob glob Silver is 34 Credits";
		assertTrue(Pattern.matches(LineType.ProductInfo.getPattern(), input3));
		
		String input4="how much is pish tegj glob glob ?";
		assertTrue(Pattern.matches(LineType.HowMuch.getPattern(), input4));
		
		String input5="how many Credits is glob prok Silver ?";
		assertTrue(Pattern.matches(LineType.HowMany.getPattern(), input5));
		
	}
	
	@Test
	public void testAbnormalInput() {
		assertEquals(parserFactory.parseLine("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"),
				"I have no idea what you are talking about ");
	}
	
	@Test
	public void testContext() {
		assertNull(parserFactory.parseLine(testStr[0]));
		assertNull(parserFactory.parseLine(testStr[1]));
		assertNull(parserFactory.parseLine(testStr[2]));
		assertNull(parserFactory.parseLine(testStr[3]));
		assertNull(parserFactory.parseLine(testStr[4]));
		assertNull(parserFactory.parseLine(testStr[5]));
		assertNull(parserFactory.parseLine(testStr[6]));
		
		assertEquals("pish tegj glob glob  is 42",parserFactory.parseLine(testStr[7]));
		
		assertEquals("glob prok Silver is 68 Credits",parserFactory.parseLine(testStr[8]));
		
		assertEquals("glob prok Gold is 57800 Credits",parserFactory.parseLine(testStr[9]));
		
		assertEquals("glob prok Iron is 782 Credits",parserFactory.parseLine(testStr[10]));
		
	}
}
