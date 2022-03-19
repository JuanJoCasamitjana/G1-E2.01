package acme.system.configuration;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"value", "spamThresholdType"})})
public class SpamThreshold extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Range(min=0, max=1)
	protected double value;
	
	@NotNull
//	@Enumerated(value=EnumType.STRING)
	protected SpamThresholdType spamThresholdType;
}
