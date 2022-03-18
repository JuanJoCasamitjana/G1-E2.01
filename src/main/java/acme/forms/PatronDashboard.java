
package acme.forms;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.util.Pair;

import acme.entities.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronDashboard implements Serializable {

	// Serialisation identifier -----------------------------------------------

	private static final long			serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	int									totalNumberPatronagesOfStatus;

	Map<Pair<String, Status>, Double>	averageBudgetPatronagesOfStatusByCurrency;
	Map<Pair<String, Status>, Double>	deviationBudgetPatronagesOfStatusByCurrency;
	Map<Pair<String, Status>, Double>	minimumBudgetPatronagesOfStatusByCurrency;
	Map<Pair<String, Status>, Double>	maximumBudgetPatronagesOfStatusByCurrency;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
