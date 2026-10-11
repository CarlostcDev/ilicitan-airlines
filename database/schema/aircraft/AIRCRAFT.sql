CREATE TABLE aircraft (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    aircraft_model_id BIGINT UNSIGNED NOT NULL,
    registration VARCHAR(20) NOT NULL,
    serial_number VARCHAR(50),
    status ENUM('ACTIVE', 'MAINTENANCE', 'INACTIVE') NOT NULL DEFAULT 'INACTIVE',
    UNIQUE KEY uq_aircraft_registration (registration),
    UNIQUE KEY uq_aircraft_serial_number (serial_number),
    CONSTRAINT fk_aircraft_model FOREIGN KEY (aircraft_model_id) REFERENCES aircraft_model(id)
) ENGINE=InnoDB;