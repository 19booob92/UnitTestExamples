package UnitTestsExample.test.multiArguments;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;

import static UnitTestsExample.utils.BigDecimalUtils.isNatualNumber;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

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
		return asList(new Object[][]{
				{"asd", false},
				{"1", true},
				{"11", true},
				{"1,1", false}
		});
	}

	@Test
	public void shouldValidInputString() {
		boolean result = isNatualNumber(param);

		assertThat(expectedResult).isEqualTo(result);
	}
	
}
