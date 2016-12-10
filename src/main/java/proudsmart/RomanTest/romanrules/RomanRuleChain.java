package proudsmart.RomanTest.romanrules;

import java.util.LinkedList;
import java.util.List;

import proudsmart.RomanTest.romanrules.*;

public class RomanRuleChain {
	private List<RomanRule> ruleChain;
	
	public RomanRuleChain() {
		ruleChain = new LinkedList<RomanRule>();
	}
	
	public void initRuleChain() {			
		ruleChain.add(new NumeralsPatternRule());
		ruleChain.add(new RomanRepeatRule());
		ruleChain.add(new RomanIrule());
		ruleChain.add(new RomanXrule());
		ruleChain.add(new RomanCrule());
		ruleChain.add(new RomanVLDrule());
	} 
	
	public boolean  verifyFor(String expression) {
		try{
			for(RomanRule rule : ruleChain) {
				rule.verifyFor(expression);
			}
		}
		catch(Exception e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return true;
	}
}
