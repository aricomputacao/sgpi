package br.com.sgpi.logistica.dominio.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PresentValidator implements ConstraintValidator<Present, LocalDateTime> {
    @Override
    public boolean isValid(LocalDateTime value, ConstraintValidatorContext context) {
        return comDiferencaDeCincoMinutos(value);
    }

    private static boolean comDiferencaDeCincoMinutos(LocalDateTime value) {
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        value = value.truncatedTo(ChronoUnit.SECONDS);

        long differenceInMinutes = Math.abs(ChronoUnit.MINUTES.between(value, now));
        return differenceInMinutes <= 5;
    }
}

