package proudsmart.RomanTest.lineparser;

public class NullParser extends LineParser {
	public NullParser() {
		super(null,null,null);
	}
	
	@Override
	public String parse(String line) {
		return null;
	}
}
