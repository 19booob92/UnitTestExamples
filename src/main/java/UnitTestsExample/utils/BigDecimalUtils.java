package UnitTestsExample.utils;

import java.util.regex.Pattern;

public class BigDecimalUtils {

	public static boolean isNatualNumber(String toTest) {
		
		Pattern pattern = Pattern.compile("[0-9]+[.]*");
		
		boolean isValid = pattern.matcher(toTest).matches();
		
		if (toTest != null &&
				!toTest.isEmpty() &&
				isValid) {
			return true;
		} else {
			return false;
		}
	}

}
