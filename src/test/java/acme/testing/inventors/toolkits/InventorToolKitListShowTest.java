package acme.testing.inventors.toolkits;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorToolKitListShowTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/tool-kit/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex,final String code, final String title, 
		final String description, final String assemblyNotes, final String optionalLink) {
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventors", "My toolkits");
		super.checkListingExists();
		super.sortListing(1, "asc");

		super.checkListingExists();
		super.checkColumnHasValue(recordIndex, 0 ,code );
		super.checkColumnHasValue(recordIndex, 1,title );
		super.clickOnListingRecord(0);
		
		super.checkFormExists();
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("assemblyNotes", assemblyNotes);
		super.checkInputBoxHasValue("optionalLink", optionalLink);
		
		super.signOut();
	}
}
