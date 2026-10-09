CREATE TABLE airport (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    city_id BIGINT UNSIGNED NOT NULL,
    name VARCHAR(150) NOT NULL,
    iata_code CHAR(3) NOT NULL,
    timezone VARCHAR(64) NOT NULL,
    latitude DECIMAL(10,7),
    longitude DECIMAL(10,7),
    status ENUM('ACTIVE', 'INACTIVE') NOT NULL DEFAULT 'ACTIVE',
    UNIQUE KEY uq_airport_iata_code (iata_code),
    CONSTRAINT fk_airport_city FOREIGN KEY (city_id) REFERENCES city(id),
    CONSTRAINT chk_airport_latitude CHECK (latitude IS NULL OR latitude BETWEEN -90 AND 90),
    CONSTRAINT chk_airport_longitude CHECK (longitude IS NULL OR longitude BETWEEN -180 AND 180)
) ENGINE=InnoDB;