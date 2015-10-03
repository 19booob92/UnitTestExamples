package UnitTestsExample.test.statics;

import UnitTestsExample.utils.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static java.lang.Integer.parseInt;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StringUtils.class)
public class StaticsMethodsMockTest {

	@Before
	public void init() {
		mockStatic(StringUtils.class);
	}
	
	@Test
	public void shouldReturnMultipliedGivenString() {
		// given
		String randomString = random(10);
		String threeConcatenatedRandomStrings = randomString + randomString + randomString;
		int repeat = 3;

		given(StringUtils.returnMultipliedString(randomString, repeat)).willReturn(threeConcatenatedRandomStrings);

		// when
		String result = StringUtils.returnMultipliedString(randomString, repeat);

		// then
		assertThat(result).isEqualTo(threeConcatenatedRandomStrings);
	}

	@Test
	public void shouldReturnMultipliedAnyString() {
		// given
		String randomString = random(10);

		given(StringUtils.returnMultipliedString(anyString(), anyInt()))
				.willReturn(randomString);

		// when
		String result = StringUtils.returnMultipliedString(random(10), parseInt(randomNumeric(5)));

		// then
		assertThat(result).isEqualTo(randomString);
	}

	@Test
	public void verifyIfStaticMethodWasUsedFewTimesWithGivenArguments() {
		// given

		// when
		StringUtils.returnMultipliedString(random(10), parseInt(randomNumeric(5)));
		StringUtils.returnMultipliedString(random(10), parseInt(randomNumeric(5)));
		StringUtils.returnMultipliedString(random(10), parseInt(randomNumeric(5)));

		// then
		verifyStatic(times(3));
	}

}
