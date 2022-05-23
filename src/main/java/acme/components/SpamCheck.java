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
	
	public static Boolean overStrongSpamThreshold(final String text) {
		SpamDetector detect;
		String terms;
		Double threshold;
		
		terms = SpamCheck.repository.getStrongSpamTerms();
		threshold = SpamCheck.repository.getStrongSpamThreshold();
		
		detect = SpamDetector.of(terms, threshold);
		
		
		return detect.check(text);
	}
}
