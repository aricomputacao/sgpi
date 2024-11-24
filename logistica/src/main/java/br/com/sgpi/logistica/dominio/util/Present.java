package br.com.sgpi.logistica.dominio.util;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PresentValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Present {
    String message() default "A data deve ser no presente";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
