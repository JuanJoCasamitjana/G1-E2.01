package acme.testing.authenticated.patron;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AuthenticatedPatronUpdateTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

		// Test cases -------------------------------------------------------------

		@ParameterizedTest
		@CsvFileSource(resources = "/authenticated/patron/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(10)
		public void positiveTest(final int recordIndex, final String company, final String statement, final String info) {
			
			super.signIn("patron1", "patron1");
			
			super.clickOnMenu("Account", "Patron Data");
			super.checkFormExists();
			super.fillInputBoxIn("company", company);
			super.fillInputBoxIn("statement", statement);
			super.fillInputBoxIn("info", info);
			super.clickOnSubmit("Update");
			
			super.clickOnMenu("Account", "Patron Data");
			super.checkFormExists();
			super.checkInputBoxHasValue("company", company);
			super.checkInputBoxHasValue("statement", statement);
			super.checkInputBoxHasValue("info", info);

			super.signOut();
		}

		@ParameterizedTest
		@CsvFileSource(resources = "/authenticated/patron/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(10)
		public void negativeTest(final int recordIndex, final String company, final String statement, final String info) {
			
			super.signIn("patron1", "patron1");
			
			super.clickOnMenu("Account", "Patron Data");
			super.checkFormExists();
			super.fillInputBoxIn("company", company);
			super.fillInputBoxIn("statement", statement);
			super.fillInputBoxIn("info", info);
			super.clickOnSubmit("Update");
			
			super.checkErrorsExist();
			super.signOut();
		}
		
		@Test
		@Order(10)
		public void hackingTest() {
			
			super.checkNotLinkExists("Account");
			super.navigate("/authenticated/patron/update");
			super.checkPanicExists();
			
			super.signIn("administrator", "administrator");
			super.navigate("/authenticated/patron/update");
			super.checkPanicExists();
			super.signOut();
			
			super.signIn("inventor1", "inventor1");
			super.navigate("/authenticated/patron/update");
			super.checkPanicExists();
			super.signOut();
		}
	
}
