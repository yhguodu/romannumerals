package proudsmart.RomanTest.lineparser;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import proudsmart.RomanTest.romanrules.RomanRuleChain;
import proudsmart.RomanTest.utils.ProductInfo;
import proudsmart.RomanTest.utils.RomanNumerals;

public class HowMuchParser extends LineParser {

	
	public HowMuchParser(Map<String,String> symbolMap, Map<String,ProductInfo> productMap,RomanRuleChain ruleChain) {
		super(symbolMap,productMap,ruleChain);
	}
	
	@Override
	public String parse(String line) {
		Pattern p = Pattern.compile(LineType.HowMuch.getPattern());
		Matcher m = p.matcher(line);
		m.matches();
		
		String[] symbols = m.group(1).split("\\s");
		
		this.checkSymbolsAvailable(symbols);
		
		String expression = this.symbolArrayToRomanNumbers(symbols);
		
		this.checkRomanNumbersReferToRomanRule(expression, line);
		
		int value = RomanNumerals.convertRomanNumbersToDecimal(expression);
		
		return m.group(1)+" is "+ String.valueOf(value);
	}	
}
