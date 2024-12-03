package br.com.sgpi.pedido.dominio.util.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CampoNaoPermitidoValidator implements ConstraintValidator<CampoNaoPermitido, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return value == null; // O valor deve ser sempre nulo
    }
}

