CREATE TABLE seat (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    aircraft_id BIGINT UNSIGNED NOT NULL,
    cabin_class_id BIGINT UNSIGNED NOT NULL,
    seat_row SMALLINT UNSIGNED NOT NULL,
    seat_letter CHAR(1) NOT NULL,
    seat_number VARCHAR(10) AS (CONCAT(seat_row, seat_letter)) VIRTUAL,
    UNIQUE KEY uq_seat_aircraft_number (aircraft_id, seat_number),
    UNIQUE KEY uq_seat_aircraft_position (aircraft_id, seat_row, seat_letter),
    CONSTRAINT fk_seat_aircraft FOREIGN KEY (aircraft_id) REFERENCES aircraft(id),
    CONSTRAINT fk_seat_cabin_class FOREIGN KEY (cabin_class_id) REFERENCES cabin_class(id),
    CONSTRAINT chk_seat_row CHECK (seat_row > 0),
    CONSTRAINT chk_seat_letter CHECK (seat_letter REGEXP '^[A-Z]$')
) ENGINE=InnoDB;