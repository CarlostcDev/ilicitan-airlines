CREATE TABLE billing_data (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    reservation_id BIGINT UNSIGNED NOT NULL,
    billing_type ENUM('INDIVIDUAL', 'COMPANY') NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(100),
    company_name VARCHAR(150),
    tax_id VARCHAR(50),
    address VARCHAR(255) NOT NULL,
    city VARCHAR(100) NOT NULL,
    postal_code VARCHAR(20) NOT NULL,
    country_id BIGINT UNSIGNED NOT NULL,
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    UNIQUE KEY uq_billing_data_reservation (reservation_id),
    CONSTRAINT fk_billing_data_reservation FOREIGN KEY (reservation_id) REFERENCES reservation(id) ON DELETE CASCADE,
    CONSTRAINT fk_billing_data_country FOREIGN KEY (country_id) REFERENCES country(id),
    CONSTRAINT chk_billing_data_individual CHECK (billing_type <> 'INDIVIDUAL' OR (first_name IS NOT NULL AND last_name IS NOT NULL)),
    CONSTRAINT chk_billing_data_company CHECK (billing_type <> 'COMPANY' OR (company_name IS NOT NULL AND tax_id IS NOT NULL))
) ENGINE=InnoDB;