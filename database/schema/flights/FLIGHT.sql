CREATE TABLE flight (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    flight_number VARCHAR(6) NOT NULL,
    origin_airport_id BIGINT UNSIGNED NOT NULL,
    destination_airport_id BIGINT UNSIGNED NOT NULL,
    aircraft_id BIGINT UNSIGNED NOT NULL,
    scheduled_departure_utc DATETIME(0) NOT NULL,
    scheduled_arrival_utc DATETIME(0) NOT NULL,
    estimated_departure_utc DATETIME(0),
    estimated_arrival_utc DATETIME(0),
    status ENUM('SCHEDULED','BOARDING','DEPARTED','ARRIVED','DELAYED','CANCELLED'
    ) NOT NULL DEFAULT 'SCHEDULED',
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    UNIQUE KEY uq_flight_number_departure (flight_number, scheduled_departure_utc),
    KEY idx_flight_origin_departure (origin_airport_id, scheduled_departure_utc),
    KEY idx_flight_destination_arrival (destination_airport_id, scheduled_arrival_utc),
    CONSTRAINT fk_flight_origin_airport FOREIGN KEY (origin_airport_id) REFERENCES airport(id),
    CONSTRAINT fk_flight_destination_airport FOREIGN KEY (destination_airport_id) REFERENCES airport(id),
    CONSTRAINT fk_flight_aircraft FOREIGN KEY (aircraft_id) REFERENCES aircraft(id),
    CONSTRAINT chk_flight_airports CHECK (origin_airport_id <> destination_airport_id),
    CONSTRAINT chk_flight_schedule CHECK (scheduled_arrival_utc > scheduled_departure_utc)
) ENGINE=InnoDB;