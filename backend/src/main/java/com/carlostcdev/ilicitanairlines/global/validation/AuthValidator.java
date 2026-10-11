package com.carlostcdev.ilicitanairlines.global.validation;

import com.carlostcdev.ilicitanairlines.identify.enums.AuthAccountProvider;

public final class AuthValidator {
    private AuthValidator() {}

    public static void validateAuth(AuthAccountProvider provider, String passwordHash) {
        if (provider == null) {
            throw new IllegalArgumentException("El proveedor de autenticación no puede ser null");
        }

        if (provider == AuthAccountProvider.EMAIL && passwordHash == null) {
            throw new IllegalArgumentException("EMAIL requiere una contraseña hasheada");
        }

        if ((provider == AuthAccountProvider.GOOGLE || provider == AuthAccountProvider.APPLE)
                && passwordHash != null) {
            throw new IllegalArgumentException("Los proveedores externos no deben tener contraseña local");
        }
    }
}
