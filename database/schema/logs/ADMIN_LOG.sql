CREATE TABLE admin_log (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    admin_user_id BIGINT UNSIGNED NOT NULL,
    action VARCHAR(100) NOT NULL,
    entity_type VARCHAR(100) NOT NULL,
    entity_id BIGINT UNSIGNED,
    details JSON,
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    KEY idx_admin_audit_user_created (admin_user_id, created_at),
    KEY idx_admin_audit_entity (entity_type, entity_id),
    CONSTRAINT fk_admin_audit_user FOREIGN KEY (admin_user_id) REFERENCES user_account(id)
) ENGINE=InnoDB;