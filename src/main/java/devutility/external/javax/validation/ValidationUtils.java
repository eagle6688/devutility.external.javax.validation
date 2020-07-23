package devutility.external.javax.validation;

import java.lang.reflect.Constructor;
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

	/**
	 * Validates all constraints placed on the parameters of the given method.
	 * @param <T> the type hosting the method to validate
	 * @param object the object on which the method to validate is invoked
	 * @param method the method for which the parameter constraints is validated
	 * @param parameterValues the values provided by the caller for the given method's parameters
	 * @param groups the group or list of groups targeted for validation
	 * @return ValidationResult
	 */
	public static <T> ValidationResult validateParameters(T object, Method method, Object[] parameterValues, Class<?>... groups) {
		Set<ConstraintViolation<T>> violations = executableValidator.validateParameters(object, method, parameterValues, groups);
		return ValidationResult.build(violations);
	}

	/**
	 * Validates all return value constraints of the given method.
	 * @param <T> the type hosting the method to validate
	 * @param object the object on which the method to validate is invoked
	 * @param method the method for which the return value constraints is validated
	 * @param returnValue the value returned by the given method
	 * @param groups the group or list of groups targeted for validation
	 * @return ValidationResult
	 */
	public static <T> ValidationResult validateReturnValue(T object, Method method, Object returnValue, Class<?>... groups) {
		Set<ConstraintViolation<T>> violations = executableValidator.validateReturnValue(object, method, returnValue, groups);
		return ValidationResult.build(violations);
	}

	/**
	 * Validates all constraints placed on the parameters of the given constructor.
	 * @param <T> the type hosting the constructor to validate
	 * @param constructor the constructor for which the parameter constraints is validated
	 * @param parameterValues the values provided by the caller for the given constructor's parameters
	 * @param groups the group or list of groups targeted for validation
	 * @return ValidationResult
	 */
	public static <T> ValidationResult validateConstructorParameters(Constructor<? extends T> constructor, Object[] parameterValues, Class<?>... groups) {
		Set<ConstraintViolation<T>> violations = executableValidator.validateConstructorParameters(constructor, parameterValues, groups);
		return ValidationResult.build(violations);
	}

	/**
	 * Validates all return value constraints of the given constructor.
	 * @param <T> the type hosting the constructor to validate.
	 * @param constructor the constructor for which the return value constraints is validated
	 * @param createdObject the object instantiated by the given method
	 * @param groups the group or list of groups targeted for validation
	 * @return ValidationResult
	 */
	public static <T> ValidationResult validateConstructorReturnValue(Constructor<? extends T> constructor, T createdObject, Class<?>... groups) {
		Set<ConstraintViolation<T>> violations = executableValidator.validateConstructorReturnValue(constructor, createdObject, groups);
		return ValidationResult.build(violations);
	}
}