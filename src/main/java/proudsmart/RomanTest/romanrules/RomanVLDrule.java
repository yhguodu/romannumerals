package proudsmart.RomanTest.romanrules;

import java.util.regex.Pattern;

import proudsmart.RomanTest.utils.RomanError;

public class RomanVLDrule extends RomanRule {
	
	@Override
	public boolean verifyFor(String expression) {
		if(Pattern.matches(ExpressionRules.VRULE_PATTERN, expression)) {
			throw new IllegalArgumentException(RomanError.NumeralVError.getMessage());
		}
		
		if(Pattern.matches(ExpressionRules.LRULE_PATTERN, expression)) {
			throw new IllegalArgumentException(RomanError.NumeralLError.getMessage());
		}
		
		if(Pattern.matches(ExpressionRules.DRULE_PATTERN, expression)) {
			throw new IllegalArgumentException(RomanError.NumeralDError.getMessage());
		}
		
		return true;
	}
}
