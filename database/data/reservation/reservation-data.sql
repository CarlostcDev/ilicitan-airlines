INSERT INTO reservation (id, user_id, booking_reference, status, contact_email, contact_phone, total_amount, currency) VALUES
(1, 1, 'IL7K2A', 'CONFIRMED', 'sofia.martin@example.com', '+34600111222', 1739.96, 'EUR'),
(2, 2, 'IL8M3Q', 'CONFIRMED', 'daniel.lopez@example.com', '+34600222333', 1169.98, 'EUR'),
(3, 3, 'IL9P4R', 'PENDING', 'emma.wilson@example.com', '+34600333444', 709.99, 'EUR'),
(4, NULL, 'IL2X6B', 'CANCELLED', 'liam.taylor@example.com', '+34600444555', 859.98, 'EUR'),
(5, 5, 'IL5N8C', 'CONFIRMED', 'olivia.garcia@example.com', '+34600555666', 2609.94, 'EUR');

INSERT INTO reservation_passenger (id, reservation_id, passenger_number, first_name, last_name, birth_date, gender, nationality_country, document_type, document_number, email, phone) VALUES
(1, 1, 1, 'Sofia', 'Martin', '1995-04-12', 'FEMALE', 'Spain', 'PASSPORT', 'TESTSP001', 'sofia.martin@example.com', '+34600111222'),
(2, 1, 2, 'Daniel', 'Martin', '1992-09-25', 'MALE', 'Spain', 'PASSPORT', 'TESTSP002', 'daniel.martin@example.com', '+34600111223'),
(3, 2, 1, 'Daniel', 'Lopez', '1988-02-18', 'MALE', 'Spain', 'ID_CARD', 'TESTSP003', 'daniel.lopez@example.com', '+34600222333'),
(4, 3, 1, 'Emma', 'Wilson', '1999-07-05', 'FEMALE', 'United Kingdom', 'PASSPORT', 'TESTUK001', 'emma.wilson@example.com', '+34600333444'),
(5, 4, 1, 'Liam', 'Taylor', '1990-11-21', 'MALE', 'United Kingdom', 'PASSPORT', 'TESTUK002', 'liam.taylor@example.com', '+34600444555'),
(6, 5, 1, 'Olivia', 'Garcia', '1987-06-14', 'FEMALE', 'Spain', 'PASSPORT', 'TESTSP004', 'olivia.garcia@example.com', '+34600555666'),
(7, 5, 2, 'Lucas', 'Garcia', '1985-03-09', 'MALE', 'Spain', 'PASSPORT', 'TESTSP005', 'lucas.garcia@example.com', '+34600555667'),
(8, 5, 3, 'Noa', 'Garcia', '2015-12-02', 'UNSPECIFIED', 'Spain', 'PASSPORT', 'TESTSP006', NULL, NULL);

INSERT INTO reservation_flight (id, reservation_id, flight_id, flight_fare_id, segment_number, status, price_amount) VALUES
(1, 1, 1, 1, 1, 'CONFIRMED', 869.98),
(2, 1, 2, 5, 2, 'CONFIRMED', 869.98),
(3, 2, 3, 9, 1, 'CONFIRMED', 584.99),
(4, 2, 4, 13, 2, 'CONFIRMED', 584.99),
(5, 3, 5, 17, 1, 'PENDING', 709.99),
(6, 4, 9, 33, 1, 'CANCELLED', 429.99),
(7, 4, 10, 37, 2, 'CANCELLED', 429.99),
(8, 5, 11, 41, 1, 'CONFIRMED', 1304.97),
(9, 5, 12, 45, 2, 'CONFIRMED', 1304.97);