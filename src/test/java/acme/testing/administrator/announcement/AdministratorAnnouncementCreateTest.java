package acme.testing.administrator.announcement;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AdministratorAnnouncementCreateTest extends TestHarness{

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/announcement/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String creationMoment, final String title, final String body, final String critical, final String optionalLink) {
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Create a new announcement");
		super.checkFormExists();
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("critical", critical);
		super.fillInputBoxIn("optionalLink", optionalLink);
		super.fillInputBoxIn("confirmation", "true");
		
		super.clickOnSubmit("Create");
		
		super.clickOnMenu("Authenticated", "Recent announcements");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("body", body);
		super.checkInputBoxHasValue("critical", "CRITICAL");
		super.checkInputBoxHasValue("optionalLink", optionalLink);
		
		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/announcement/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int recordIndex, final String creationMoment, final String title, final String body, final String critical, final String optionalLink) {
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Create a new announcement");
		super.checkFormExists();
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("critical", critical);
		super.fillInputBoxIn("optionalLink", optionalLink);
		super.fillInputBoxIn("confirmation", "true");
		
		super.clickOnSubmit("Create");
		
		super.checkErrorsExist();
		
		super.signOut();
	}
	
	@Test
    @Order(10)
    public void hackingTest() {

        super.checkNotLinkExists("Account");
        super.navigate("/administrator/announcement/create");
        super.checkPanicExists();

        super.signIn("patron1", "patron1");
        super.navigate("/administrator/announcement/create");
        super.checkPanicExists();
        super.signOut();

        super.signIn("inventor1", "inventor1");
        super.navigate("/administrator/announcement/create");
        super.checkPanicExists();
        super.signOut();
    }
	
}
