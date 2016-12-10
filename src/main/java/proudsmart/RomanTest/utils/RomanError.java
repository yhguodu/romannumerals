package proudsmart.RomanTest.utils;

public enum RomanError {
	NemeralsError("Error:Roman expression illegal ,should only contain roman numbers {IVXLCMD}"),
	IXCMRepeatedError("Error:The numerals \"I\", \"X\", \"C\", and \"M\" can be repeated three times in succession, but no more"),
	DLVRepeatedError("Error:\"D\", \"L\", and \"V\" can never be repeated."),
	NumeralIError("Error:\"I\" can be subtracted from \"V\" and \"X\" only"),
	NumeralXError("Error:\"X\" can be subtracted from \"L\" and \"C\" only"),
	NumeralVError("Error:\"V\"can never be subtracted."),
	NumeralLError("Error:\"L\"can never be subtracted."),
	NumeralDError("Error:\"D\"can never be subtracted."),
	AssignError("Error:collision,same symbol  with different roman numeral"),
	ParserCreditError("Error:un-parseable credit value:"),
	ProductError("Error:unknown product name:");
	
	private String message;
	RomanError(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
