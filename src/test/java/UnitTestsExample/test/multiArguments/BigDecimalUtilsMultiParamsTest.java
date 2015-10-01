package UnitTestsExample.test.multiArguments;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import UnitTestsExample.utils.BigDecimalUtils;

@RunWith(Parameterized.class)
public class BigDecimalUtilsMultiParamsTest {

	private boolean expectedResult;
	private String param;
	
	public BigDecimalUtilsMultiParamsTest(String param, boolean expectedResult) {
		this.expectedResult = expectedResult;
		this.param = param;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"asd", false},
			{"1", true},
			{"11", true},
			{"1,1", false}
		});
	}
	
	@Test
	public void shouldValidInputString() {
		boolean result = BigDecimalUtils.isNatualNumber(param);
		
		assertEquals(expectedResult, result);
	}
	
}
