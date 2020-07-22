package devutility.external.javax.validation.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;

import devutility.internal.lang.StringUtils;
import devutility.internal.util.CollectionUtils;

/**
 * 
 * ValidationResult
 * 
 * @author: Aldwin Su
 * @creation: 2018-11-19 23:28:10
 */
public class ValidationResult {
	private boolean failed;
	private Map<String, String> errorMessages = new LinkedHashMap<>();

	public static <T> ValidationResult build(Set<ConstraintViolation<T>> violations) {
		ValidationResult result = new ValidationResult();

		if (CollectionUtils.isNotEmpty(violations)) {
			result.setFailed(true);

			for (ConstraintViolation<T> violation : violations) {
				result.put(violation.getPropertyPath().toString(), violation.getMessage());
			}
		}

		return result;
	}

	public boolean isFailed() {
		return failed;
	}

	public void setFailed(boolean failed) {
		this.failed = failed;
	}

	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public String put(String key, String error) {
		return this.errorMessages.put(key, error);
	}

	public String getFirstErrorMessage() {
		for (Map.Entry<String, String> entry : errorMessages.entrySet()) {
			if (StringUtils.isNotEmpty(entry.getValue())) {
				return entry.getValue();
			}
		}

		return null;
	}
}