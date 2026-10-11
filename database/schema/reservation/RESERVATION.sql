CREATE TABLE reservation (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT UNSIGNED,
    booking_reference CHAR(6) NOT NULL,
    status ENUM( 'PENDING', 'CONFIRMED','CANCELLED','COMPLETED') NOT NULL DEFAULT 'PENDING',
    contact_email VARCHAR(255) NOT NULL,
    contact_phone VARCHAR(30),
    total_amount DECIMAL(10,2) UNSIGNED NOT NULL DEFAULT 0,
    currency CHAR(3) NOT NULL,
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    UNIQUE KEY uq_reservation_booking_reference (booking_reference),
    KEY idx_reservation_user (user_id),
    CONSTRAINT fk_reservation_user FOREIGN KEY (user_id) REFERENCES user_account(id) ON DELETE SET NULL
) ENGINE=InnoDB;