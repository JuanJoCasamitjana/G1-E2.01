package acme.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
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
	@Length(max = 101)
	protected String title;
	
	@NotBlank
	@Length(max = 256)
	protected String description;
	
	@NotBlank
	@Length(max = 256)
	protected String assemblyNotes;
	
	@URL
	protected String moreInfo;
	
	@NotNull
	@Column(unique = true)
//	@Check(constraints = "tool.type = 'TOOL'")
	@JoinColumn
	@OneToOne(cascade=CascadeType.ALL)
	protected Item tool;
	
//	@NotNull
//	@Check(constraints = "component.type = 'COMPONENT'")
//	@JoinColumn
//	@ManyToOne(cascade=CascadeType.ALL)
//	protected Item component;
}
