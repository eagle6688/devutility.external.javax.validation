package devutility.external.javax.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import devutility.external.javax.validation.model.ValidationResult;
import devutility.internal.util.CollectionUtils;

/**
 * 
 * ValidationUtils
 * 
 * @author: Aldwin Su
 * @creation: 2018-11-19 23:28:10
 */
public class ValidationUtils {
	/**
	 * Default validator factory.
	 */
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	/**
	 * Validate Java bean.
	 * @param bean Java bean object.
	 * @return ValidationResult
	 */
	public static <T> ValidationResult validate(T bean) {
		ValidationResult result = new ValidationResult();
		Set<ConstraintViolation<T>> violations = validator.validate(bean, Default.class);

		if (CollectionUtils.isNotEmpty(violations)) {
			result.setFailed(true);

			for (ConstraintViolation<T> violation : violations) {
				result.put(violation.getPropertyPath().toString(), violation.getMessage());
			}
		}

		return result;
	}
}