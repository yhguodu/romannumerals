package proudsmart.RomanTest.utils;

public enum ProductType {
	Silver("Silver"),
	Glod("Glod"),
	Iron("Iron");
	
	private String name;
	ProductType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
