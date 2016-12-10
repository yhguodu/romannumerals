package proudsmart.RomanTest.utils;

public class ProductInfo {
	private final String name;
	private final String peerRomanStr;
	private final int creditValue;
	
	public ProductInfo(String name, String peerRomanStr , int creditValue) {
		this.name = name;
		this.peerRomanStr = peerRomanStr;
		this.creditValue = creditValue;
	}

	public String getName() {
		return name;
	}

	public String getPeerRomanStr() {
		return peerRomanStr;
	}

	public int getCreditValue() {
		return creditValue;
	}
	
	
}
