package acme.testing.inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorItemToolPublishTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/publish-positive-tool.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String type, final String name, final String code, final String technology, final String description, final String retailPrice, final String optionalLink, final String published) {
		
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventors", "My tools");
		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.clickOnSubmit("Publish");
		
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 4, published);
		
	}
	
	@Test
	@Order(10)
	public void hackingTest() {
		
		super.checkNotLinkExists("Account");
		super.navigate("/inventor/item/publish");
		super.checkPanicExists();

		super.signIn("administrator", "administrator");
		super.navigate("/inventor/item/publish");
		super.checkPanicExists();
		super.signOut();
		
		super.signIn("patron1", "patron1");
		super.navigate("/inventor/item/publish");
		super.checkPanicExists();
		super.signOut();
	}
}
