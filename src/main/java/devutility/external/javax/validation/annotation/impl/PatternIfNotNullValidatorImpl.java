package devutility.external.javax.validation.annotation.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import devutility.external.javax.validation.annotation.PatternIfNotNull;
import devutility.internal.lang.StringUtils;

public class PatternIfNotNullValidatorImpl implements ConstraintValidator<PatternIfNotNull, String> {
	private String regexp;

	@Override
	public void initialize(PatternIfNotNull constraintAnnotation) {
		this.regexp = constraintAnnotation.regexp();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}

		if (StringUtils.isNullOrEmpty(regexp)) {
			return true;
		}

		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}
}