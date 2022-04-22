package acme.testing.inventors.toolkits;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorToolKitListShowTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/tool-kit/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String name, 
		final String surname, final String username, final String roles) {
		
	}
}
