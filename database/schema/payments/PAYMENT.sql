CREATE TABLE payment (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    reservation_id BIGINT UNSIGNED NOT NULL,
    method ENUM('CARD', 'PAYPAL', 'BANK_TRANSFER', 'OTHER') NOT NULL,
    provider VARCHAR(50),
    transaction_reference VARCHAR(255) NOT NULL,
    amount DECIMAL(10,2) UNSIGNED NOT NULL,
    currency CHAR(3) NOT NULL,
    status ENUM('PENDING', 'AUTHORIZED', 'COMPLETED', 'FAILED', 'REFUNDED') NOT NULL DEFAULT 'PENDING',
    paid_at_utc DATETIME(6),
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    UNIQUE KEY uq_payment_transaction_reference (transaction_reference),
    KEY idx_payment_reservation (reservation_id),
    CONSTRAINT fk_payment_reservation FOREIGN KEY (reservation_id) REFERENCES reservation(id) ON DELETE CASCADE
) ENGINE=InnoDB;