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
	
	public static Boolean isWithinSpamThreshold(final String text) {
		SpamDetector strongDetect, weakDetect;
		String strongTerms, weakTerms;
		Double strongThreshold, weakThreshold;
		Boolean strongCheck, weakCheck;
		
		
		strongTerms = SpamCheck.repository.getStrongSpamTerms();
		weakTerms = SpamCheck.repository.getWeakSpamTerms();
		
		strongThreshold = SpamCheck.repository.getStrongSpamThreshold();
		weakThreshold = SpamCheck.repository.getWeakSpamThreshold();
		
		strongDetect = SpamDetector.of(strongTerms, strongThreshold); //check devuelve true si esta por encima del umbral
		weakDetect = SpamDetector.of(weakTerms, weakThreshold);
		
		strongCheck = strongDetect.check(text);
		weakCheck = weakDetect.check(text);		
		
		System.out.println("text: " + text);
		System.out.println("strongCheck: " + strongCheck);
		System.out.println("weakCheck: " + weakCheck);
		
		
		
		return !(strongCheck || weakCheck);
	}
}
