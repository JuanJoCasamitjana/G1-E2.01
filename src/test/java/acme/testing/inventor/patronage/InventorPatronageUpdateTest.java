package acme.testing.inventor.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageUpdateTest extends TestHarness{
	
	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String status, final String code,
		final String legalStuff, final String budget, final String startDate, 
		final String finishDate, final String moreInfo) {
		
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Patrons", "My patronages");
		super.clickOnButton("Create patronage");
		
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("legalStuff", legalStuff);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("finishDate", finishDate);
		super.fillInputBoxIn("moreInfo", moreInfo);
		super.fillInputBoxIn("inventor", "inventor1");
		
		super.clickOnSubmit("Create");
		
		super.checkListingExists();
		super.sortListing(1, "asc");
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		
		super.checkInputBoxHasValue("status", "PROPOSED");
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("legalStuff", legalStuff);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("startDate", startDate);
		super.checkInputBoxHasValue("finishDate", finishDate);
		super.checkInputBoxHasValue("moreInfo", moreInfo);
		
		super.clickOnSubmit("Publish");
		
		super.signOut();
		
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventors", "My patronages");
		
		super.checkListingExists();
		super.sortListing(1, "asc");
		super.clickOnListingRecord(recordIndex);
		
		super.checkFormExists();
		super.fillInputBoxIn("status", status);
		super.clickOnSubmit("Update");
		
		super.checkListingExists();
		super.sortListing(1, "asc");
		super.checkColumnHasValue(recordIndex, 0, status);
		
		super.signOut();
	}
	
	@Test
    @Order(20)
    public void hackingTest() {
		
		super.checkNotLinkExists("Account");
        super.navigate("/inventor/patronage/update");
        super.checkPanicExists();

        super.signIn("administrator", "administrator");
        super.navigate("/inventor/patronage/update");
        super.checkPanicExists();
        super.signOut();

        super.signIn("patron1", "patron1");
        super.navigate("/inventor/patronage/update");
        super.checkPanicExists();
        super.signOut();
        
	}
	
}
