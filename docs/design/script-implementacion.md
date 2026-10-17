# Implementación SQL

```sql
DROP DATABASE IF EXISTS ilicitan_airlines;
CREATE DATABASE ilicitan_airlines CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE ilicitan_airlines;
SET time_zone = '+00:00';

-- Función: Define los roles disponibles para asignarlos a las cuentas de usuario.
-- Ejemplo de datos: id=1, code='ADMIN', name='Administrador'
CREATE TABLE role (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL,
    UNIQUE KEY uq_role_code (code),
    UNIQUE KEY uq_role_name (name)
) ENGINE=InnoDB;

-- Función: Almacena el perfil de los usuarios y su estado.
-- Ejemplo de datos: id=1, role_id=1, first_name='Carlos', last_name='Tormo', email='carlos@example.com', phone='+34600000000', profile_photo_url='https://assets.ilicitan-airlines.com/profiles/1.jpg', status='ACTIVE', created_at='2026-10-17 14:00:00.000000', updated_at='2026-10-17 14:00:00.000000'
CREATE TABLE user_account (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    role_id BIGINT UNSIGNED NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(30),
    profile_photo_url VARCHAR(500) NOT NULL,
    status ENUM('ACTIVE', 'SUSPENDED', 'DELETED') NOT NULL DEFAULT 'SUSPENDED',
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    UNIQUE KEY uq_user_account_email (email),
    CONSTRAINT fk_user_account_role FOREIGN KEY (role_id) REFERENCES role(id)
) ENGINE=InnoDB;

-- Función: Relaciona un usuario con su proveedor de autenticación y almacena la información, permite registrarse con google y apple.
-- Ejemplo de datos: id=1, user_id=1, provider='EMAIL', provider_subject=NULL, password_hash='$2b$12$hash_de_ejemplo', created_at='2026-10-17 14:00:00.000000', updated_at='2026-10-17 14:00:00.000000'
CREATE TABLE auth_account (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT UNSIGNED NOT NULL,
    provider ENUM('EMAIL', 'GOOGLE', 'APPLE') NOT NULL,
    provider_subject VARCHAR(255),
    password_hash VARCHAR(255),
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    UNIQUE KEY uq_auth_provider_subject (provider, provider_subject),
    CONSTRAINT fk_auth_account_user FOREIGN KEY (user_id) REFERENCES user_account(id) ON DELETE CASCADE,
    CONSTRAINT chk_auth_account_credentials CHECK ((provider = 'EMAIL' AND password_hash IS NOT NULL) OR (provider IN ('GOOGLE', 'APPLE') AND password_hash IS NULL))
) ENGINE=InnoDB;

-- Función: Registra los países donde operará la aerolínea.
-- Ejemplo de datos: id=1, iso_code='ES', name='España'
CREATE TABLE country (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    iso_code CHAR(2) NOT NULL,
    name VARCHAR(100) NOT NULL,
    UNIQUE KEY uq_country_iso_code (iso_code),
    UNIQUE KEY uq_country_name (name)
) ENGINE=InnoDB;

-- Función: Almacena las ciudades donde estarán los aeropuertos donde ofrece servicio la aerolínea.
-- Ejemplo de datos: id=1, country_id=1, name='Alicante', banner_city_url='https://example.com/images/alicante.jpg'
CREATE OR REPLACE TABLE city (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    country_id BIGINT UNSIGNED NOT NULL,
    name VARCHAR(100) NOT NULL,
    banner_city_url VARCHAR(500) NOT NULL,
    UNIQUE KEY uq_city_country_name (country_id, name),
    CONSTRAINT fk_city_country FOREIGN KEY (country_id) REFERENCES country(id)
) ENGINE=InnoDB;

-- Función: Registra los aeropuertos, su ubicación geográfica, zona horaria y estado operativo.
-- Ejemplo de datos: id=1, city_id=1, name='Aeropuerto de Alicante-Elche Miguel Hernández', iata_code='ALC', timezone='Europe/Madrid', latitude=38.2822, longitude=-0.5582, status='ACTIVE'
CREATE TABLE airport (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    city_id BIGINT UNSIGNED NOT NULL,
    name VARCHAR(150) NOT NULL,
    iata_code CHAR(3) NOT NULL,
    timezone VARCHAR(64) NOT NULL,
    latitude DECIMAL(10,7),
    longitude DECIMAL(10,7),
    status ENUM('ACTIVE', 'INACTIVE') NOT NULL DEFAULT 'INACTIVE',
    UNIQUE KEY uq_airport_iata_code (iata_code),
    CONSTRAINT fk_airport_city FOREIGN KEY (city_id) REFERENCES city(id),
    CONSTRAINT chk_airport_latitude CHECK (latitude IS NULL OR latitude BETWEEN -90 AND 90),
    CONSTRAINT chk_airport_longitude CHECK (longitude IS NULL OR longitude BETWEEN -180 AND 180)
) ENGINE=InnoDB;

-- Función: Define los modelos de aeronave y su capacidad máxima de pasajeros.
-- Ejemplo de datos: id=1, manufacturer='Airbus', model='A320', capacity=180
CREATE TABLE aircraft_model (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    manufacturer VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    capacity SMALLINT UNSIGNED NOT NULL,
    UNIQUE KEY uq_aircraft_model (manufacturer, model),
    CONSTRAINT chk_aircraft_model_capacity CHECK (capacity > 0)
) ENGINE=InnoDB;

-- Función: Registra cada aeronave física y la identifica mediante su matrícula y número de serie.
-- Ejemplo de datos: id=1, aircraft_model_id=1, registration='EC-ABC', serial_number='SN123456', status='ACTIVE'
CREATE TABLE aircraft (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    aircraft_model_id BIGINT UNSIGNED NOT NULL,
    registration VARCHAR(20) NOT NULL,
    serial_number VARCHAR(50),
    status ENUM('ACTIVE', 'MAINTENANCE', 'INACTIVE') NOT NULL DEFAULT 'INACTIVE',
    UNIQUE KEY uq_aircraft_registration (registration),
    UNIQUE KEY uq_aircraft_serial_number (serial_number),
    CONSTRAINT fk_aircraft_model FOREIGN KEY (aircraft_model_id) REFERENCES aircraft_model(id)
) ENGINE=InnoDB;

-- Función: Define las clases de cabina que pueden ofrecerse en los vuelos.
-- Ejemplo de datos: id=1, code='ECONOMY', name='Turista'
CREATE TABLE cabin_class (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(30) NOT NULL,
    name VARCHAR(50) NOT NULL,
    UNIQUE KEY uq_cabin_class_code (code),
    UNIQUE KEY uq_cabin_class_name (name)
) ENGINE=InnoDB;

-- Función: Asigna a cada aeronave sus asientos y la clase de cabina correspondiente.
-- Ejemplo de datos: id=1, aircraft_id=1, cabin_class_id=1, seat_row=12, seat_letter='A', seat_number='12A'
CREATE TABLE seat (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    aircraft_id BIGINT UNSIGNED NOT NULL,
    cabin_class_id BIGINT UNSIGNED NOT NULL,
    seat_row SMALLINT UNSIGNED NOT NULL,
    seat_letter CHAR(1) NOT NULL,
    seat_number VARCHAR(10) AS (CONCAT(seat_row, RTRIM(seat_letter))) VIRTUAL,
    UNIQUE KEY uq_seat_aircraft_number (aircraft_id, seat_number),
    UNIQUE KEY uq_seat_aircraft_position (aircraft_id, seat_row, seat_letter),
    CONSTRAINT fk_seat_aircraft FOREIGN KEY (aircraft_id) REFERENCES aircraft(id),
    CONSTRAINT fk_seat_cabin_class FOREIGN KEY (cabin_class_id) REFERENCES cabin_class(id),
    CONSTRAINT chk_seat_row CHECK (seat_row > 0),
    CONSTRAINT chk_seat_letter CHECK (seat_letter REGEXP '^[A-Z]$')
) ENGINE=InnoDB;

-- Función: Programa los vuelos con sus aeropuertos, aeronave, horarios UTC y estado operativo.
-- Ejemplo de datos: id=1, flight_iata='IL123', airline_code='IL', flight_number='123', origin_airport_id=1, destination_airport_id=2, aircraft_id=1, scheduled_departure_utc='2026-11-01 08:00:00', scheduled_arrival_utc='2026-11-01 09:10:00', estimated_departure_utc=NULL, estimated_arrival_utc=NULL, status='SCHEDULED', created_at='2026-10-17 14:00:00.000', updated_at='2026-10-17 14:00:00.000'
CREATE TABLE flight (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    flight_iata CHAR(5) AS (CONCAT(RTRIM(airline_code), RTRIM(flight_number))) VIRTUAL,
    airline_code CHAR(2) NOT NULL DEFAULT 'IL',
    flight_number CHAR(3) NOT NULL,
    origin_airport_id BIGINT UNSIGNED NOT NULL,
    destination_airport_id BIGINT UNSIGNED NOT NULL,
    aircraft_id BIGINT UNSIGNED NOT NULL,
    scheduled_departure_utc DATETIME(0) NOT NULL,
    scheduled_arrival_utc DATETIME(0) NOT NULL,
    estimated_departure_utc DATETIME(0),
    estimated_arrival_utc DATETIME(0),
    status ENUM('SCHEDULED','BOARDING','DEPARTED','ARRIVED','DELAYED','CANCELLED') NOT NULL DEFAULT 'CANCELLED',
    created_at DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    updated_at DATETIME(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(6),
    UNIQUE KEY uq_flight_number_departure (flight_iata, scheduled_departure_utc),
    KEY idx_flight_origin_departure (origin_airport_id, scheduled_departure_utc),
    KEY idx_flight_destination_arrival (destination_airport_id, scheduled_arrival_utc),
    CONSTRAINT fk_flight_origin_airport FOREIGN KEY (origin_airport_id) REFERENCES airport(id),
    CONSTRAINT fk_flight_destination_airport FOREIGN KEY (destination_airport_id) REFERENCES airport(id),
    CONSTRAINT fk_flight_aircraft FOREIGN KEY (aircraft_id) REFERENCES aircraft(id),
    CONSTRAINT chk_flight_airports CHECK (origin_airport_id <> destination_airport_id),
    CONSTRAINT chk_flight_schedule CHECK (scheduled_arrival_utc > scheduled_departure_utc),
    CONSTRAINT chk_flight_number CHECK (flight_number REGEXP '^[1-9][0-9]{2}$')
) ENGINE=InnoDB;

-- Función: Define las tarifas disponibles para cada vuelo y clase de cabina, con precio y condiciones.
-- Ejemplo de datos: id=1, flight_id=1, cabin_class_id=1, fare_code='ECONOMY_BASIC', base_price=79.99, currency='EUR', baggage_allowance_kg=8.00, refundable=FALSE, changeable=FALSE
CREATE TABLE flight_fare (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    flight_id BIGINT UNSIGNED NOT NULL,
    cabin_class_id BIGINT UNSIGNED NOT NULL,
    fare_code VARCHAR(30) NOT NULL,
    base_price DECIMAL(10,2) UNSIGNED NOT NULL,
    currency CHAR(3) NOT NULL,
    baggage_allowance_kg DECIMAL(5,2) UNSIGNED NOT NULL DEFAULT 0,
    refundable BOOLEAN NOT NULL DEFAULT FALSE,
    changeable BOOLEAN NOT NULL DEFAULT FALSE,
    UNIQUE KEY uq_flight_fare (flight_id, fare_code),
    UNIQUE KEY uq_flight_fare_id_flight (id, flight_id),
    UNIQUE KEY uq_flight_fare_flight_cabin (flight_id, cabin_class_id),
    CONSTRAINT fk_flight_fare_flight FOREIGN KEY (flight_id) REFERENCES flight(id) ON DELETE CASCADE,
    CONSTRAINT fk_flight_fare_cabin_class FOREIGN KEY (cabin_class_id) REFERENCES cabin_class(id)
) ENGINE=InnoDB;

-- Función: Controla la disponibilidad y el suplemento de cada asiento en un vuelo concreto.
-- Ejemplo de datos: id=1, flight_id=1, seat_id=1, status='AVAILABLE', extra_price=0.00
CREATE TABLE flight_seat (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    flight_id BIGINT UNSIGNED NOT NULL,
    seat_id BIGINT UNSIGNED NOT NULL,
    status ENUM('AVAILABLE', 'BLOCKED') NOT NULL DEFAULT 'BLOCKED',
    extra_price DECIMAL(10,2) UNSIGNED NOT NULL DEFAULT 0,
    UNIQUE KEY uq_flight_seat (flight_id, seat_id),
    CONSTRAINT fk_flight_seat_flight FOREIGN KEY (flight_id) REFERENCES flight(id) ON DELETE CASCADE,
    CONSTRAINT fk_flight_seat_seat FOREIGN KEY (seat_id) REFERENCES seat(id)
) ENGINE=InnoDB;

-- Función: Almacena la reserva global, su referencia, datos de contacto, importe y estado.
-- Ejemplo de datos: id=1, user_id=1, booking_reference='AB12CD', status='CONFIRMED', contact_email='carlos@example.com', contact_phone='+34600000000', total_amount=89.99, currency='EUR', created_at='2026-10-17 14:10:00.000000', updated_at='2026-10-17 14:10:00.000000'
CREATE TABLE reservation (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT UNSIGNED,
    booking_reference CHAR(6) NOT NULL,
    status ENUM( 'PENDING', 'CONFIRMED','CANCELLED','COMPLETED') NOT NULL DEFAULT 'PENDING',
    contact_email VARCHAR(255) NOT NULL,
    contact_phone VARCHAR(30),
    total_amount DECIMAL(10,2) UNSIGNED NOT NULL DEFAULT 0,
    currency CHAR(3) NOT NULL,
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    UNIQUE KEY uq_reservation_booking_reference (booking_reference),
    KEY idx_reservation_user (user_id),
    CONSTRAINT fk_reservation_user FOREIGN KEY (user_id) REFERENCES user_account(id) ON DELETE SET NULL
) ENGINE=InnoDB;

-- Función: Asocia los vuelos y tarifas incluidos en una reserva y conserva el precio de cada tramo.
-- Ejemplo de datos: id=1, reservation_id=1, flight_id=1, flight_fare_id=1, segment_number=1, status='CONFIRMED', price_amount=89.99
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
    CONSTRAINT fk_reservation_flight_fare FOREIGN KEY (flight_fare_id, flight_id) REFERENCES flight_fare(id, flight_id)
) ENGINE=InnoDB;

-- Función: Almacena los datos identificativos de cada pasajero incluido en una reserva.
-- Ejemplo de datos: id=1, reservation_id=1, passenger_number=1, first_name='Carlos', last_name='Tormo', birth_date='2002-04-15', gender='UNSPECIFIED', nationality_country='España', document_type='ID_CARD', document_number='12345678Z', email='carlos@example.com', phone='+34600000000'
CREATE TABLE reservation_passenger (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    reservation_id BIGINT UNSIGNED NOT NULL,
    passenger_number TINYINT UNSIGNED NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    birth_date DATE NOT NULL,
    gender ENUM('MALE', 'FEMALE', 'UNSPECIFIED') NOT NULL DEFAULT 'UNSPECIFIED',
    nationality_country VARCHAR(50) NOT NULL,
    document_type ENUM('PASSPORT', 'ID_CARD', 'OTHER') NOT NULL,
    document_number VARCHAR(50) NOT NULL,
    email VARCHAR(255),
    phone VARCHAR(30),
    UNIQUE KEY uq_reservation_passenger_number (reservation_id, passenger_number),
    CONSTRAINT fk_reservation_passenger_reservation FOREIGN KEY (reservation_id) REFERENCES reservation(id) ON DELETE CASCADE,
    CONSTRAINT chk_reservation_passenger_number CHECK (passenger_number > 0)
) ENGINE=InnoDB;

-- Función: Emite el billete individual de un pasajero para un tramo y calcula el total con tasas.
-- Ejemplo de datos: id=1, reservation_flight_id=1, reservation_passenger_id=1, flight_seat_id=1, ticket_number='1234567890123', status='CONFIRMED', base_fare=79.99, taxes=10.00, total_amount=89.99 (columna virtual calculada), created_at='2026-10-17 14:11:00.000000'
CREATE TABLE ticket (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    reservation_flight_id BIGINT UNSIGNED NOT NULL,
    reservation_passenger_id BIGINT UNSIGNED NOT NULL,
    flight_seat_id BIGINT UNSIGNED,
    ticket_number CHAR(13) NOT NULL,
    status ENUM('PENDING','CONFIRMED','CHECKED_IN','BOARDED','CANCELLED') NOT NULL DEFAULT 'PENDING',
    base_fare DECIMAL(10,2) UNSIGNED NOT NULL DEFAULT 0,
    taxes DECIMAL(10,2) UNSIGNED NOT NULL DEFAULT 0,
    total_amount DECIMAL(10,2) UNSIGNED AS (base_fare + taxes) VIRTUAL,
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    UNIQUE KEY uq_ticket_number (ticket_number),
    UNIQUE KEY uq_ticket_passenger_segment (reservation_flight_id, reservation_passenger_id),
    CONSTRAINT fk_ticket_reservation_flight FOREIGN KEY (reservation_flight_id) REFERENCES reservation_flight(id) ON DELETE CASCADE,
    CONSTRAINT fk_ticket_reservation_passenger FOREIGN KEY (reservation_passenger_id) REFERENCES reservation_passenger(id) ON DELETE CASCADE,
    CONSTRAINT fk_ticket_flight_seat FOREIGN KEY (flight_seat_id) REFERENCES flight_seat(id)
) ENGINE=InnoDB;

-- Función: Define las modalidades de equipaje, sus dimensiones, peso permitido y precio.
-- Ejemplo de datos: id=1, name='Maleta facturada 20 kg', type='CHECKED', weight_kg=20.00, length_cm=55, width_cm=40, height_cm=20, price_amount=25.00, currency='EUR', status='ACTIVE', created_at='2026-10-17 14:00:00.000000', updated_at='2026-10-17 14:00:00.000000'
CREATE TABLE baggage_option (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    type ENUM('PERSONAL_ITEM', 'CABIN', 'CHECKED') NOT NULL,
    weight_kg DECIMAL(5,2) NOT NULL,
    length_cm SMALLINT UNSIGNED NOT NULL,
    width_cm SMALLINT UNSIGNED NOT NULL,
    height_cm SMALLINT UNSIGNED NOT NULL,
    price_amount DECIMAL(10,2) NOT NULL,
    currency CHAR(3) NOT NULL,
    status ENUM('ACTIVE', 'INACTIVE') NOT NULL DEFAULT 'INACTIVE',
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    CONSTRAINT chk_baggage_option_weight CHECK (weight_kg > 0),
    CONSTRAINT chk_baggage_option_price CHECK (price_amount > 0)
);

-- Función: Registra el equipaje contratado para un billete, con su modalidad, cantidad y peso.
-- Ejemplo de datos: id=1, ticket_id=1, baggage_option_id=1, quantity=1, weight_kg=20.00, created_at='2026-10-17 14:12:00.000000'
CREATE TABLE baggage (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ticket_id BIGINT UNSIGNED NOT NULL,
    baggage_option_id BIGINT UNSIGNED NOT NULL,
    quantity TINYINT UNSIGNED NOT NULL DEFAULT 1,
    weight_kg DECIMAL(5,2) UNSIGNED NOT NULL,
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    CONSTRAINT fk_baggage_ticket FOREIGN KEY (ticket_id) REFERENCES ticket(id) ON DELETE CASCADE,
    CONSTRAINT fk_baggage_option FOREIGN KEY (baggage_option_id) REFERENCES baggage_option(id),
    CONSTRAINT chk_baggage_quantity CHECK (quantity > 0),
    CONSTRAINT chk_baggage_weight CHECK (weight_kg > 0)
) ENGINE=InnoDB;

-- Función: Almacena los datos de identificación y viaje requeridos para la información anticipada del pasajero.
-- Ejemplo de datos: id=1, ticket_id=1, document_type='PASSPORT', document_number='X1234567', issuing_country='España', nationality_country='España', document_expiry_date='2030-12-31', birth_date='2002-04-15', gender='UNSPECIFIED', created_at='2026-10-17 14:12:00.000000', updated_at='2026-10-17 14:12:00.000000'
CREATE TABLE api_data (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ticket_id BIGINT UNSIGNED NOT NULL,
    document_type ENUM('PASSPORT', 'ID_CARD', 'OTHER') NOT NULL,
    document_number VARCHAR(50) NOT NULL,
    issuing_country VARCHAR(50) NOT NULL,
    nationality_country VARCHAR(50) NOT NULL,
    document_expiry_date DATE NOT NULL,
    birth_date DATE NOT NULL,
    gender ENUM('MALE', 'FEMALE', 'UNSPECIFIED') NOT NULL DEFAULT 'UNSPECIFIED',
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    CONSTRAINT fk_api_data_ticket FOREIGN KEY (ticket_id) REFERENCES ticket(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Función: Gestiona el estado del proceso de facturación y su fecha de finalización en UTC.
-- Ejemplo de datos: id=1, ticket_id=1, status='COMPLETED', checked_in_at_utc='2026-10-31 16:00:00.000000', created_at='2026-10-31 15:55:00.000000', updated_at='2026-10-31 16:00:00.000000'
CREATE TABLE checkin (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ticket_id BIGINT UNSIGNED NOT NULL,
    status ENUM('OPEN', 'COMPLETED', 'CANCELLED', 'EXPIRED', 'INACTIVE') NOT NULL DEFAULT 'INACTIVE',
    checked_in_at_utc DATETIME(6),
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    UNIQUE KEY uq_checkin_ticket (ticket_id),
    CONSTRAINT fk_checkin_ticket FOREIGN KEY (ticket_id) REFERENCES ticket(id) ON DELETE CASCADE,
    CONSTRAINT chk_checkin_completed_at CHECK ((status = 'COMPLETED' AND checked_in_at_utc IS NOT NULL) OR (status <> 'COMPLETED' AND checked_in_at_utc IS NULL))
) ENGINE=InnoDB;

-- Función: Genera la tarjeta de embarque vinculada a una facturación, con token QR y datos de acceso.
-- Ejemplo de datos: id=1, checkin_id=1, qr_token='qr_test_token_8f3c', terminal='1', gate='12', boarding_group='GROUP_2', boarding_zone='ZONE_2', issued_at_utc='2026-10-31 16:00:00.000000'
CREATE TABLE boarding_pass (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    checkin_id BIGINT UNSIGNED NOT NULL,
    qr_token VARCHAR(255) NOT NULL,
    terminal VARCHAR(20),
    gate VARCHAR(20),
    boarding_group VARCHAR(20),
    boarding_zone VARCHAR(20),
    issued_at_utc DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    UNIQUE KEY uq_boarding_pass_checkin (checkin_id),
    UNIQUE KEY uq_boarding_pass_qr_token (qr_token),
    CONSTRAINT fk_boarding_pass_checkin FOREIGN KEY (checkin_id) REFERENCES checkin(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Función: Almacena los datos fiscales y la dirección de facturación asociadas a una reserva.
-- Ejemplo de datos: id=1, reservation_id=1, billing_type='INDIVIDUAL', first_name='Carlos', last_name='Tormo', company_name=NULL, tax_id=NULL, address='Calle Mayor 10', city='Elche', postal_code='03201', country='España', created_at='2026-10-17 14:10:00.000000'
CREATE TABLE billing_data (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    reservation_id BIGINT UNSIGNED NOT NULL,
    billing_type ENUM('INDIVIDUAL', 'COMPANY') NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(100),
    company_name VARCHAR(150),
    tax_id VARCHAR(50),
    address VARCHAR(255) NOT NULL,
    city VARCHAR(100) NOT NULL,
    postal_code VARCHAR(20) NOT NULL,
    country VARCHAR(50) NOT NULL,
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    UNIQUE KEY uq_billing_data_reservation (reservation_id),
    CONSTRAINT fk_billing_data_reservation FOREIGN KEY (reservation_id) REFERENCES reservation(id) ON DELETE CASCADE,
    CONSTRAINT chk_billing_data_individual CHECK (billing_type <> 'INDIVIDUAL' OR (first_name IS NOT NULL AND last_name IS NOT NULL)),
    CONSTRAINT chk_billing_data_company CHECK (billing_type <> 'COMPANY' OR (company_name IS NOT NULL AND tax_id IS NOT NULL))
) ENGINE=InnoDB;

-- Función: Registra las operaciones de pago de una reserva, su importe, método, referencia y resultado.
-- Ejemplo de datos: id=1, reservation_id=1, method='VISA', provider='Stripe', transaction_reference='txn_test_20261017_0001', amount=89.99, currency='EUR', status='COMPLETED', paid_at_utc='2026-10-17 14:11:00.000000', created_at='2026-10-17 14:10:30.000000'
CREATE TABLE payment (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    reservation_id BIGINT UNSIGNED NOT NULL,
    method ENUM('VISA', 'MASTERCARD', 'PAYPAL', 'GOOGLE_PAY', 'APPLE_PAY') NOT NULL,
    provider VARCHAR(50),
    transaction_reference VARCHAR(255) NOT NULL,
    amount DECIMAL(10,2) UNSIGNED NOT NULL,
    currency CHAR(3) NOT NULL,
    status ENUM('PENDING', 'AUTHORIZED', 'COMPLETED', 'FAILED', 'REFUNDED') NOT NULL DEFAULT 'PENDING',
    paid_at_utc DATETIME(6),
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    UNIQUE KEY uq_payment_transaction_reference (transaction_reference),
    KEY idx_payment_reservation (reservation_id),
    CONSTRAINT fk_payment_reservation FOREIGN KEY (reservation_id) REFERENCES reservation(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Función: Audita las acciones administrativas realizadas sobre entidades del sistema.
-- Ejemplo de datos: id=1, admin_user_id=1, action='UPDATE', entity_type='flight', entity_id=1, details={"flight_iata":"IL123"}, created_at='2026-10-17 14:15:00.000000'
CREATE TABLE admin_log (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    admin_user_id BIGINT UNSIGNED NOT NULL,
    action VARCHAR(100) NOT NULL,
    entity_type VARCHAR(100) NOT NULL,
    entity_id BIGINT UNSIGNED,
    details JSON,
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    KEY idx_admin_audit_user_created (admin_user_id, created_at),
    KEY idx_admin_audit_entity (entity_type, entity_id),
    CONSTRAINT fk_admin_audit_user FOREIGN KEY (admin_user_id) REFERENCES user_account(id)
) ENGINE=InnoDB;
```