package devutility.external.javax.validation.annotation.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import devutility.external.javax.validation.annotation.PatternIfNotBlank;
import devutility.internal.lang.StringUtils;

public class PatternIfNotBlankValidatorImpl implements ConstraintValidator<PatternIfNotBlank, String> {
	private String regexp;

	@Override
	public void initialize(PatternIfNotBlank constraintAnnotation) {
		this.regexp = constraintAnnotation.regexp();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isNullOrEmpty(value)) {
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