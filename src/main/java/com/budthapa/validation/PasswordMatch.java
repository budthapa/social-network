/**
 * 
 */
package com.budthapa.validation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author budthapa
 * Feb 24, 2017
 * 
 */
@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy=PasswordMatchValidator.class)
@Documented
public @interface PasswordMatch {
	String message() default "{register.password.mismatch}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
