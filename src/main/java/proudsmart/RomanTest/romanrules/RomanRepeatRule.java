package proudsmart.RomanTest.romanrules;

import java.util.regex.Pattern;

import proudsmart.RomanTest.utils.RomanError;

public class RomanRepeatRule extends RomanRule {
	
	@Override
	public boolean verifyFor(String expression) {
		for(String rulePattern : ExpressionRules.IXCM_REPEAT_RULE) {
			if(Pattern.matches(rulePattern, expression)) {
				throw new IllegalArgumentException(RomanError.IXCMRepeatedError.getMessage());
			}
		}
		for(String rulePattern :ExpressionRules.DLV_REPEAT_RULE) {
			if(Pattern.matches(rulePattern, expression)) {
				throw new IllegalArgumentException(RomanError.DLVRepeatedError.getMessage());
			}
		}
		return true;
	}
}
