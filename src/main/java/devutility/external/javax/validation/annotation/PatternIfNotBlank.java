package devutility.external.javax.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import devutility.external.javax.validation.annotation.impl.PatternIfNotBlankValidatorImpl;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Constraint(validatedBy = { PatternIfNotBlankValidatorImpl.class })
public @interface PatternIfNotBlank {
	/**
	 * @return the regular expression to match
	 */
	String regexp();

	/**
	 * @return the error message template
	 */
	String message() default "{devutility.external.javax.validation.annotation.PatternIfNotNull.message}";

	/**
	 * groups for constraint annotation.
	 * @return {@code Class<?>[]}
	 */
	Class<?>[] groups() default {};

	/**
	 * payload
	 * @return {@code Class<? extends Payload>[]}
	 */
	Class<? extends Payload>[] payload() default {};
}