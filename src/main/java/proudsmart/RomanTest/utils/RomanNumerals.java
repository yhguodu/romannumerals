package proudsmart.RomanTest.utils;


/**
 * Roman number control
 * Roman Number
 * I(1),V(5),X(10),L(50),C(100),D(500),M(1000);
 * @author Ze
 */


public class RomanNumerals {
	
	private RomanNumerals() {}
	
	/**
	 * convert Roman numerals To Decimal number
	 * step 1: get the value for every char int roman str,and put them in the array
	 * step 2: get the sign bit for every element in the array
	 * step 3: sum the value in the array
	 * @param romanStr
	 * @return
	 */
	public static int convertRomanNumbersToDecimal(String romanStr) {
		int[] decimalArray = new int[romanStr.length()];
		for(int i = 0; i< romanStr.length(); i++) {
			decimalArray[i] = getRomanNumberDecimalValue(romanStr.charAt(i));
		}
		
		int result = 0;
		for(int i = 0; i < decimalArray.length ; i++) {
			if(i == decimalArray.length -1)
				result += decimalArray[i];
			else {
				if(decimalArray[i] < decimalArray[i+1])
					result -= decimalArray[i];
				else
					result += decimalArray[i];
			}
		}
		return result;
	}
	
	private static int[]    NUMBERS = { 1000,  900,  500,  400,  100,   90,  
            50,   40,   10,    9,    5,    4,    1 };
	 private static String[] ROMANNUMERALS = { "M",  "CM",  "D",  "CD", "C",  "XC",
             "L",  "XL",  "X",  "IX", "V",  "IV", "I" };
	 
	 /**
	  * convert Decimal To Roman Numbers
	  * refer to: http://math.hws.edu/eck/cs124/javanotes3/c9/ex-9-3-answer.html
	  * @param decimalValue
	  * @return 
	  */
	public static String convertDecimalToRomanNumbers(int decimalValue) {
		//TODO
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<NUMBERS.length; i++) {
			while(decimalValue >= NUMBERS[i]) {
				sb.append(ROMANNUMERALS[i]);
				decimalValue -= NUMBERS[i];
			} 
		}
		return sb.toString();
	}
		
	public static int getRomanNumberDecimalValue(char romanNumber) {
		switch(romanNumber) {
			case 'I':
				return Numerals.I.getValue();
			case 'V':
				return Numerals.V.getValue();
			case 'X':
				return Numerals.X.getValue();
			case 'L':
				return Numerals.L.getValue();
			case 'C':
				return Numerals.C.getValue();
			case 'D':
				return Numerals.D.getValue();
			case 'M':
				return Numerals.M.getValue();
			default:
				return 0;
		}
	}

	public enum Numerals {
		I(1),V(5),X(10),L(50),C(100),D(500),M(1000);
		
		private int value;
		Numerals(int value) {
			this.value = value;
		}
	
		public int getValue() {
			return this.value;
		}
	
	}
}