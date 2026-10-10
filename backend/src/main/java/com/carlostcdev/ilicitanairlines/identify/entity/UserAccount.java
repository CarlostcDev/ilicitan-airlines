package com.carlostcdev.ilicitanairlines.identify.entity;

import com.carlostcdev.ilicitanairlines.identify.enums.UserAccountStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "user_account")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @NotBlank
    @Size(max = 50)
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @NotBlank
    @Size(max = 100)
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Email
    @NotBlank
    @Size(max = 255)
    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Pattern(regexp = "^\\+?[0-9 ()-]{7,30}$")
    @Column(name = "phone", length = 30)
    private String phone;

    @URL
    @NotBlank
    @Size(max = 500)
    @Column(name = "profile_photo_url", nullable = false, length = 500)
    private String profilePhotoUrl;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private UserAccountStatus status;

    @NotNull
    @Column(name = "created_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "updated_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime updatedAt;

    @Builder
    public UserAccount(Role role, String firstName, String lastName, String email,
                       String phone, String profilePhotoUrl, UserAccountStatus status) {
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.profilePhotoUrl = profilePhotoUrl;
        this.status = status != null ? status : UserAccountStatus.SUSPENDED;
    }
}
