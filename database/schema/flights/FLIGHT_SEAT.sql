CREATE TABLE flight_seat (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    flight_id BIGINT UNSIGNED NOT NULL,
    seat_id BIGINT UNSIGNED NOT NULL,
    status ENUM('AVAILABLE', 'BLOCKED') NOT NULL DEFAULT 'AVAILABLE',
    extra_price DECIMAL(10,2) UNSIGNED NOT NULL DEFAULT 0,
    UNIQUE KEY uq_flight_seat (flight_id, seat_id),
    CONSTRAINT fk_flight_seat_flight FOREIGN KEY (flight_id) REFERENCES flight(id) ON DELETE CASCADE,
    CONSTRAINT fk_flight_seat_seat FOREIGN KEY (seat_id) REFERENCES seat(id)
) ENGINE=InnoDB;