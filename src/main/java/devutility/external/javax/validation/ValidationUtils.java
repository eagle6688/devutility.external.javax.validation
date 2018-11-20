package devutility.external.javax.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import devutility.external.javax.validation.model.ValidationResult;
import devutility.internal.util.CollectionUtils;

public class ValidationUtils {
	/**
	 * Default validator factory.
	 */
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	/**
	 * Validate model.
	 * @param model: Model object.
	 * @return ValidationResult
	 */
	public static <T> ValidationResult validate(T model) {
		ValidationResult result = new ValidationResult();
		Set<ConstraintViolation<T>> set = validator.validate(model, Default.class);

		if (CollectionUtils.isNotEmpty(set)) {
			result.setFailed(true);

			for (ConstraintViolation<T> cv : set) {
				result.put(cv.getPropertyPath().toString(), cv.getMessage());
			}
		}

		return result;
	}
}