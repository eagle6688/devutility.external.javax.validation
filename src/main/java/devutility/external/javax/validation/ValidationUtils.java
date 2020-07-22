package devutility.external.javax.validation;

import java.lang.reflect.Method;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import javax.validation.groups.Default;

import devutility.external.javax.validation.model.ValidationResult;

/**
 * 
 * ValidationUtils
 * 
 * @author: Aldwin Su
 * @creation: 2018-11-19 23:28:10
 */
public class ValidationUtils {
	/**
	 * Default ValidatorFactory object.
	 */
	private static final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

	/**
	 * Default Validator object.
	 */
	private static final Validator validator = validatorFactory.getValidator();

	/**
	 * Default ExecutableValidator object
	 */
	private static final ExecutableValidator executableValidator = validator.forExecutables();

	/**
	 * Validate Java bean.
	 * @param bean Java bean object.
	 * @return ValidationResult
	 */
	public static <T> ValidationResult validate(T bean) {
		Set<ConstraintViolation<T>> violations = validator.validate(bean, Default.class);
		return ValidationResult.build(violations);
	}

	public static <T> ValidationResult validateParameters(T object, Method method, Object[] parameterValues, Class<?>... groups) {
		Set<ConstraintViolation<T>> violations = executableValidator.validateParameters(object, method, parameterValues, groups);
		return ValidationResult.build(violations);
	}
}