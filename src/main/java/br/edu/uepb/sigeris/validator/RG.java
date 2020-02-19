package br.edu.uepb.sigeris.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "^$|[a-zA-Z\\d/.-]{1,}")
public @interface RG {

	@OverridesAttribute(constraint = Pattern.class, name = "message")
	String message() default "Apenas letras números ou os caracteres a seguir são aceitos para o RG: / . -";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
