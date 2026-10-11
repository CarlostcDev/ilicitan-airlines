CREATE TABLE baggage (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ticket_id BIGINT UNSIGNED NOT NULL,
    baggage_option_id BIGINT UNSIGNED NOT NULL,
    quantity TINYINT UNSIGNED NOT NULL DEFAULT 1,
    weight_kg DECIMAL(5,2) UNSIGNED NOT NULL,
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    CONSTRAINT fk_baggage_ticket FOREIGN KEY (ticket_id) REFERENCES ticket(id) ON DELETE CASCADE,
    CONSTRAINT fk_baggage_option FOREIGN KEY (baggage_option_id) REFERENCES baggage_option(id),
    CONSTRAINT chk_baggage_quantity CHECK (quantity > 0),
    CONSTRAINT chk_baggage_weight CHECK (weight_kg > 0)
) ENGINE=InnoDB;