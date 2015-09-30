package UnitTestsExample.test.statics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import UnitTestsExample.utils.StringUtils;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StringUtils.class)
public class StaticsMethodsMockTest {

	@Before
	public void init() {
		PowerMockito.mockStatic(StringUtils.class);
	}
	
	@Test
	public void shouldReturnMultipliedGivenString() {
		// given
		Mockito.when(StringUtils.returnMultipliedString("Test", 3)).thenReturn("TestTestTest");
		// when
		String result = StringUtils.returnMultipliedString("Test", 3);
		// then
		Assert.assertEquals("TestTestTest", result);
	}

	@Test
	public void shouldReturnMultipliedAnyString() {
		// given
		Mockito.when(StringUtils.returnMultipliedString(Matchers.anyString(), Matchers.anyInt()))
				.thenReturn("TestTestTest");
		// when
		String result = StringUtils.returnMultipliedString("AnyString", 5);
		// then
		Assert.assertEquals("TestTestTest", result);
	}

	@Test
	public void verifyIfStaticMethodWasUsedFewTimesWithGivenArguments() {
		// given
		Mockito.when(StringUtils.returnMultipliedString(Matchers.anyString(), Matchers.anyInt()))
				.thenReturn("TestTestTest");
		// when
		StringUtils.returnMultipliedString("AnyString", 5);
		StringUtils.returnMultipliedString("AnyString", 5);
		StringUtils.returnMultipliedString("AnyString", 5);
		// then
		PowerMockito.verifyStatic(Mockito.times(3));
	}

}
