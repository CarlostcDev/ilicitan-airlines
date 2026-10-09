CREATE TABLE flight_fare (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    flight_id BIGINT UNSIGNED NOT NULL,
    cabin_class_id BIGINT UNSIGNED NOT NULL,
    fare_code VARCHAR(30) NOT NULL,
    base_price DECIMAL(10,2) UNSIGNED NOT NULL,
    currency CHAR(3) NOT NULL,
    baggage_allowance_kg DECIMAL(5,2) UNSIGNED NOT NULL DEFAULT 0,
    refundable BOOLEAN NOT NULL DEFAULT FALSE,
    changeable BOOLEAN NOT NULL DEFAULT FALSE,
    UNIQUE KEY uq_flight_fare (flight_id, fare_code),
    CONSTRAINT fk_flight_fare_flight FOREIGN KEY (flight_id) REFERENCES flight(id) ON DELETE CASCADE,
    CONSTRAINT fk_flight_fare_cabin_class FOREIGN KEY (cabin_class_id) REFERENCES cabin_class(id)
) ENGINE=InnoDB;