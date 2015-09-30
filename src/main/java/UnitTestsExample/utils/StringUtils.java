package UnitTestsExample.utils;

import java.math.BigDecimal;

public class StringUtils {

	public static String returnMultipliedString(String givenString, int multiplier) {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (int i = 0; i < multiplier; i++) {
			stringBuilder.append(givenString);
		}
		
		return stringBuilder.toString();
	}
	
	public BigDecimal getStringAsBigDecimal(String givenValue) {
		return new BigDecimal(changeCommasToDots(givenValue));
	}
	
	private String changeCommasToDots(String stringToEdit) {
		return stringToEdit.replace(',', '.');
	}
}
