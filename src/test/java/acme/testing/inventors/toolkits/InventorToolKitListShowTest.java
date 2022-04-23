package acme.testing.inventors.toolkits;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorToolKitListShowTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/tool-kit/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex,final String code, final String name, 
		final String title, final String description, final String assemblyNotes, 
		final String optionalLink) {
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "");
		super.checkListingExists();
		super.sortListing(1, "asc");

		super.signOut();
	}
}
