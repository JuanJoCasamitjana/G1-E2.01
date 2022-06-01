
package acme.testing.patron.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageUpdateTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String startDate, final String finishDate, final String moreInfo, final String published, final String inventor) {
		super.signIn("patron1", "patron1");

		super.clickOnMenu("Patrons", "My patronages");
		super.checkListingExists();
		super.sortListing(1, "asc");
		super.checkColumnHasValue(recordIndex, 1, code);
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();

		super.fillInputBoxIn("status", status);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("legalStuff", legalStuff);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("finishDate", finishDate);
		super.fillInputBoxIn("moreInfo", moreInfo);
		super.fillInputBoxIn("published", published);
		super.fillInputBoxIn("inventor", inventor);
		
		super.clickOnSubmit("Update");

		super.checkListingExists();
		super.sortListing(1, "asc");
		super.clickOnListingRecord(recordIndex);
		super.checkInputBoxHasValue("status", status);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("legalStuff", legalStuff);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("startDate", startDate);
		super.checkInputBoxHasValue("finishDate", finishDate);
		super.checkInputBoxHasValue("moreInfo", moreInfo);
		super.checkInputBoxHasValue("published", published);

		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String startDate, final String finishDate, final String moreInfo, final String published) {

		super.signIn("patron1", "patron1");

		super.clickOnMenu("Patrons", "My patronages");
		super.checkListingExists();
		super.sortListing(1, "asc");
		super.clickOnListingRecord(0);
		super.checkFormExists();

		super.fillInputBoxIn("status", status);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("legalStuff", legalStuff);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("finishDate", finishDate);
		super.fillInputBoxIn("moreInfo", moreInfo);
		super.fillInputBoxIn("published", published);

		super.clickOnSubmit("Update");

		super.checkErrorsExist();

		super.signOut();
	}

	@Test
	@Order(10)
	public void hackingTest() {

		super.checkNotLinkExists("Account");
		super.navigate("/patron/patronage/update");
		super.checkPanicExists();

		super.signIn("administrator", "administrator");
		super.navigate("/patron/patronage/update");
		super.checkPanicExists();
		super.signOut();

		super.signIn("inventor1", "inventor1");
		super.navigate("/patron/patronage/update");
		super.checkPanicExists();
		super.signOut();
	}

}
