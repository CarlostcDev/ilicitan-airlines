CREATE TABLE reservation_passenger (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    reservation_id BIGINT UNSIGNED NOT NULL,
    passenger_number TINYINT UNSIGNED NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    gender ENUM('MALE', 'FEMALE', 'UNSPECIFIED') NOT NULL,
    nationality_country VARCHAR(50) NOT NULL,
    document_type ENUM('PASSPORT', 'ID_CARD', 'OTHER') NOT NULL,
    document_number VARCHAR(50) NOT NULL,
    email VARCHAR(255),
    phone VARCHAR(30),
    UNIQUE KEY uq_reservation_passenger_number (reservation_id, passenger_number),
    CONSTRAINT fk_reservation_passenger_reservation FOREIGN KEY (reservation_id) REFERENCES reservation(id) ON DELETE CASCADE,
    CONSTRAINT chk_reservation_passenger_number CHECK (passenger_number > 0)
) ENGINE=InnoDB;