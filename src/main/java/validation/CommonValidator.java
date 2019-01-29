package main.java.validation;

import javax.validation.ConstraintValidatorContext;

public class CommonValidator {
	public void addError(ConstraintValidatorContext context, String source, String messageCode) {
		context.buildConstraintViolationWithTemplate("{" + messageCode + "}").addNode(source).addConstraintViolation();
	}
}
