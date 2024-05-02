package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import domain.Aankoop;

public class AankoopValidation implements Validator {

    @Override
    public boolean supports(Class<?> klass) {
        return Aankoop.class.isAssignableFrom(klass);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	Aankoop aankoop = (Aankoop) target;
    	
    	if (aankoop == null || aankoop.getVoetbalCode1() == null || aankoop.getVoetbalCode2() == null)
    		return;
    	
    	if (!(aankoop.getVoetbalCode1() < aankoop.getVoetbalCode2()))
    		errors.rejectValue("voetbalCode1", "AankoopValidation.Code1KleinerDanCode2", "voetbalcode1 is niet kleiner dan voetbalcode 2");
    }
}