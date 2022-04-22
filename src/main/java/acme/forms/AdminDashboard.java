
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
public class AdminDashboard implements Serializable {

	// Serialisation identifier -----------------------------------------------

	private static final long			serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	int									totalNumberComponents;

	Map<Pair<String, String>, Money>	averageRetailPriceComponentsByTechnologyAndCurrency;
	Map<Pair<String, String>, Money>	deviationRetailPriceComponentsByTechnologyAndCurrency;
	Map<Pair<String, String>, Money>	minimumRetailPriceComponentsByTechnologyAndCurrency;
	Map<Pair<String, String>, Money>	maximumRetailPriceComponentsByTechnologyAndCurrency;

	int									totalNumberTools;

	Map<String, Money>					averageRetailPriceToolsByCurrency;
	Map<String, Money>					deviationRetailPriceToolsByCurrency;
	Map<String, Money>					minimumRetailPriceToolsByCurrency;
	Map<String, Money>					maximumRetailPriceToolsByCurrency;

	Map<Status, Integer>				totalNumberPatronagesOfStatus;

	Map<Status, Money>					averageBudgetPatronagesOfStatus;
	Map<Status, Money>					deviationBudgetPatronagesOfStatus;
	Map<Status, Money>					minimumBudgetPatronagesOfStatus;
	Map<Status, Money>					maximumBudgetPatronagesOfStatus;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
