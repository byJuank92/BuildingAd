package main.java.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//@Target({METHOD, FIELD, ANNOTATION_TYPE, TYPE})
//@Retention(RUNTIME)
@Constraint(validatedBy = AdvertisementValidatorImpl.class)
public @interface AdvertisementValidator {
	
	Class<?>[] groups() default{};
	String message() default " ";
	Class<? extends Payload>[] playload() default{};
}
