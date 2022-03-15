package acme.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Quantity extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------
	
	private static final long serialVersionUID = 1L;
	
	// Attributes -------------------------------------------------------------
	
	@Length(min = 0)
	protected int componentQuantity;
	
	@Length(min = 0)
	protected int toolQuantity;
	
	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------
	
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Item item;
	
//	@NotNull
//	@Valid
//	@ManyToOne(optional = false)
//	protected ToolKit toolkit;
	
}
