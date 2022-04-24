package acme.testing.inventor.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageListShowTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String status, final String code,
		final String legalStuff, final String budget, final String creationDate,
		final String startDate, final String finishDate, final String moreInfo) {
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventors", "My patronages");
		super.checkListingExists();
		super.sortListing(1, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, status);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.checkColumnHasValue(recordIndex, 2, legalStuff);
		super.checkColumnHasValue(recordIndex, 3, budget);
		super.checkColumnHasValue(recordIndex, 4, creationDate);
		super.checkColumnHasValue(recordIndex, 5, startDate);
		super.checkColumnHasValue(recordIndex, 6, finishDate);
		super.checkColumnHasValue(recordIndex, 7, moreInfo);
		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("status", status);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("legalStuff", legalStuff);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("creationDate", creationDate);
		super.checkInputBoxHasValue("startDate", startDate);
		super.checkInputBoxHasValue("finishDate", finishDate);
		super.checkInputBoxHasValue("moreInfo", moreInfo);
		
		super.signOut();
	}
}
