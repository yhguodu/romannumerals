package proudsmart.RomanTest.romanrules;

import java.util.regex.Pattern;

import proudsmart.RomanTest.utils.RomanError;

public class RomanXrule extends RomanRule {
		
	@Override
	public boolean verifyFor(String expression) {
		if(Pattern.matches(ExpressionRules.XRULE_PATTERN, expression)) {
			throw new IllegalArgumentException(RomanError.NumeralXError.getMessage());
		}
		
		return true;
	}
}
