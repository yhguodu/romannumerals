package proudsmart.RomanTest.lineparser;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import proudsmart.RomanTest.lineparser.AssignmentParser;
import proudsmart.RomanTest.lineparser.LineParser;
import proudsmart.RomanTest.romanrules.RomanRuleChain;
import proudsmart.RomanTest.utils.ProductInfo;
import proudsmart.RomanTest.utils.RomanError;

public class TestAssignmentParser {
	
	private LineParser parser;

	@Before
	public void setUp() {
		Map<String,String> symbolMap = new HashMap<String,String>();
		Map<String,ProductInfo> productMap= new HashMap<String,ProductInfo>();
		RomanRuleChain ruleChain = new RomanRuleChain();
		ruleChain.initRuleChain();
		
		parser = new AssignmentParser(symbolMap,productMap,ruleChain);
		
	}
	
	@Test
	public void testParer() {
		String testMsg1 = "tegjj is A";
		String testMsg2 = "tesgii is I"; 
		try {
			parser.parse("tegjj is A");
		}
		catch(Exception e) {
			assertEquals(e.getMessage(),RomanError.NemeralsError.getMessage()+":"+testMsg1);
		}
		
		assertNull(parser.parse(testMsg2));
	}
}
