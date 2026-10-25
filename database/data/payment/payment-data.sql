INSERT INTO payment (id, reservation_id, method, provider, transaction_reference, amount, currency, status, paid_at_utc) VALUES
(1, 1, 'VISA', 'Stripe', 'pi_test_IL7K2A_001', 1739.96, 'EUR', 'COMPLETED', '2026-10-20 10:15:30'),
(2, 2, 'PAYPAL', 'PayPal', 'PAYID-IL8M3Q-001', 1169.98, 'EUR', 'COMPLETED', '2026-10-21 14:32:10'),
(3, 3, 'GOOGLE_PAY', 'Stripe', 'pi_test_IL9P4R_001', 709.99, 'EUR', 'PENDING', NULL),
(4, 4, 'MASTERCARD', 'Stripe', 'pi_test_IL2X6B_001', 859.98, 'EUR', 'REFUNDED', '2026-10-18 09:45:00'),
(5, 5, 'APPLE_PAY', 'Stripe', 'pi_test_IL5N8C_001', 2609.94, 'EUR', 'COMPLETED', '2026-10-23 18:20:45');

INSERT INTO billing_data (id, reservation_id, billing_type, first_name, last_name, company_name, tax_id, address, city, postal_code, country) VALUES
(1, 1, 'INDIVIDUAL', 'Sofia', 'Martin', NULL, NULL, 'Calle de Alcala 125', 'Madrid', '28009', 'Spain'),
(2, 2, 'COMPANY', NULL, NULL, 'NTT Data Spain S.L.U.', 'B82387770', 'Camino de la Fuente de la Mora, 1', 'Madrid', '28050', 'Spain'),
(3, 3, 'INDIVIDUAL', 'Emma', 'Wilson', NULL, NULL, '25 Oxford Street', 'London', 'W1D 2DW', 'United Kingdom'),
(4, 4, 'INDIVIDUAL', 'Liam', 'Taylor', NULL, NULL, '10 Downing Road', 'London', 'SW1A 2AA', 'United Kingdom'),
(5, 5, 'INDIVIDUAL', 'Olivia', 'Garcia', NULL, NULL, 'Calle de Aragon 220', 'Barcelona', '08007', 'Spain');