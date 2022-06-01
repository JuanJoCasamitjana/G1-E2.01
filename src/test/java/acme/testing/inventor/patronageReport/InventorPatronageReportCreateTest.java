package acme.testing.inventor.patronageReport;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageReportCreateTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage-report/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String memorandum, final String optionalLink) {
		
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Patrons", "My patronages");
		super.clickOnButton("Create patronage");
		
		super.fillInputBoxIn("code", "AAA-000-A");
		super.fillInputBoxIn("legalStuff", "The legal stuff is here");
		super.fillInputBoxIn("budget", "EUR 1,099.99");
		super.fillInputBoxIn("startDate", "2023/02/20 09:00");
		super.fillInputBoxIn("finishDate", "2023/06/20 08:59");
		super.fillInputBoxIn("moreInfo", "");
		super.fillInputBoxIn("inventor", "inventor1");
		
		super.clickOnSubmit("Create");
		
		super.checkListingExists();
		super.sortListing(1, "asc");
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		
		super.checkInputBoxHasValue("status", "PROPOSED");
		super.checkInputBoxHasValue("code", "AAA-000-A");
		super.checkInputBoxHasValue("legalStuff", "The legal stuff is here");
		super.checkInputBoxHasValue("budget", "EUR 1,099.99");
		super.checkInputBoxHasValue("startDate", "2023/02/20 09:00");
		super.checkInputBoxHasValue("finishDate", "2023/06/20 08:59");
		super.checkInputBoxHasValue("moreInfo", "");
		
		super.clickOnSubmit("Publish");
		
		super.signOut();
		
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventors", "My patronage reports");
		
		super.checkListingExists();
		
		super.clickOnButton("Create");
		
		super.fillInputBoxIn("memorandum", memorandum);
		super.fillInputBoxIn("optionalLink", optionalLink);
		super.fillInputBoxIn("patronage", "AAA-000-A");
		super.fillInputBoxIn("confirmation", "true");
		
		super.clickOnSubmit("Create");
		
		super.checkListingExists();
		super.sortListing(2, "asc");
		super.clickOnListingRecord(recordIndex);
		
		super.checkFormExists();
		super.checkInputBoxHasValue("memorandum", memorandum);
		super.checkInputBoxHasValue("optionalLink", optionalLink);
		super.checkInputBoxHasValue("patronage", "AAA-000-A");
		
		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage-report/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest(final int recordIndex, final String memorandum, final String optionalLink, final String confirmation) {
		
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventors", "My patronage reports");
		
		super.checkListingExists();
		
		super.clickOnButton("Create");
		
		super.fillInputBoxIn("memorandum", memorandum);
		super.fillInputBoxIn("optionalLink", optionalLink);
		super.fillInputBoxIn("patronage", "AAA-000-A");
		super.fillInputBoxIn("confirmation", confirmation);
		
		super.clickOnSubmit("Create");
		
		super.checkErrorsExist();
		
		super.signOut();
		
	}
	
	@Test
    @Order(30)
    public void hackingTest() {
		
		super.checkNotLinkExists("Account");
        super.navigate("/inventor/patronage/update");
        super.checkPanicExists();

        super.signIn("administrator", "administrator");
        super.navigate("/inventor/patronage-report/create");
        super.checkPanicExists();
        super.signOut();

        super.signIn("patron1", "patron1");
        super.navigate("/inventor/patronage-report/create");
        super.checkPanicExists();
        super.signOut();
        
	}
	
}
