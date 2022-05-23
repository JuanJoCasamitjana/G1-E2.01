package acme.testing.inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorItemToolCreateTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/create-positive-tool.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String type, final String name, final String code, final String technology, final String description, final String retailPrice, final String optionalLink, final String published) {
		
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventors", "My tools");
		super.clickOnButton("Create");
		
		super.checkFormExists();
		super.fillInputBoxIn("type", type);
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("technology", technology);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("retailPrice", retailPrice);
		super.fillInputBoxIn("optionalLink", optionalLink);
		super.clickOnSubmit("Create");
		
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, name);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.checkColumnHasValue(recordIndex, 2, technology);
		super.checkColumnHasValue(recordIndex, 3, retailPrice);
		super.checkColumnHasValue(recordIndex, 4, published);
		
		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/create-negative-tool.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int recordIndex, final String type, final String name, final String code, final String technology, final String description, final String retailPrice, final String optionalLink, final String published) {
		
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventors", "My tools");
		super.clickOnButton("Create");
		
		super.checkFormExists();
		super.fillInputBoxIn("type", type);
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("technology", technology);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("retailPrice", retailPrice);
		super.fillInputBoxIn("optionalLink", optionalLink);
		super.clickOnSubmit("Create");
				
		super.checkErrorsExist();
		
		super.signOut();
	}
	
	@Test
	@Order(10)
	public void hackingTest() {
		
		super.checkNotLinkExists("Account");
		super.navigate("/inventor/item/create");
		super.checkPanicExists();

		super.signIn("administrator", "administrator");
		super.navigate("/inventor/item/create");
		super.checkPanicExists();
		super.signOut();
		
		super.signIn("patron1", "patron1");
		super.navigate("/inventor/item/create");
		super.checkPanicExists();
		super.signOut();
	}
	
}
