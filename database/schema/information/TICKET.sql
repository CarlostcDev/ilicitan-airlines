CREATE TABLE ticket (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    reservation_flight_id BIGINT UNSIGNED NOT NULL,
    reservation_passenger_id BIGINT UNSIGNED NOT NULL,
    flight_seat_id BIGINT UNSIGNED,
    ticket_number CHAR(13) NOT NULL,
    status ENUM('PENDING','CONFIRMED','CHECKED_IN','BOARDED','CANCELLED') NOT NULL DEFAULT 'PENDING',
    base_fare DECIMAL(10,2) UNSIGNED NOT NULL DEFAULT 0,
    taxes DECIMAL(10,2) UNSIGNED NOT NULL DEFAULT 0,
    total_amount DECIMAL(10,2) UNSIGNED NOT NULL DEFAULT 0,
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    UNIQUE KEY uq_ticket_number (ticket_number),
    UNIQUE KEY uq_ticket_passenger_segment (reservation_flight_id, reservation_passenger_id),
    CONSTRAINT fk_ticket_reservation_flight FOREIGN KEY (reservation_flight_id) REFERENCES reservation_flight(id) ON DELETE CASCADE,
    CONSTRAINT fk_ticket_reservation_passenger FOREIGN KEY (reservation_passenger_id) REFERENCES reservation_passenger(id) ON DELETE CASCADE,
    CONSTRAINT fk_ticket_flight_seat FOREIGN KEY (flight_seat_id) REFERENCES flight_seat(id)
) ENGINE=InnoDB;