package proudsmart.RomanTest.romanrules;

import java.util.regex.Pattern;

import proudsmart.RomanTest.utils.RomanError;

public class RomanIrule extends RomanRule {
	
	@Override
	public boolean verifyFor(String expression) {
		if(Pattern.matches(ExpressionRules.IRULE_PATTERN, expression)) {
			throw new IllegalArgumentException(RomanError.NumeralIError.getMessage());
		}
		
		return true;
	}
}
