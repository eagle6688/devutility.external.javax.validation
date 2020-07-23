package devutility.external.javax.validation.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import devutility.external.javax.validation.annotation.impl.PatternIfNotBlankValidatorImpl;

/**
 * 
 * PatternIfNotBlank
 * 
 * @author: Aldwin Su
 * @creation: 2019-02-03 12:54:22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
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