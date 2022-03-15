package acme.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Chirp extends AbstractEntity{
	
	// Serialisation identifier -----------------------------------------------
	
	private static final long serialVersionUID = 1L;
	
	// Attributes -------------------------------------------------------------

	@NotNull
	@Past
	@Temporal(value = TemporalType.TIMESTAMP)
	protected Date creationMoment;
	
	@NotBlank
	@Length(max = 100)
	protected String title;
	
	@NotBlank
	@Length(max = 100) 
	protected String author;
	
	@NotBlank
	@Length(max = 255) 
	protected String body;
	
	@Email
	protected String email;
	
	// Derived attributes -----------------------------------------------------
	
	// Relationships ----------------------------------------------------------

}
