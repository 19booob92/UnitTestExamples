package UnitTestsExample.test.privates;

import static org.powermock.api.support.membermodification.MemberMatcher.method;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import UnitTestsExample.utils.StringUtils;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StringUtils.class)
public class PrivateMethodsTest {

	@Test
	public void shouldStringWithoutCommas() throws Exception {
		// given
		StringUtils stringUtils = new StringUtils();
        StringUtils stringUtilsSpy = PowerMockito.spy(new StringUtils());
        
        BigDecimal expectingResult = new BigDecimal(123.12).setScale(2, RoundingMode.HALF_EVEN);
		// when	
        PowerMockito.when(stringUtilsSpy, method(StringUtils.class, "changeCommasToDots", String.class))
        	.withArguments("123,12").thenReturn("555.55");
		// then
		Assert.assertEquals(expectingResult, stringUtils.getStringAsBigDecimal("123,12"));
	}

}
