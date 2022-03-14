package acme.entities;

import java.time.Duration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.time.DurationMin;

import acme.framework.entities.AbstractEntity;
import acme.roles.Inventor;
import acme.roles.Patron;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patronage extends AbstractEntity {
	
	// Serialisation identifier
	
	protected static final long serialVersionUID = 1L;
	
	//Attributes
	
	@NotNull
	protected Status status;
	
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$", message = "wrong pattern, example -> ABZ-019-A")
	@Column(unique = true)
	@NotNull
	protected String code;
	
	@NotBlank
	@Length(max = 255)
	@NotNull
	protected String legalStuff;
	
	@Positive
	@NotNull
	protected Double budget;
	
	@DurationMin(days = 30)
	@NotNull
	protected Duration duration;
	
	@URL
	protected String moreInfo;
	
	//Derived attributes
	
	//Relationships
	
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Inventor inventor;
	
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Patron patron;
		
	
}
