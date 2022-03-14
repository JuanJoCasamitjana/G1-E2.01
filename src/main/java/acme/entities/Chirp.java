package acme.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

	protected Date creationMoment;
	
	@NotNull
	@NotBlank
	@Length(max = 100) //Strictly shorter than 101
	protected String title;
	
	@NotNull
	@NotBlank
	@Length(max = 100) //Strictly shorter than 101
	protected String author;
	
	@NotNull
	@NotBlank
	@Length(max = 255) //Strictly shorter than 256
	protected String body;
	
	@Email
	protected String email;
	
	// Derived attributes -----------------------------------------------------
	
	// Relationships ----------------------------------------------------------

}
