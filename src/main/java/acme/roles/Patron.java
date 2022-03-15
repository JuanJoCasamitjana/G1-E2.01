package acme.roles;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.roles.UserRole;

public class Patron extends UserRole {
	protected static final long	serialVersionUID	= 1L;
	@NotNull
	@NotBlank
	@Length(max=100) //Strictly shorter than 101
	protected String company;
	@NotNull
	@NotBlank
	@Length(max=255)//Strictly shorter than 256
	protected String statement;
	@URL
	protected String info;
	//Copia de inventor, solo necesitamos una de estas entidades pero
	//por ahora crearemos las dos
}
