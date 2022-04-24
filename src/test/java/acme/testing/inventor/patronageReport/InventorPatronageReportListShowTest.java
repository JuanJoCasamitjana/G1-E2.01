package acme.testing.inventor.patronageReport;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageReportListShowTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage-report/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String creationDate,
		final String serialCode, final String memorandum, final String optionalLink) {
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventors", "My patronage reports");
		super.checkListingExists();
		super.sortListing(1, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, creationDate);
		super.checkColumnHasValue(recordIndex, 1, memorandum);
		super.checkColumnHasValue(recordIndex, 2, serialCode);
		super.checkColumnHasValue(recordIndex, 3, optionalLink);
		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("creationDate", creationDate);
		super.checkInputBoxHasValue("memorandum", memorandum);
		super.checkInputBoxHasValue("serialCode", serialCode);
		super.checkInputBoxHasValue("optionalLink", optionalLink);
		
		super.signOut();
	}
}
