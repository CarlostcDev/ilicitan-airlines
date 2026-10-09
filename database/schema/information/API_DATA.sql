CREATE TABLE api_data (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ticket_id BIGINT UNSIGNED NOT NULL,
    document_type ENUM('PASSPORT', 'ID_CARD', 'OTHER') NOT NULL,
    document_number VARCHAR(50) NOT NULL,
    issuing_country_id BIGINT UNSIGNED NOT NULL,
    nationality_country_id BIGINT UNSIGNED NOT NULL,
    document_expiry_date DATE NOT NULL,
    date_of_birth DATE NOT NULL,
    gender ENUM('MALE', 'FEMALE', 'UNSPECIFIED') NOT NULL,
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    UNIQUE KEY uq_api_data_ticket (ticket_id),
    CONSTRAINT fk_api_data_ticket FOREIGN KEY (ticket_id) REFERENCES ticket(id) ON DELETE CASCADE,
    CONSTRAINT fk_api_data_issuing_country FOREIGN KEY (issuing_country_id) REFERENCES country(id),
    CONSTRAINT fk_api_data_nationality_country FOREIGN KEY (nationality_country_id) REFERENCES country(id)
) ENGINE=InnoDB;