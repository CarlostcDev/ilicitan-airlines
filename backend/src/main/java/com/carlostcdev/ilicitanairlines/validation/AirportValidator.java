package com.carlostcdev.ilicitanairlines.validation;

import com.carlostcdev.ilicitanairlines.exception.IlicitanAirlinesException;

import java.math.BigDecimal;

public final class AirportValidator {
    private AirportValidator() {}

    public static boolean checkCoords(BigDecimal coords, int min, int max) {
        if (min >= max) throw new IlicitanAirlinesException("El valor mínimo debe ser menor que el máximo");
        if (coords == null) return false;
        if (coords.compareTo(BigDecimal.valueOf(min)) < 0) {
            throw new IlicitanAirlinesException("El valor no puede ser menor que " + min);
        }
        if (coords.compareTo(BigDecimal.valueOf(max)) > 0) {
            throw new IlicitanAirlinesException("El valor no puede ser mayor que " + max);
        }
        return true;
    }
}