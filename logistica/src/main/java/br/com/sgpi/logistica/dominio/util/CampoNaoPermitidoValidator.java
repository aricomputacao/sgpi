package br.com.sgpi.logistica.dominio.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CampoNaoPermitidoValidator implements ConstraintValidator<CampoNaoPermitido, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return value == null; // O valor deve ser sempre nulo
    }
}

