package acme.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.spamDetector.main.mavenproject.SpamDetector;

@ControllerAdvice
public class SpamCheck {
	
	@Autowired
	protected static SystemConfigurationRepository repository;
	
	@Autowired
	private SpamCheck(final SystemConfigurationRepository repository) {
		SpamCheck.repository = repository;
	}
	
	public static Boolean underSpamThreshold(final String text) {
		SpamDetector strongDetect, weakDetect;
		String strongTerms, weakTerms;
		Double strongThreshold, weakThreshold;
		
		strongTerms = SpamCheck.repository.getStrongSpamTerms();
		weakTerms = SpamCheck.repository.getWeakSpamTerms();
		strongThreshold = SpamCheck.repository.getStrongSpamThreshold();
		weakThreshold = SpamCheck.repository.getWeakSpamThreshold();
		
		strongDetect = SpamDetector.of(strongTerms, strongThreshold);
		weakDetect = SpamDetector.of(weakTerms, weakThreshold);
		
		
		return !(strongDetect.check(text) || weakDetect.check(text));
	}
}
