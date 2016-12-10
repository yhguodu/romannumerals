package proudsmart.RomanTest;

import java.util.EnumMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import proudsmart.RomanTest.lineparser.*;
import proudsmart.RomanTest.romanrules.RomanRuleChain;
import proudsmart.RomanTest.utils.ProductInfo;

public class ParserFactory {
	private static final Logger logger = Logger.getLogger(ParserFactory.class.getName());
			
	private EnumMap<LineType,Parseable> parserMap;
	
	private ParserFactory() {		
	}
	
	public void initParser(Map<String,String> symbolMap,Map<String,ProductInfo> productMap,RomanRuleChain ruleChain) {
		parserMap = new EnumMap<LineType,Parseable>(LineType.class);
		
		for(LineType type: LineType.values()) {
			parserMap.put(type, LineParser.newParser(type, symbolMap, productMap, ruleChain));
		}
		
		return;
	}
	
	public String parseLine(String line) {
		try {
			for(LineType type :LineType.values()) {
				if(Pattern.matches(type.getPattern(),line) == true) {
					return parserMap.get(type).parse(line);
				}
			}
		}
		catch(Exception e) {
			return e.getMessage();
		}
		return "I have no idea what you are talking about ";
	}
	
	public static ParserFactory newInstance() {
		return new ParserFactory();
	}
}
