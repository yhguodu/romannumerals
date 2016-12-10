package proudsmart.RomanTest.lineparser;

import java.util.Map;

import proudsmart.RomanTest.romanrules.RomanRuleChain;
import proudsmart.RomanTest.utils.ProductInfo;

public class LineParser implements Parseable {
	protected final Map<String,String> symbolMap;
	protected final Map<String,ProductInfo> productMap;
	protected final RomanRuleChain ruleChain;
	
	public LineParser(Map<String,String> symbolMap, Map<String,ProductInfo> productMap,RomanRuleChain ruleChain) {
		this.symbolMap = symbolMap;
		this.productMap = productMap;
		this.ruleChain = ruleChain;
	}
	
	public String parse(String line) {
		throw new UnsupportedOperationException();
	}
	
	public boolean checkSymbolsAvailable(String[] symbols) {
		for(String symbol: symbols) {
			if(symbolMap.containsKey(symbol) ==false) {
				throw new IllegalArgumentException("unknown symbol with credit:"+symbol);
			}
		} 
		return true;
	}
	
	public boolean checkRomanNumbersReferToRomanRule(String expression,String line) {
		try {
			ruleChain.verifyFor(expression);
		}
		catch(Exception e) {
			throw new IllegalArgumentException(e.getMessage()+":"+line);
		}
		
		return true;
	}
	
	public String symbolArrayToRomanNumbers(String[] symbols) {
		StringBuilder sb = new StringBuilder();
		for(String symbol : symbols) {
			sb.append(symbolMap.get(symbol));
		}
		
		return sb.toString();
	}

	public Map<String, String> getSymbolMap() {
		return symbolMap;
	}

	public Map<String, ProductInfo> getProductMap() {
		return productMap;
	}

	public void putSymbol(String Symbol ,String romanNumber) {
		symbolMap.put(Symbol, romanNumber);
	}
	
	public RomanRuleChain getRuleChain() {
		return ruleChain;
	}
	
	public static LineParser newParser(LineType type,Map<String,String> symbolMap, Map<String,ProductInfo> productMap,RomanRuleChain ruleChain) {
		switch(type) {
			case Assignment:
				return new AssignmentParser(symbolMap,null,ruleChain);
			case ProductInfo:
				return new ProductInfoParser(symbolMap,productMap,ruleChain);
			case HowMuch:
				return new HowMuchParser(symbolMap,productMap,ruleChain);
			case HowMany:
				return new HowManyParser(symbolMap,productMap,ruleChain);
			default:
				return new NullParser();
		}
	}
}
