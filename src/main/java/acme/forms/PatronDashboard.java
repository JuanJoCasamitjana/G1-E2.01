
package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronDashboard implements Serializable {

	// Serialisation identifier -----------------------------------------------

	private static final long serialVersionUID = 1L;

	// Attributes -------------------------------------------------------------

	Integer						totalNumberPatronagesOfStatus;
	Double						averageBudgetPatronagesOfStatusByCurrency;
	Double						deviationBudgetPatronagesOfStatusByCurrency;
	Double						minimumBudgetPatronagesOfStatusByCurrency;
	Double						maximumBudgetPatronagesOfStatusByCurrency;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
