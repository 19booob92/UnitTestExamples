package UnitTestsExample.utils;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
public class BigDecimalUtils {

	private InvoiceGenerator invoiceGenerator;
	
	public BigDecimalUtils() {
		invoiceGenerator = new InvoiceGenerator();
	}
	
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
	
	@PreAuthorize("hasRole('USER')")
	public BigDecimal countGrossaryValue(BigDecimal value) {
		return value.multiply(new BigDecimal(0.23));
	}
	
	public BigDecimal countCommisions() {
		BigDecimal sum = countGrossaryValue(BigDecimal.TEN).add(new BigDecimal(15));
		
		invoiceGenerator.generateAndSaveInvoice("Invoice 2015/09", "John Smith", sum);
		
		return sum;
	}
	
	public InvoiceGenerator getInvoiceGenerator() {
		return invoiceGenerator;
	}

	public void setInvoiceGenerator(InvoiceGenerator invoiceGenerator) {
		this.invoiceGenerator = invoiceGenerator;
	}

}
