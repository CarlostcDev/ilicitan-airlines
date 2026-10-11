package com.carlostcdev.ilicitanairlines.global.validation;

import com.carlostcdev.ilicitanairlines.global.exception.IlicitanAirlinesException;
import com.carlostcdev.ilicitanairlines.identify.enums.AuthAccountProvider;

public final class AuthValidator {
    private AuthValidator() {}

    public static void validateAuth(AuthAccountProvider provider, String passwordHash) {
        if (provider == null) {
            throw new IlicitanAirlinesException("El proveedor de autenticación no puede ser null");
        }

        if (provider == AuthAccountProvider.EMAIL && passwordHash == null) {
            throw new IlicitanAirlinesException("EMAIL requiere una contraseña hasheada");
        }

        if ((provider == AuthAccountProvider.GOOGLE || provider == AuthAccountProvider.APPLE)
                && passwordHash != null) {
            throw new IlicitanAirlinesException("Los proveedores externos no deben tener contraseña local");
        }
    }
}
