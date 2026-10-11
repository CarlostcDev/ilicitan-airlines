package com.carlostcdev.ilicitanairlines.information.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "boarding_pass")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardingPass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "checkin_id", nullable = false, unique = true)
    private Checkin checkin;

    @NotBlank
    @Size(max = 255)
    @Column(name = "qr_token", nullable = false, unique = true)
    private String qrToken;

    @Pattern(regexp = "[A-Z0-9 ]{2,20}")
    @Column(name = "terminal", length = 20)
    private String terminal;

    @Pattern(regexp = "[A-Z0-9 ]{2,20}")
    @Column(name = "gate", length = 20)
    private String gate;

    @Pattern(regexp = "[A-Z0-9 ]{1,20}")
    @Column(name = "boarding_group", length = 20)
    private String boardingGroup;

    @Pattern(regexp = "[A-Z0-9 ]{1,20}")
    @Column(name = "boarding_zone", length = 20)
    private String boardingZone;

    @Column(name = "issued_at_utc", insertable = false, updatable = false, nullable = false)
    private LocalDateTime issuedAt;

    @Builder
    public BoardingPass(Checkin checkin, String qrToken, String terminal, String gate, String boardingGroup, String boardingZone) {
        this.checkin = checkin;
        this.qrToken = qrToken;
        this.terminal = terminal;
        this.gate = gate;
        this.boardingGroup = boardingGroup;
        this.boardingZone = boardingZone;
    }
}
