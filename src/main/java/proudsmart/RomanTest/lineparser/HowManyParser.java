package proudsmart.RomanTest.lineparser;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import proudsmart.RomanTest.romanrules.RomanRuleChain;
import proudsmart.RomanTest.utils.ProductInfo;
import proudsmart.RomanTest.utils.RomanError;
import proudsmart.RomanTest.utils.RomanNumerals;


public class HowManyParser extends LineParser {
	
	public HowManyParser(Map<String,String> symbolMap, Map<String,ProductInfo> productMap,RomanRuleChain ruleChain) {
		super(symbolMap,productMap,ruleChain);
	}
	
	@Override
	public String parse(String line) {
		Pattern p = Pattern.compile(LineType.HowMany.getPattern());
		Matcher m = p.matcher(line);
		m.matches();
		
		String credit = m.group(1).trim();
		
		String[] symbols = m.group(2).trim().split(" ");
		
		String product = m.group(3).trim();
		
		this.checkSymbolsAvailable(symbols);
		
		String expression = this.symbolArrayToRomanNumbers(symbols);
		
		this.checkRomanNumbersReferToRomanRule(expression, line);
		
		ProductInfo productInfo = productMap.get(product);
		if(productInfo == null) {
			throw new IllegalArgumentException(RomanError.ProductError.getMessage()+ product	);
		}
		
		int expressionDecimal = RomanNumerals.convertRomanNumbersToDecimal(expression);
		int creditValue = RomanNumerals.convertRomanNumbersToDecimal(productInfo.getPeerRomanStr());
		
		int result = (int)((expressionDecimal * 1.0)/creditValue * productInfo.getCreditValue());
		return m.group(2)+product+ " is "+ String.valueOf(result) + " "+ m.group(1);
	}
	
}
