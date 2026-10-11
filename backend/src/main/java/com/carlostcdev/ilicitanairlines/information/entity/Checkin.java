package com.carlostcdev.ilicitanairlines.information.entity;

import com.carlostcdev.ilicitanairlines.global.validation.CheckinValidator;
import com.carlostcdev.ilicitanairlines.information.enums.CheckinStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "checkin")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Checkin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ticket_id", nullable = false, unique = true)
    private Ticket ticket;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CheckinStatus status;

    @Column(name = "checked_in_at_utc")
    private LocalDateTime checkedIn;

    @NotNull
    @Column(name = "created_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "updated_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public Checkin(Ticket ticket, CheckinStatus status, LocalDateTime checkedIn) {
        this.ticket = ticket;
        this.status = status != null ? status : CheckinStatus.INACTIVE;
        this.checkedIn = checkedIn;
        CheckinValidator.validateCheckin(this.status, this.checkedIn);
    }
}
