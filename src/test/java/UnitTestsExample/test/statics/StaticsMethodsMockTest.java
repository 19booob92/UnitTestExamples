package UnitTestsExample.test.statics;

import UnitTestsExample.utils.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

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
		given(StringUtils.returnMultipliedString("Test", 3)).willReturn("TestTestTest");

		// when
		String result = StringUtils.returnMultipliedString("Test", 3);

		// then
		assertThat(result).isEqualTo("TestTestTest");
	}

	@Test
	public void shouldReturnMultipliedAnyString() {
		// given
		given(StringUtils.returnMultipliedString(anyString(), anyInt()))
				.willReturn("TestTestTest");

		// when
		String result = StringUtils.returnMultipliedString("AnyString", 5);

		// then
		assertThat(result).isEqualTo("TestTestTest");
	}

	@Test
	public void verifyIfStaticMethodWasUsedFewTimesWithGivenArguments() {
		// given
		given(StringUtils.returnMultipliedString(anyString(), anyInt()))
				.willReturn("TestTestTest");

		// when
		StringUtils.returnMultipliedString("AnyString", 5);
		StringUtils.returnMultipliedString("AnyString", 5);
		StringUtils.returnMultipliedString("AnyString", 5);

		// then
		verifyStatic(times(3));
	}

}
