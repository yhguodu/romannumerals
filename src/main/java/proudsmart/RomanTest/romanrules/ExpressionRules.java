package proudsmart.RomanTest.romanrules;

/**
 * expresssion rules
 * (1) expression should only contain the roman symbols
 * (2) The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more
 * (3) "I" can be subtracted from "V" and "X" only.
 * (4) "X" can be subtracted from "L" and "C" only
 * (5) "C" can be subtracted from "D" and "M" only. "V", "L"
 * (6) "V", "L","D" can never be subtracted
 * @author Ze
 *
 */
public class ExpressionRules {
	
	//roman numerals 
	public static final String R0MAN_SYMBOL_PATTERN = "[IVXLCMD]+";
	
	//The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more
	public static final String I_REPEAT_RULE = "\\S*(I){4,}\\S*";
	public static final String X_REPEAT_RULE = "\\S*(X){4,}\\S*";
	public static final String C_REPEAT_RULE = "\\S*(C){4,}\\S*";
	public static final String M_REPEAT_RULE = "\\S*(M){4,}\\S*";
	public static final String[] IXCM_REPEAT_RULE = {I_REPEAT_RULE,X_REPEAT_RULE,C_REPEAT_RULE,M_REPEAT_RULE};
	
	//\"D\", \"L\", and \"V\" can never be repeated
	public static final String D_REPEAT_RULE = "\\S*(D){2,}\\S*";
	public static final String L_REPEAT_RULE = "\\S*(L){2,}\\S*";
	public static final String V_REPEAT_RULE = "\\S*(V){2,}\\S*";
	public static final String[] DLV_REPEAT_RULE = {D_REPEAT_RULE ,L_REPEAT_RULE ,V_REPEAT_RULE };
	
	//"I" can be subtracted from "V" and "X" only.
	public static final String IRULE_PATTERN = "I[LCDM]";
	
	//"X" can be subtracted from "L" and "C" only
	public static final String XRULE_PATTERN = "X[DM]";
	
	//"V" can never be subtracted
	public static final String VRULE_PATTERN = "V[XLCDM]";
	
	// "L" can never be subtracted
	public static final String LRULE_PATTERN = "L[CDM]";
	
	//"D" can never be subtracted
	public static final String DRULE_PATTERN = "D[M]";
	
}
