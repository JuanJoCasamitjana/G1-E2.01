
package acme.forms;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.util.Pair;

import acme.entities.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDashboard implements Serializable {

	// Serialisation identifier -----------------------------------------------

	private static final long			serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	int									totalNumberComponents;

	Map<Pair<String, String>, Double>	averageRetailPriceComponentsByTechnologyAndCurrency;
	Map<Pair<String, String>, Double>	deviationRetailPriceComponentsByTechnologyAndCurrency;
	Map<Pair<String, String>, Double>	minimumRetailPriceComponentsByTechnologyAndCurrency;
	Map<Pair<String, String>, Double>	maximumRetailPriceComponentsByTechnologyAndCurrency;

	int									totalNumberTools;

	Map<String, Double>					averageRetailPriceToolsByCurrency;
	Map<String, Double>					deviationRetailPriceToolsByCurrency;
	Map<String, Double>					minimumRetailPriceToolsByCurrency;
	Map<String, Double>					maximumRetailPriceToolsByCurrency;

	int									totalNumberPatronagesOfStatus;

	Map<Status, Double>					averageBudgetPatronagesOfStatus;
	Map<Status, Double>					deviationBudgetPatronagesOfStatus;
	Map<Status, Double>					minimumBudgetPatronagesOfStatus;
	Map<Status, Double>					maximumBudgetPatronagesOfStatus;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
