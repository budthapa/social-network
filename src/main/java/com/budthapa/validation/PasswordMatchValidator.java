package com.budthapa.validation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.budthapa.domain.SiteUser;

/**
 * 
 */

/**
 * @author budthapa
 * Feb 24, 2017
 * 
 */
public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, SiteUser>{

	/* (non-Javadoc)
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
	 */
	@Override
	public void initialize(PasswordMatch constraintAnnotation) {
		
	}

	/* (non-Javadoc)
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(SiteUser user, ConstraintValidatorContext context) {
		String plainPassword = user.getPlainPassword();
		String repeatPasword = user.getRepeatPassword();
		
		if(plainPassword == null || plainPassword.length() == 0){
			return true;
		}
		
		if(plainPassword==null || !plainPassword.equals(repeatPasword)){
			return false;
		}
		
		return true;
	}

}
