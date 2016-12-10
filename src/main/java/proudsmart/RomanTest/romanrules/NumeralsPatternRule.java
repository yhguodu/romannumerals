package proudsmart.RomanTest.romanrules;

import java.util.regex.Pattern;

import proudsmart.RomanTest.utils.RomanError;

public class NumeralsPatternRule extends RomanRule {
	
	@Override
	public boolean verifyFor(String expression) {
		if(Pattern.matches(ExpressionRules.R0MAN_SYMBOL_PATTERN, expression) == false) {
			throw new IllegalArgumentException(RomanError.NemeralsError.getMessage());
		}
		return true;
	}
}

