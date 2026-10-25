INSERT INTO role (id, code, name) VALUES
(1, 'SUPER_ADMIN', 'Superadministrator'),
(2, 'FLIGHT_ADMIN', 'Flight Administrator'),
(3, 'USER_ADMIN', 'User Administrator'),
(4, 'USER', 'User');

INSERT INTO user_account (id, role_id, first_name, last_name, email, phone, profile_photo_url, status) VALUES
(1, 3, 'Lucia', 'Fernandez', 'lucia.fernandez@ilicitan-airlines.com', NULL, 'https://ilicitan-airlines.com/assets/default-avatar.png', 'ACTIVE'),
(2, 3, 'Javier', 'Molina', 'javier.molina@ilicitan-airlines.com', NULL, 'https://ilicitan-airlines.com/assets/default-avatar.png', 'ACTIVE'),
(3, 2, 'Elena', 'Torres', 'elena.torres@ilicitan-airlines.com', NULL, 'https://ilicitan-airlines.com/assets/default-avatar.png', 'ACTIVE'),
(4, 2, 'David', 'Navarro', 'david.navarro@ilicitan-airlines.com', NULL, 'https://ilicitan-airlines.com/assets/default-avatar.png', 'ACTIVE'),
(5, 1, 'Marta', 'Romero', 'superadmin@ilicitan-airlines.com', NULL, 'https://ilicitan-airlines.com/assets/default-avatar.png', 'ACTIVE');

INSERT INTO auth_account (id, user_id, provider, provider_subject, password_hash) VALUES
(1, 1, 'EMAIL', 'lucia.fernandez@ilicitan-airlines.com', '$2a$10$OTpktlLPP9dJn07EzhcmGeqqkkpIlOCxn/3bE2qTb4NRSsU/8mMx2'),
(2, 2, 'EMAIL', 'javier.molina@ilicitan-airlines.com', '$2a$10$OTpktlLPP9dJn07EzhcmGeqqkkpIlOCxn/3bE2qTb4NRSsU/8mMx2'),
(3, 3, 'EMAIL', 'elena.torres@ilicitan-airlines.com', '$2a$10$OTpktlLPP9dJn07EzhcmGeqqkkpIlOCxn/3bE2qTb4NRSsU/8mMx2'),
(4, 4, 'EMAIL', 'david.navarro@ilicitan-airlines.com', '$2a$10$OTpktlLPP9dJn07EzhcmGeqqkkpIlOCxn/3bE2qTb4NRSsU/8mMx2'),
(5, 5, 'EMAIL', 'superadmin@ilicitan-airlines.com', '$2a$10$OTpktlLPP9dJn07EzhcmGeqqkkpIlOCxn/3bE2qTb4NRSsU/8mMx2');