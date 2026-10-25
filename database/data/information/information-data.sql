INSERT INTO baggage_option (id, name, type, weight_kg, length_cm, width_cm, height_cm, price_amount, currency, status) VALUES
(1, 'Additional Personal Item - 40x30x15 cm', 'PERSONAL_ITEM', 5.00, 40, 30, 15, 19.99, 'EUR', 'ACTIVE'),
(2, 'Cabin Bag - 10 kg - 55x40x23 cm', 'CABIN', 10.00, 55, 40, 23, 45.00, 'EUR', 'ACTIVE'),
(3, 'Checked Bag - 23 kg - 158 cm total', 'CHECKED', 23.00, 75, 50, 30, 64.99, 'EUR', 'ACTIVE'),
(4, 'Heavy Checked Bag - 32 kg - 158 cm total', 'CHECKED', 32.00, 75, 50, 30, 109.99, 'EUR', 'ACTIVE'),
(5, 'Oversized Checked Bag - 23 kg - 200 cm total', 'CHECKED', 23.00, 100, 60, 40, 149.99, 'EUR', 'ACTIVE'),
(6, 'Sports Equipment - Up to 23 kg', 'CHECKED', 23.00, 140, 40, 30, 119.99, 'EUR', 'ACTIVE'),
(7, 'Legacy Cabin Bag - 8 kg', 'CABIN', 8.00, 55, 40, 20, 39.99, 'EUR', 'INACTIVE');

INSERT INTO ticket (id, reservation_flight_id, reservation_passenger_id, flight_seat_id, ticket_number, status, base_fare, taxes) VALUES
(1, 1, 1, 1, '1234567890001', 'CHECKED_IN', 350.00, 84.99),
(2, 1, 2, 3, '1234567890002', 'CHECKED_IN', 350.00, 84.99),
(3, 2, 1, NULL, '1234567890003', 'CONFIRMED', 350.00, 84.99),
(4, 2, 2, NULL, '1234567890004', 'CONFIRMED', 350.00, 84.99),
(5, 3, 3, 81, '1234567890005', 'CHECKED_IN', 470.00, 114.99),
(6, 4, 3, NULL, '1234567890006', 'CONFIRMED', 470.00, 114.99),
(7, 5, 4, NULL, '1234567890007', 'PENDING', 570.00, 139.99),
(8, 6, 5, NULL, '1234567890008', 'CANCELLED', 345.00, 84.99),
(9, 7, 5, NULL, '1234567890009', 'CANCELLED', 345.00, 84.99),
(10, 8, 6, NULL, '1234567890010', 'CONFIRMED', 350.00, 84.99),
(11, 8, 7, NULL, '1234567890011', 'CONFIRMED', 350.00, 84.99),
(12, 8, 8, NULL, '1234567890012', 'CONFIRMED', 350.00, 84.99),
(13, 9, 6, NULL, '1234567890013', 'CONFIRMED', 350.00, 84.99),
(14, 9, 7, NULL, '1234567890014', 'CONFIRMED', 350.00, 84.99),
(15, 9, 8, NULL, '1234567890015', 'CONFIRMED', 350.00, 84.99);

