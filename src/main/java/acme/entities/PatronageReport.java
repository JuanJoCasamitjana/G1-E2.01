package acme.entities;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PatronageReport extends AbstractEntity {

	// Serialisation identifier
	
	protected static final long serialVersionUID = 1L;
	
	//Attributes
	
	@Past
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected LocalDate creationDate;
	
	@NotBlank
	@Length(max = 255)
	protected String memorandum;
	
	@URL
	protected String moreInfo;
		
	//Derived attributes
	
	@NotBlank
	protected String serialCode() {
			
		String serialNumber = Integer.toString(this.id);
		
		while (serialNumber.length() < 4) {
			serialNumber = "0" + serialNumber;
		}
		
		return this.patronage.getCode() + ":" + serialNumber;
	}
	
	//Relationships
	
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Patronage patronage;
}