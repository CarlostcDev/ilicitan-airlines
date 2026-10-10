package com.carlostcdev.ilicitanairlines.validation;

import com.carlostcdev.ilicitanairlines.exception.IlicitanAirlinesException;

public final class BuilderValidator {
    private BuilderValidator() {}

    public static <T> T validateNull(T valor) {
        if (valor == null) {
            throw new IlicitanAirlinesException("El valor no puede ser null");
        } else {
            return valor;
        }
    }
}
