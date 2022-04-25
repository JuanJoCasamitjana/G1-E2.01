package acme.testing.authenticated.announcement;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AuthenticatedAnnouncementListShowTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

		// Test cases -------------------------------------------------------------

		@ParameterizedTest
		@CsvFileSource(resources = "/authenticated/announcement/list.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(10)
		public void positiveTest(final int recordIndex, final String title, final String creationMoment, final String criticality,  final String body,  final String url) {
			super.signIn("inventor1", "inventor1");
			
			super.clickOnMenu("Authenticated", "Recent announcements");
			super.checkListingExists();
			super.sortListing(0, "asc");
			
			super.checkColumnHasValue(recordIndex, 0, title);
			super.checkColumnHasValue(recordIndex, 1, creationMoment);
			super.checkColumnHasValue(recordIndex, 2, criticality);

			super.clickOnListingRecord(recordIndex);
			super.checkFormExists();
			super.checkInputBoxHasValue("title", title);
			if(criticality.equals("false")) {
				super.checkInputBoxHasValue("critical", "NOT CRITICAL");
			} else {
				super.checkInputBoxHasValue("critical", "CRITICAL");
			}
			super.checkInputBoxHasValue("body", body);
			super.checkInputBoxHasValue("optionalLink", url);

			super.signOut();
		}

		// Ancillary methods ------------------------------------------------------
		
	
}
