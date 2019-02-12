package devutility.external.javax.validation.annotation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import devutility.external.javax.validation.annotation.SizeIfNotBlank;
import devutility.internal.lang.StringUtils;

public class SizeIfNotBlankValidatorImpl implements ConstraintValidator<SizeIfNotBlank, String> {
	private int min;
	private int max;

	@Override
	public void initialize(SizeIfNotBlank constraintAnnotation) {
		this.min = constraintAnnotation.min();
		this.max = constraintAnnotation.max();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isNullOrEmpty(value)) {
			return true;
		}

		if (min == 0 && max == Integer.MAX_VALUE) {
			return true;
		}

		int length = value.length();

		if (min == 0) {
			return length <= max;
		}

		if (max == Integer.MAX_VALUE) {
			return length >= min;
		}

		return length >= min && length <= max;
	}
}