package acme.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import acme.roles.Inventor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class ToolKit extends AbstractEntity{
	
	// Serialisation identifier -----------------------------------------------
	
	private static final long serialVersionUID = 1L;
		
	// Attributes -------------------------------------------------------------
	@NotBlank
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$", message = "wrong pattern, example -> ABZ-019-A")
	@Column(unique = true)
	protected String code;
	
	@NotBlank
	@Length(max = 100)
	protected String title;
	
	@NotBlank
	@Length(max = 255)
	protected String description;
	
	@NotBlank
	@Length(max = 255)
	protected String assemblyNotes;
	
	@URL
	protected String optionalLink;
	
	@NotNull
	protected boolean published;
	
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Inventor inventor;
}