INSERT INTO api_data (id, ticket_id, document_type, document_number, issuing_country, nationality_country, document_expiry_date, birth_date, gender) VALUES
(1, 1, 'PASSPORT', 'TESTSP001', 'Spain', 'Spain', '2032-04-11', '1995-04-12', 'FEMALE'),
(2, 2, 'PASSPORT', 'TESTSP002', 'Spain', 'Spain', '2031-09-24', '1992-09-25', 'MALE'),
(3, 3, 'PASSPORT', 'TESTSP001', 'Spain', 'Spain', '2032-04-11', '1995-04-12', 'FEMALE'),
(4, 4, 'PASSPORT', 'TESTSP002', 'Spain', 'Spain', '2031-09-24', '1992-09-25', 'MALE'),
(5, 5, 'ID_CARD', 'TESTSP003', 'Spain', 'Spain', '2030-02-17', '1988-02-18', 'MALE'),
(6, 6, 'ID_CARD', 'TESTSP003', 'Spain', 'Spain', '2030-02-17', '1988-02-18', 'MALE'),
(7, 10, 'PASSPORT', 'TESTSP004', 'Spain', 'Spain', '2031-06-13', '1987-06-14', 'FEMALE'),
(8, 11, 'PASSPORT', 'TESTSP005', 'Spain', 'Spain', '2030-03-08', '1985-03-09', 'MALE'),
(9, 12, 'PASSPORT', 'TESTSP006', 'Spain', 'Spain', '2030-12-01', '2015-12-02', 'UNSPECIFIED'),
(10, 13, 'PASSPORT', 'TESTSP004', 'Spain', 'Spain', '2031-06-13', '1987-06-14', 'FEMALE'),
(11, 14, 'PASSPORT', 'TESTSP005', 'Spain', 'Spain', '2030-03-08', '1985-03-09', 'MALE'),
(12, 15, 'PASSPORT', 'TESTSP006', 'Spain', 'Spain', '2030-12-01', '2015-12-02', 'UNSPECIFIED');

INSERT INTO baggage (id, ticket_id, baggage_option_id, quantity, weight_kg) VALUES
(1, 1, 3, 1, 21.40),(2, 1, 2, 1, 8.20),(3, 2, 3, 1, 20.80),(4, 2, 2, 1, 7.60),(5, 2, 1, 1, 3.80),
(6, 3, 3, 1, 21.40),(7, 3, 2, 1, 8.20),(8, 4, 3, 1, 20.80),(9, 4, 2, 1, 7.60),(10, 4, 1, 1, 3.80),
(11, 5, 4, 1, 29.50),(12, 5, 2, 1, 9.00),(13, 6, 4, 1, 29.50),(14, 6, 2, 1, 9.00),(15, 10, 5, 1, 22.80),
(16, 10, 2, 1, 8.90),(17, 11, 3, 1, 21.60),(18, 11, 2, 1, 8.50),(19, 11, 6, 1, 18.50),(20, 12, 3, 1, 15.80),
(21, 12, 2, 1, 5.50),(22, 13, 5, 1, 22.80),(23, 13, 2, 1, 8.90),(24, 14, 3, 1, 21.60),(25, 14, 2, 1, 8.50),
(26, 14, 6, 1, 18.50),(27, 15, 3, 1, 15.80),(28, 15, 2, 1, 5.50);

INSERT INTO checkin (id, ticket_id, status, checked_in_at_utc) VALUES
(1, 1, 'COMPLETED', '2027-06-01 10:00:00'),
(2, 2, 'COMPLETED', '2027-06-01 10:04:00'),
(3, 3, 'INACTIVE', NULL),
(4, 4, 'INACTIVE', NULL),
(5, 5, 'COMPLETED', '2027-06-01 03:15:00'),
(6, 6, 'INACTIVE', NULL),
(7, 7, 'INACTIVE', NULL),
(8, 8, 'CANCELLED', NULL),
(9, 9, 'CANCELLED', NULL),
(10, 10, 'INACTIVE', NULL),
(11, 11, 'INACTIVE', NULL),
(12, 12, 'INACTIVE', NULL),
(13, 13, 'INACTIVE', NULL),
(14, 14, 'INACTIVE', NULL),
(15, 15, 'INACTIVE', NULL);

INSERT INTO boarding_pass (id, checkin_id, qr_token, terminal, gate, boarding_group, boarding_zone, issued_at_utc) VALUES
(1, 1, 'ILBP-2027-000001-TEST', 'T4S', 'B24', '1', '1', '2027-06-01 10:01:00'),
(2, 2, 'ILBP-2027-000002-TEST', 'T4S', 'B24', '1', '1', '2027-06-01 10:05:00'),
(3, 5, 'ILBP-2027-000005-TEST', 'T4S', 'A12', '2', '3', '2027-06-01 03:17:00');