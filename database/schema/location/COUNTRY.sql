CREATE TABLE country (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    iso_code CHAR(2) NOT NULL,
    name VARCHAR(100) NOT NULL,
    UNIQUE KEY uq_country_iso_code (iso_code),
    UNIQUE KEY uq_country_name (name)
) ENGINE=InnoDB;