package proudsmart.RomanTest.lineparser;


import java.util.Map;

import proudsmart.RomanTest.romanrules.RomanRuleChain;
import proudsmart.RomanTest.utils.ProductInfo;
import proudsmart.RomanTest.utils.RomanError;


public class AssignmentParser extends LineParser {
	
	public AssignmentParser(Map<String, String> symbolMap,Map<String ,ProductInfo> productMap,RomanRuleChain ruleChain) {
		super(symbolMap,productMap,ruleChain);
	}
	
	@Override
	public String parse(String line) {
		String[] arg = line.trim().split(" ");
		try {
			this.checkRomanNumbersReferToRomanRule(arg[2], line);
		}
		catch(Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		
		if(symbolMap.containsKey(arg[0])) {
			if(symbolMap.get(arg[0]).equals(arg[2]) ==false) {
				throw new IllegalArgumentException(RomanError.AssignError.getMessage()+line);
			}
		}
		
		symbolMap.put(arg[0],arg[2]);	
		return null;
	}
	
}
