package devutility.external.javax.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
public @interface PatternIfNotNull {
	/**
	 * @return the regular expression to match
	 */
	String regexp();

	/**
	 * @return the error message template
	 */
	String message() default "{devutility.external.javax.validation.annotation.PatternIfNotNull.message}";
}