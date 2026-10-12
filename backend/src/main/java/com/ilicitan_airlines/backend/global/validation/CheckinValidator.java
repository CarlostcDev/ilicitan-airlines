package com.ilicitan_airlines.backend.global.validation;

import com.ilicitan_airlines.backend.global.exception.IlicitanAirlinesException;
import com.ilicitan_airlines.backend.information.enums.CheckinStatus;
import java.time.LocalDateTime;

public final class CheckinValidator {
    private CheckinValidator() {}

    public static void validateCheckin(CheckinStatus status, LocalDateTime checkedInAtUtc) {
        if (status == CheckinStatus.COMPLETED && checkedInAtUtc == null) {
            throw new IlicitanAirlinesException("Un check-in completado debe tener fecha de realización");
        }

        if (status != CheckinStatus.COMPLETED && checkedInAtUtc != null) {
            throw new IlicitanAirlinesException("Un check-in no completado no puede tener fecha de realización");
        }
    }
}
