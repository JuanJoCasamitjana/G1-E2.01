package acme.features.administrator.announcement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.components.SpamCheck;
import acme.entities.Announcement;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorAnnouncementCreateService implements AbstractCreateService<Administrator, Announcement>{
	
	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected AdministratorAnnouncementRepository repository;
	
	// AbstractCreateService<Administrator, Announcement> interface --------------
	
	@Override
	public boolean authorise(final Request<Announcement> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Announcement> request, final Announcement entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "title", "body", "critical", "optionalLink");
		
	}

	@Override
	public void unbind(final Request<Announcement> request, final Announcement entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "title", "body", "critical", "optionalLink");
		model.setAttribute("confirmation", false);
		
	}

	@Override
	public Announcement instantiate(final Request<Announcement> request) {
		assert request != null;
		
		Announcement result;
		Date creationMoment;
		
		result = new Announcement();
		creationMoment = new Date(System.currentTimeMillis()-1);
		
		result.setCreationMoment(creationMoment);
		result.setTitle("");
		result.setBody("");
		result.setCritical(false);
		result.setOptionalLink(null);
		
		return result;
	}

	@Override
	public void validate(final Request<Announcement> request, final Announcement entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		final boolean confirmation = request.getModel().getBoolean("confirmation");
		errors.state(request, confirmation, "confirmation", "javax.validation.constraints.AssertTrue.message");
		
		boolean bodyWithinThreshold, titleWithinThreshold;
		
		bodyWithinThreshold = SpamCheck.isWithinSpamThreshold(entity.getBody());
		titleWithinThreshold = SpamCheck.isWithinSpamThreshold(entity.getTitle());
		
		errors.state(request, !bodyWithinThreshold, "body", "administrator.announcement.form.error.spam");
		errors.state(request, !titleWithinThreshold, "title", "administrator.announcement.form.error.spam");
		
	}

	@Override
	public void create(final Request<Announcement> request, final Announcement entity) {
		assert request != null;
		assert entity != null;
		
		Date creationMoment;
		creationMoment = new Date(System.currentTimeMillis()-1);
		entity.setCreationMoment(creationMoment);
		
		this.repository.save(entity);
	}
	
	
	
}
