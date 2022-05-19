package acme.testing.authenticated.inventor;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AuthenticatedInventorUpdateTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

		// Test cases -------------------------------------------------------------

		@ParameterizedTest
		@CsvFileSource(resources = "/authenticated/inventor/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(10)
		public void positiveTest(final int recordIndex, final String company, final String statement, final String info) {
			
			super.signIn("inventor1", "inventor1");
			
			super.clickOnMenu("Account", "Inventor Data");
			super.checkFormExists();
			super.fillInputBoxIn("company", company);
			super.fillInputBoxIn("statement", statement);
			super.clickOnSubmit("Update");
			
			super.clickOnMenu("Account", "Inventor Data");
			super.checkFormExists();
			super.checkInputBoxHasValue("company", company);
			super.checkInputBoxHasValue("statement", statement);


			super.signOut();
		}

		@ParameterizedTest
		@CsvFileSource(resources = "/authenticated/inventor/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(10)
		public void negativeTest(final int recordIndex, final String company, final String statement, final String info) {
			
			super.signIn("inventor1", "inventor1");
			
			super.clickOnMenu("Account", "Inventor Data");
			super.checkFormExists();
			super.fillInputBoxIn("company", company);
			super.fillInputBoxIn("statement", statement);
			super.clickOnSubmit("Update");
			
			super.checkErrorsExist();
			super.signOut();
		}
	
}
