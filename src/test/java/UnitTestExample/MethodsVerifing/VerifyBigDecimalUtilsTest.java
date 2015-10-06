package UnitTestExample.MethodsVerifing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import org.assertj.core.data.Percentage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import UnitTestsExample.utils.BigDecimalUtils;
import UnitTestsExample.utils.InvoiceGenerator;

@RunWith(MockitoJUnitRunner.class)
public class VerifyBigDecimalUtilsTest {

	@Mock
	public InvoiceGenerator invoiceGenerator;

	@InjectMocks
	public BigDecimalUtils classUnderTest;

	@Test
	public void shouldCallGenerateInvoiceMethodFromInvoiceGeneratorWithGivenParams() {
		ArgumentCaptor<BigDecimal> bigDecimalCaptop = ArgumentCaptor.forClass(BigDecimal.class);

		classUnderTest.countCommisions();

		verify(invoiceGenerator).generateAndSaveInvoice(anyString(), anyString(), bigDecimalCaptop.capture());
		assertThat(new BigDecimal(17.3)).isCloseTo(bigDecimalCaptop.getValue(), Percentage.withPercentage(10));
	}

	@Test
	public void shouldCallGenerateInvoiceMethodFromInvoiceGeneratorWithProperData() {
		ArgumentCaptor<BigDecimal> bigDecimalCaptop = ArgumentCaptor.forClass(BigDecimal.class);
		ArgumentCaptor<String> userNameCaptop = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<String> invoiceNoCaptop = ArgumentCaptor.forClass(String.class);

		classUnderTest.countCommisions();

		verify(invoiceGenerator).generateAndSaveInvoice(invoiceNoCaptop.capture(), userNameCaptop.capture(),
				bigDecimalCaptop.capture());
		assertThat(new BigDecimal(17.3)).isCloseTo(bigDecimalCaptop.getValue(), Percentage.withPercentage(10));
		assertThat(invoiceNoCaptop.getValue()).isEqualTo("Invoice 2015/09");
		assertThat(userNameCaptop.getValue()).isEqualTo("John Smith");
	}

}
