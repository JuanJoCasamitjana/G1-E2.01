package acme.testing.any.userAccount;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyUserAccountListShowTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/any/userAccount/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String name, final String surname, final String username, final String roles) {
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("All", "Users");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, name);
		super.checkColumnHasValue(recordIndex, 1, surname);
		super.checkColumnHasValue(recordIndex, 2, username);
		super.checkColumnHasValue(recordIndex, 3, roles);
//
//		super.clickOnListingRecord(recordIndex);
//		super.checkFormExists();
//		super.checkInputBoxHasValue("name", name);
//		super.checkInputBoxHasValue("surname", surname);
//		super.checkInputBoxHasValue("username", username);
//		super.checkInputBoxHasValue("roles", roles);

		super.signOut();
	}

	// Ancillary methods ------------------------------------------------------
	
}
