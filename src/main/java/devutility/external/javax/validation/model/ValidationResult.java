package devutility.external.javax.validation.model;

import java.util.LinkedHashMap;
import java.util.Map;

import devutility.internal.lang.StringUtils;

public class ValidationResult {
	private boolean failed;
	private Map<String, String> errorMessages = new LinkedHashMap<>();

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