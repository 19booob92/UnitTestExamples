package UnitTestsExample.test.multiArguments;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static UnitTestsExample.utils.BigDecimalUtils.isNatualNumber;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class BigDecimalUtilsMultiParamsTest {

	@Test
	@Parameters(method = "validInputStringParameters")
	public void shouldValidInputString(String stringValue, boolean expectedResult) {

		boolean result = isNatualNumber(stringValue);

		assertThat(expectedResult).isEqualTo(result);
	}

	@Parameters
	private Object[] validInputStringParameters() {
		return new Object[][]{
				{"asd", false},
				{"1", true},
				{"11", true},
				{"1,1", false}
		};
	}
}
