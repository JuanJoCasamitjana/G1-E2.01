package acme.testing.authenticated.inventor;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AuthenticatedInventorCreateTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

		// Test cases -------------------------------------------------------------

		@ParameterizedTest
		@CsvFileSource(resources = "/authenticated/inventor/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(10)
		public void positiveTest(final int recordIndex, final String company, final String statement, final String info) {
			
			super.signUp("test1", "test1", "test1", "test1", "test@gmail.com");
			super.signIn("test1", "test1");
			
			super.clickOnMenu("Account", "Become a Inventor");
			super.checkFormExists();
			super.fillInputBoxIn("company", company);
			super.fillInputBoxIn("statement", statement);
			super.clickOnSubmit("Register");

			super.signOut();
		}

		@ParameterizedTest
		@CsvFileSource(resources = "/authenticated/inventor/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(10)
		public void negativeTest(final int recordIndex, final String company, final String statement, final String info) {
			
			super.signUp("test2", "test2", "test2", "test2", "test2@gmail.com");
			super.signIn("test2", "test2");
			
			super.clickOnMenu("Account", "Become a Inventor");
			super.checkFormExists();
			super.fillInputBoxIn("company", company);
			super.fillInputBoxIn("statement", statement);
			super.clickOnSubmit("Register");
			
			super.checkErrorsExist();
			super.signOut();
		}
	
}
