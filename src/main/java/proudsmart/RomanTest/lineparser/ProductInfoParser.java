package proudsmart.RomanTest.lineparser;

import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import proudsmart.RomanTest.romanrules.RomanRuleChain;
import proudsmart.RomanTest.utils.ProductInfo;
import proudsmart.RomanTest.utils.RomanError;


public class ProductInfoParser extends LineParser {
	private static final Logger logger = Logger.getLogger(ProductInfoParser.class.getName());
	
	public ProductInfoParser(Map<String,String> symbolMap,Map<String, ProductInfo> productMap,RomanRuleChain ruleChain) {
		super(symbolMap,productMap,ruleChain);
	}
	
	@Override
	public String parse(String line) {
		Pattern p = Pattern.compile(LineType.ProductInfo.getPattern());
		Matcher m = p.matcher(line);
		m.matches();

		String[] symbols = m.group(1).split("\\s");
		checkSymbolsAvailable(symbols);
		
		String productName = m.group(2);
		 
		int creditValue = 0;
		try{
			creditValue = Integer.parseInt(m.group(3));
		}
		catch(Exception e) {
			throw new IllegalArgumentException(RomanError.ParserCreditError.getMessage()+line);
		}
		
		String expression = this.symbolArrayToRomanNumbers(symbols);
		
		this.checkRomanNumbersReferToRomanRule(expression, line);
		
		productMap.put(productName,new ProductInfo(productName, expression, creditValue));
		
		return null;
	}
	
}
