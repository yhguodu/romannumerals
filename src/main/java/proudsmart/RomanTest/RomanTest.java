package proudsmart.RomanTest;


import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import proudsmart.RomanTest.romanrules.RomanRuleChain;
import proudsmart.RomanTest.utils.ProductInfo;

public class RomanTest {
	private static final Logger logger = Logger.getLogger(RomanTest.class.getName());
	
	private final Map<String, String> symbolMap;
	private final Map<String,ProductInfo> productMap;
	private RomanRuleChain ruleChain;
	
	private final ParserFactory parserFactory;
	
	public RomanTest() {
		symbolMap = new HashMap<String,String>();
		productMap= new HashMap<String,ProductInfo>();
		ruleChain = new RomanRuleChain();
		parserFactory  = ParserFactory.newInstance();
	}

	public void init() {
		ruleChain.initRuleChain();
		parserFactory.initParser(symbolMap, productMap, ruleChain);
	}
	
	public Map<String, String> getSymbolMap() {
		return symbolMap;
	}

	public Map<String, ProductInfo> getProductMap() {
		return productMap;
	}

	public ParserFactory getParserFactory() {
		return parserFactory;
	}
	
	public String parse(String line) {
		return parserFactory.parseLine(line);
	}
}
