package UnitTestsExample.utils;

import java.math.BigDecimal;

public class InvoiceGenerator {

	public String generateAndSaveInvoice(String name, String user, BigDecimal value) {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Dane do faktury");
		stringBuilder.append(name);
		stringBuilder.append(user);
		stringBuilder.append("Wartość faktury");
		stringBuilder.append(value);
		
		return stringBuilder.toString();
	}
	
}
