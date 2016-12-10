package proudsmart.RomanTest.lineparser;

public enum LineType {
	Assignment("^([a-z]+) is (.+)$"),
	ProductInfo("((?:[a-z]+ )+)([A-Z]\\w+) is (\\d+) ([A-Z]\\w+)$"),
	HowMany("^how many ([a-zA-Z]\\w+) is ((?:\\w+ )+)([A-Z]\\w+) \\?$"),
	HowMuch("^how much is ((?:\\w+[^0-9] )+)\\?$");
	
	private String pattern;
	LineType(String pattern) {
		this.pattern = pattern;
	}
	
	public String getPattern() {
		return this.pattern;
	}
}
