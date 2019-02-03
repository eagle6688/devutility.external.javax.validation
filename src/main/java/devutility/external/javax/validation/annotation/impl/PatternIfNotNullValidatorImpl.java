package devutility.external.javax.validation.annotation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import devutility.external.javax.validation.annotation.PatternIfNotNull;

public class PatternIfNotNullValidatorImpl implements ConstraintValidator<PatternIfNotNull, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return false;
	}
}