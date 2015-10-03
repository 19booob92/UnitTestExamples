package UnitTestsExample.test.privates;

import UnitTestsExample.utils.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_EVEN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.support.membermodification.MemberMatcher.method;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StringUtils.class)
public class PrivateMethodsTest {

	@Test
	public void shouldStringWithoutCommas() throws Exception {
		// given
		StringUtils stringUtils = new StringUtils();
		StringUtils stringUtilsSpy = PowerMockito.spy(new StringUtils());

		BigDecimal expectingResult = new BigDecimal(123.12).setScale(2, HALF_EVEN);

		// when
		when(stringUtilsSpy, method(StringUtils.class, "changeCommasToDots", String.class))
				.withArguments("123,12").thenReturn("555.55");

		// then
		assertThat(stringUtils.getStringAsBigDecimal("123,12")).isEqualTo(expectingResult);
	}

}
