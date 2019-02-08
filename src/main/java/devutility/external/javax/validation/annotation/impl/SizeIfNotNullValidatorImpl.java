package devutility.external.javax.validation.annotation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import devutility.external.javax.validation.annotation.SizeIfNotNull;

public class SizeIfNotNullValidatorImpl implements ConstraintValidator<SizeIfNotNull, String> {
	private int min;
	private int max;

	@Override
	public void initialize(SizeIfNotNull constraintAnnotation) {
		this.min = constraintAnnotation.min();
		this.max = constraintAnnotation.max();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
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