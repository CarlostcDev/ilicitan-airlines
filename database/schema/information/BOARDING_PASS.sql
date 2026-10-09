CREATE TABLE boarding_pass (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    checkin_id BIGINT UNSIGNED NOT NULL,
    qr_token VARCHAR(255) NOT NULL,
    terminal VARCHAR(20),
    gate VARCHAR(20),
    boarding_group VARCHAR(20),
    boarding_zone VARCHAR(20),
    issued_at_utc DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    UNIQUE KEY uq_boarding_pass_checkin (checkin_id),
    UNIQUE KEY uq_boarding_pass_qr_token (qr_token),
    CONSTRAINT fk_boarding_pass_checkin FOREIGN KEY (checkin_id) REFERENCES checkin(id) ON DELETE CASCADE
) ENGINE=InnoDB;