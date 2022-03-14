package acme.roles;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.roles.UserRole;

public class Patron extends UserRole {
	protected static final long	serialVersionUID	= 1L;
	
	@NotBlank
	@Length(max=100) //Strictly shorter than 101
	private String company;
	@NotBlank
	@Length(max=255)//Strictly shorter than 256
	private String statement;
	@URL
	private String info;
	//Copia de inventor, solo necesitamos una de estas entidades pero
	//por ahora crearemos las dos
}
