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

import devutility.external.javax.validation.annotation.impl.SizeIfNotBlankValidatorImpl;

/**
 * 
 * SizeIfNotBlank
 * 
 * @author: Aldwin Su
 * @creation: 2019-02-08 11:54:00
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Constraint(validatedBy = { SizeIfNotBlankValidatorImpl.class })
public @interface SizeIfNotBlank {
	/**
	 * @return size the element must be higher or equal to
	 */
	int min() default 0;

	/**
	 * @return size the element must be lower or equal to
	 */
	int max() default Integer.MAX_VALUE;

	/**
	 * @return the error message template
	 */
	String message() default "{devutility.external.javax.validation.annotation.SizeIfNotNull.message}";

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