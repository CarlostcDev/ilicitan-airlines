package com.carlostcdev.ilicitanairlines.identify.entity;

import com.carlostcdev.ilicitanairlines.identify.enums.AuthAccountProvider;
import com.carlostcdev.ilicitanairlines.validation.AuthValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "auth_account")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AuthAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserAccount userAccount;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "provider", nullable = false)
    private AuthAccountProvider provider;

    @Size(max = 255)
    @Column(name = "provider_subject", length = 255)
    private String providerSubject;

    @Size(max = 255)
    @Column(name = "password_hash", length = 255)
    private String passwordHash;

    @NotNull
    @Column(name = "created_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "updated_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public AuthAccount(UserAccount userAccount, AuthAccountProvider provider, String providerSubject, String passwordHash) {
        AuthValidator.validateAuth(provider, passwordHash);
        this.userAccount = userAccount;
        this.provider = provider;
        this.providerSubject = providerSubject;
        this.passwordHash = passwordHash;
    }
}
