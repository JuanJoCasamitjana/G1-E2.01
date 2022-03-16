
package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDashboard implements Serializable {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	
	Integer						totalNumberComponentsByTechnologyAndCurrency;
	
	Integer						totalNumberTools;
	
	Double						averageRetailPriceToolsByCurrency;
	Double						deviationRetailPriceToolsByCurrency;
	Double						minimumRetailPriceToolsByCurrency;
	Double						maximumRetailPriceToolsByCurrency;
	
	Integer						totalNumberPatronagesOfStatus;
	
	Double						averageBudgetPatronagesOfStatus;
	Double						deviationBudgetPatronagesOfStatus;
	Double						minimumBudgetPatronagesOfStatus;
	Double						maximumBudgetPatronagesOfStatus;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
