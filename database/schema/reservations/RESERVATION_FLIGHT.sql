CREATE TABLE reservation_flight (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    reservation_id BIGINT UNSIGNED NOT NULL,
    flight_id BIGINT UNSIGNED NOT NULL,
    flight_fare_id BIGINT UNSIGNED NOT NULL,
    segment_number TINYINT UNSIGNED NOT NULL,
    status ENUM( 'PENDING', 'CONFIRMED', 'CANCELLED','COMPLETED') NOT NULL DEFAULT 'PENDING',
    price_amount DECIMAL(10,2) UNSIGNED NOT NULL,
    UNIQUE KEY uq_reservation_flight_segment (reservation_id, segment_number),
    UNIQUE KEY uq_reservation_flight (reservation_id, flight_id),
    CONSTRAINT fk_reservation_flight_reservation FOREIGN KEY (reservation_id) REFERENCES reservation(id) ON DELETE CASCADE,
    CONSTRAINT fk_reservation_flight_flight FOREIGN KEY (flight_id) REFERENCES flight(id),
    CONSTRAINT fk_reservation_flight_fare FOREIGN KEY (flight_fare_id) REFERENCES flight_fare(id)
) ENGINE=InnoDB;