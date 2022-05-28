package acme.components;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import acme.forms.MoneyExchange;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MoneyExchangeTracking extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	MoneyExchange exchange;
}
