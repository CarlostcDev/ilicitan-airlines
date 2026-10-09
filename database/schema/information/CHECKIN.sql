CREATE TABLE checkin (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ticket_id BIGINT UNSIGNED NOT NULL,
    status ENUM('OPEN', 'COMPLETED', 'CANCELLED') NOT NULL DEFAULT 'OPEN',
    checked_in_at_utc DATETIME(6),
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    UNIQUE KEY uq_checkin_ticket (ticket_id),
    CONSTRAINT fk_checkin_ticket FOREIGN KEY (ticket_id) REFERENCES ticket(id) ON DELETE CASCADE,
    CONSTRAINT chk_checkin_completed_at CHECK ((status = 'COMPLETED' AND checked_in_at_utc IS NOT NULL) OR (status <> 'COMPLETED' AND checked_in_at_utc IS NULL))
) ENGINE=InnoDB;