DROP DATABASE IF EXISTS ilicitan_airlines;
CREATE DATABASE ilicitan_airlines CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE ilicitan_airlines;
SET time_zone = '+00:00';

-- DDL Scripts
SOURCE schema/identity/ROLE.sql;
SOURCE schema/identity/USER_ACCOUNT.sql;
SOURCE schema/identity/AUTH_ACCOUNT.sql;
SOURCE schema/location/COUNTRY.sql;
SOURCE schema/location/CITY.sql;
SOURCE schema/location/AIRPORT.sql;
SOURCE schema/aircrafts/AIRCRAFT_MODEL.sql;
SOURCE schema/aircrafts/AIRCRAFT.sql;
SOURCE schema/aircrafts/CABIN_CLASS.sql;
SOURCE schema/aircrafts/SEAT.sql;
SOURCE schema/flights/FLIGHT.sql;
SOURCE schema/flights/FLIGHT_FARE.sql;
SOURCE schema/flights/FLIGHT_SEAT.sql;
SOURCE schema/reservations/RESERVATION.sql;
SOURCE schema/reservations/RESERVATION_FLIGHT.sql;
SOURCE schema/reservations/RESERVATION_PASSENGER.sql;
SOURCE schema/information/TICKET.sql;
SOURCE schema/aircrafts/BAGGAGE.sql;
SOURCE schema/information/API_DATA.sql;
SOURCE schema/information/CHECKIN.sql;
SOURCE schema/information/BOARDING_PASS.sql;
SOURCE schema/payments/BILLING_DATA.sql;
SOURCE schema/payments/PAYMENT.sql;
SOURCE schema/logs/ADMIN_LOG.sql;

-- DML Scripts
SOURCE seed/roles.sql;
SOURCE seed/cabin_classes.sql;