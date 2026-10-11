package com.carlostcdev.ilicitanairlines.logging.entity;

import com.carlostcdev.ilicitanairlines.identify.entity.UserAccount;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "admin_log")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AdminLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "admin_user_id", nullable = false)
    private UserAccount adminUser;

    @NotBlank
    @Size(max = 100)
    @Column(name = "action", nullable = false, length = 100)
    private String action;

    @NotBlank
    @Size(max = 100)
    @Column(name = "entity_type", nullable = false, length = 100)
    private String entityType;

    @PositiveOrZero
    @Column(name = "entity_id")
    private Long entityId;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "details", columnDefinition = "JSON")
    private JsonNode details;

    @Column(name = "created_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Builder
    public AdminLog(UserAccount adminUser, String action, String entityType, Long entityId, JsonNode details) {
        this.adminUser = adminUser;
        this.action = action;
        this.entityType = entityType;
        this.entityId = entityId;
        this.details = details;
    }
}
