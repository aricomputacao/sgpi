package br.com.sgpi.logistica.dominio.util.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CampoNaoPermitidoValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CampoNaoPermitido {
    String message() default "Este campo não é permitido na requisição.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
