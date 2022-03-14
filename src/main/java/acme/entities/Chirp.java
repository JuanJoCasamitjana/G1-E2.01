package acme.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	protected LocalDate creationMoment;
	
	@NotNull
	@NotBlank
	@Length(max = 100)
	protected String title;
	
	@NotNull
	@NotBlank
	@Length(max = 100) 
	protected String author;
	
	@NotNull
	@NotBlank
	@Length(max = 255) 
	protected String body;
	
	@Email
	protected String email;
	
	// Derived attributes -----------------------------------------------------
	
	// Relationships ----------------------------------------------------------

}
