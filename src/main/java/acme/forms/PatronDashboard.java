
package acme.forms;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.util.Pair;

import acme.entities.Status;
import acme.framework.datatypes.Money;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronDashboard implements Serializable {

	// Serialisation identifier -----------------------------------------------

	private static final long			serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	Map<Status, Integer>				totalNumberPatronagesOfStatus;

	Map<Pair<Status, String>, Money>	averageBudgetPatronagesOfStatusByCurrency;
	Map<Pair<Status, String>, Money>	deviationBudgetPatronagesOfStatusByCurrency;
	Map<Pair<Status, String>, Money>	minimumBudgetPatronagesOfStatusByCurrency;
	Map<Pair<Status, String>, Money>	maximumBudgetPatronagesOfStatusByCurrency;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
