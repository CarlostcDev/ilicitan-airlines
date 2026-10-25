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
SOURCE schema/aircraft/AIRCRAFT_MODEL.sql;
SOURCE schema/aircraft/AIRCRAFT.sql;
SOURCE schema/aircraft/CABIN_CLASS.sql;
SOURCE schema/aircraft/SEAT.sql;
SOURCE schema/flight/FLIGHT.sql;
SOURCE schema/flight/FLIGHT_FARE.sql;
SOURCE schema/flight/FLIGHT_SEAT.sql;
SOURCE schema/reservation/RESERVATION.sql;
SOURCE schema/reservation/RESERVATION_FLIGHT.sql;
SOURCE schema/reservation/RESERVATION_PASSENGER.sql;
SOURCE schema/information/TICKET.sql;
SOURCE schema/information/BAGGAGE_OPTION.sql;
SOURCE schema/information/BAGGAGE.sql;
SOURCE schema/information/API_DATA.sql;
SOURCE schema/information/CHECKIN.sql;
SOURCE schema/information/BOARDING_PASS.sql;
SOURCE schema/payment/BILLING_DATA.sql;
SOURCE schema/payment/PAYMENT.sql;
SOURCE schema/logging/ADMIN_LOG.sql;

-- DML Scripts
SOURCE data/aircraft/aircraft-data.sql;
SOURCE data/location/location-data.sql;
SOURCE data/flight/flight-data.sql;
SOURCE data/flight/flight-seat-data.sql;
SOURCE data/flight/flight-fare-data.sql;
SOURCE data/identity/identity-data.sql;
SOURCE data/reservation/reservation-data.sql;
SOURCE data/information/information-data.sql;
SOURCE data/payment/payment-data.sql;