package acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Component  extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------
	
	private static final long serialVersionUID = 1L;
	
	// Attributes -------------------------------------------------------------
	
	@NotNull
	@NotBlank
	@Length(max = 100)
	protected String name;
	
	@NotNull
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$", message = "wrong pattern, example -> ABZ-019-A")
	@Column(unique = true)
	protected String code;

	@NotNull
	@NotBlank
	@Length(max = 100)
	protected String technology;
	
	@NotNull
	@NotBlank
	@Length(max = 255)
	protected String description;
	
	@NotNull
	@Positive
	protected Double retailPrice;
	
	@URL
	protected String moreInfo;
	
}
