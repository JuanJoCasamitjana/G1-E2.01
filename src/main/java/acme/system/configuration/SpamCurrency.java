package acme.system.configuration;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"value", "spamCurrencyType"})})
public class SpamCurrency extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	protected String value;
	
	@NotNull
	@Enumerated(value=EnumType.STRING)
	protected SpamCurrencyType spamCurrencyType;
}
