package acme.features.inventor.patronageReport;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportCreateService implements AbstractCreateService<Inventor, PatronageReport> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorPatronageReportRepository repository;
	
	// AbstractListService<Inventor, PatronageReport> interface --------------
	
	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request != null;

		return true;
	}
	
	@Override
	public void bind(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationDate", "memorandum", "optionalLink");
		entity.setPatronage(this.repository.findPatronageByCode(request.getModel().getAttribute("patronage").toString()));
		entity.setSerialCode(entity.getPatronage().getCode() +":"+ String.format("%04d", this.repository.findAllPatronageReports().size()+1));
	}
	
	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		final int inventorId = request.getPrincipal().getActiveRoleId();
		request.unbind(entity, model, "creationDate", "memorandum", "serialCode", "optionalLink");
		model.setAttribute("patronages", this.repository.findAllPatronagesByInventorId(inventorId));
		model.setAttribute("confirmation", false);
	}

	@Override
	public PatronageReport instantiate(final Request<PatronageReport> request) {
		assert request != null;
		
		final PatronageReport result;
		result = new PatronageReport();
		result.setCreationDate(Date.valueOf(LocalDate.now()));
		result.setMemorandum("");
		result.setSerialCode("");
		result.setOptionalLink("");

		return result;
	}

	@Override
	public void validate(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		final boolean confirmation = request.getModel().getBoolean("confirmation");
		errors.state(request, confirmation, "confirmation", "javax.validation.constraints.AssertTrue.message");
	}

	
	@Override
	public void create(final Request<PatronageReport> request, final PatronageReport entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);		
	}

	
}
