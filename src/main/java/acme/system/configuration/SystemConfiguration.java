package acme.system.configuration;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SystemConfiguration extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String defaultSystemCurrency;
	
	@NotBlank
	private String acceptedCurrencies;
	
	@NotBlank
	private String strongSpamTerms;
	
	@Range(min = 0, max = 1)
	private Double strongSpamThreshold;
	
	@NotBlank
	private String weakSpamTerms;
	
	@Range(min = 0, max = 1)
	private Double weakSpamThreshold;

}
