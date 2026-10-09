CREATE TABLE auth_account (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT UNSIGNED NOT NULL,
    provider ENUM('EMAIL', 'GOOGLE', 'APPLE') NOT NULL,
    provider_subject VARCHAR(255),
    password_hash VARCHAR(255),
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    UNIQUE KEY uq_auth_provider_subject (provider, provider_subject),
    CONSTRAINT fk_auth_account_user
      FOREIGN KEY (user_id) REFERENCES user_account(id) ON DELETE CASCADE,
    CONSTRAINT chk_auth_account_credentials
      CHECK (
          (provider = 'EMAIL' AND password_hash IS NOT NULL)
              OR
          (provider IN ('GOOGLE', 'APPLE') AND password_hash IS NULL)
          )
) ENGINE=InnoDB;