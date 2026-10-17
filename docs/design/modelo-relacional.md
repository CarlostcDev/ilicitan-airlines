# Modelo Relacional

El modelo relacional se ha elaborado a partir de las definiciones de Ilicitan Airlines. Se documentan las 25 tablas que existen en el esquema actual, indicando los nombres de las columnas, las claves y las referencias implementadas.

## Notación

- **PK**: clave primaria; identifica de forma única cada registro.
- **FK**: clave ajena; enlaza un registro con una clave de otra tabla.
- `*` junto a un campo: el campo participa en una clave ajena.
- **UK**: restricción `UNIQUE`; impide duplicar el valor o la combinación de valores indicada. No sustituye a la PK.
- **[NULL]**: el campo permite valores nulos en el SQL actual.
- **[GENERADO]**: columna virtual calculada a partir de otros campos.

Todas las tablas tienen una clave primaria simple `id`. Por tanto, **ninguna de las tablas tiene una PK compuesta en el esquema SQL actual**. Algunas sí tienen restricciones `UNIQUE` compuestas, que se señalan en cada caso.

## Modelo

### ROLE

`ROLE (id, code, name)`

- **PK:** `(id)`
- **UK:** `(code)`, `(name)`

### USER_ACCOUNT

`USER_ACCOUNT (id, role_id*, first_name, last_name, email, phone [NULL], profile_photo_url, status, created_at, updated_at)`

- **PK:** `(id)`
- **FK:** `(role_id) → ROLE(id)`
- **UK:** `(email)`

### AUTH_ACCOUNT

`AUTH_ACCOUNT (id, user_id*, provider, provider_subject [NULL], password_hash [NULL], created_at, updated_at)`

- **PK:** `(id)`
- **FK:** `(user_id) → USER_ACCOUNT(id)`
- **UK:** `(provider, provider_subject)`

### COUNTRY

`COUNTRY (id, iso_code, name)`

- **PK:** `(id)`
- **UK:** `(iso_code)`, `(name)`

### CITY

`CITY (id, country_id*, name, banner_city_url)`

- **PK:** `(id)`
- **FK:** `(country_id) → COUNTRY(id)`
- **UK:** `(country_id, name)`

### AIRPORT

`AIRPORT (id, city_id*, name, iata_code, timezone, latitude [NULL], longitude [NULL], status)`

- **PK:** `(id)`
- **FK:** `(city_id) → CITY(id)`
- **UK:** `(iata_code)`

### AIRCRAFT_MODEL

`AIRCRAFT_MODEL (id, manufacturer, model, capacity)`

- **PK:** `(id)`
- **UK:** `(manufacturer, model)`

### AIRCRAFT

`AIRCRAFT (id, aircraft_model_id*, registration, serial_number [NULL], status)`

- **PK:** `(id)`
- **FK:** `(aircraft_model_id) → AIRCRAFT_MODEL(id)`
- **UK:** `(registration)`, `(serial_number)`

### CABIN_CLASS

`CABIN_CLASS (id, code, name)`

- **PK:** `(id)`
- **UK:** `(code)`, `(name)`

### SEAT

`SEAT (id, aircraft_id*, cabin_class_id*, seat_row, seat_letter, seat_number [GENERADO])`

- **PK:** `(id)`
- **FK:** `(aircraft_id) → AIRCRAFT(id)`
- **FK:** `(cabin_class_id) → CABIN_CLASS(id)`
- **UK:** `(aircraft_id, seat_number)`, `(aircraft_id, seat_row, seat_letter)`

`seat_number` se calcula a partir de `seat_row` y `seat_letter`. Las restricciones `UNIQUE` evitan repetir el número o la posición de un asiento dentro de la misma aeronave.


### FLIGHT

`FLIGHT (id, flight_iata [GENERADO], airline_code, flight_number, origin_airport_id*, destination_airport_id*, aircraft_id*, scheduled_departure_utc, scheduled_arrival_utc, estimated_departure_utc [NULL], estimated_arrival_utc [NULL], status, created_at, updated_at)`

- **PK:** `(id)`
- **FK:** `(origin_airport_id) → AIRPORT(id)`
- **FK:** `(destination_airport_id) → AIRPORT(id)`
- **FK:** `(aircraft_id) → AIRCRAFT(id)`
- **UK:** `(flight_iata, scheduled_departure_utc)`

`origin_airport_id` y `destination_airport_id` son dos claves ajenas distintas hacia `AIRPORT`: representan el aeropuerto de origen y el aeropuerto de destino. `flight_iata` es una columna virtual calculada con `airline_code` y `flight_number`.

### FLIGHT_FARE

`FLIGHT_FARE (id, flight_id*, cabin_class_id*, fare_code, base_price, currency, baggage_allowance_kg, refundable, changeable)`

- **PK:** `(id)`
- **FK:** `(flight_id) → FLIGHT(id)`
- **FK:** `(cabin_class_id) → CABIN_CLASS(id)`
- **UK:** `(flight_id, fare_code)`, `(flight_id, cabin_class_id)`, `(id, flight_id)`

### FLIGHT_SEAT

`FLIGHT_SEAT (id, flight_id*, seat_id*, status, extra_price)`

- **PK:** `(id)`
- **FK:** `(flight_id) → FLIGHT(id)`
- **FK:** `(seat_id) → SEAT(id)`
- **UK:** `(flight_id, seat_id)`

`FLIGHT_SEAT` representa los asientos disponibles o bloqueados en cada vuelo y permite registrar un precio adicional por asiento.

### RESERVATION

`RESERVATION (id, user_id* [NULL], booking_reference, status, contact_email, contact_phone [NULL], total_amount, currency, created_at, updated_at)`

- **PK:** `(id)`
- **FK:** `(user_id) → USER_ACCOUNT(id)`
- **UK:** `(booking_reference)`

`user_id` permite `NULL`, por lo que el esquema admite reservas no vinculadas a una cuenta de usuario.

### RESERVATION_FLIGHT

`RESERVATION_FLIGHT (id, reservation_id*, flight_id*, flight_fare_id*, segment_number, status, price_amount)`

- **PK:** `(id)`
- **FK:** `(reservation_id) → RESERVATION(id)`
- **FK:** `(flight_id) → FLIGHT(id)`
- **FK compuesta:** `(flight_fare_id, flight_id) → FLIGHT_FARE(id, flight_id)`
- **UK:** `(reservation_id, segment_number)`, `(reservation_id, flight_id)`

La FK compuesta garantiza que la tarifa seleccionada corresponde al mismo vuelo indicado en `flight_id`. `flight_id` también tiene una FK directa hacia `FLIGHT(id)`.

### RESERVATION_PASSENGER

`RESERVATION_PASSENGER (id, reservation_id*, passenger_number, first_name, last_name, birth_date, gender, nationality_country, document_type, document_number, email [NULL], phone [NULL])`

- **PK:** `(id)`
- **FK:** `(reservation_id) → RESERVATION(id)`
- **UK:** `(reservation_id, passenger_number)`

### TICKET

`TICKET (id, reservation_flight_id*, reservation_passenger_id*, flight_seat_id* [NULL], ticket_number, status, base_fare, taxes, total_amount [GENERADO], created_at)`

- **PK:** `(id)`
- **FK:** `(reservation_flight_id) → RESERVATION_FLIGHT(id)`
- **FK:** `(reservation_passenger_id) → RESERVATION_PASSENGER(id)`
- **FK:** `(flight_seat_id) → FLIGHT_SEAT(id)`
- **UK:** `(ticket_number)`, `(reservation_flight_id, reservation_passenger_id)`

`total_amount` se calcula a partir de `base_fare` y `taxes`. `flight_seat_id` permite `NULL`, por lo que el billete puede no tener un asiento asignado en el momento de registrarse.

### BAGGAGE_OPTION

`BAGGAGE_OPTION (id, name, type, weight_kg, length_cm, width_cm, height_cm, price_amount, currency, status, created_at, updated_at)`

- **PK:** `(id)`

### BAGGAGE

`BAGGAGE (id, ticket_id*, baggage_option_id*, quantity, weight_kg, created_at)`

- **PK:** `(id)`
- **FK:** `(ticket_id) → TICKET(id)`
- **FK:** `(baggage_option_id) → BAGGAGE_OPTION(id)`

`BAGGAGE` asocia un billete con una opción de equipaje y guarda la cantidad y el peso registrados.

### API_DATA

`API_DATA (id, ticket_id*, document_type, document_number, issuing_country, nationality_country, document_expiry_date, birth_date, gender, created_at, updated_at)`

- **PK:** `(id)`
- **FK:** `(ticket_id) → TICKET(id)`

### CHECKIN

`CHECKIN (id, ticket_id*, status, checked_in_at_utc [NULL], created_at, updated_at)`

- **PK:** `(id)`
- **FK:** `(ticket_id) → TICKET(id)`
- **UK:** `(ticket_id)`

La restricción `UNIQUE` permite como máximo un registro de check-in por billete.

### BOARDING_PASS

`BOARDING_PASS (id, checkin_id*, qr_token, terminal [NULL], gate [NULL], boarding_group [NULL], boarding_zone [NULL], issued_at_utc)`

- **PK:** `(id)`
- **FK:** `(checkin_id) → CHECKIN(id)`
- **UK:** `(checkin_id)`, `(qr_token)`

La restricción `UNIQUE` sobre `checkin_id` permite como máximo una tarjeta de embarque por check-in.

### BILLING_DATA

`BILLING_DATA (id, reservation_id*, billing_type, first_name [NULL], last_name [NULL], company_name [NULL], tax_id [NULL], address, city, postal_code, country, created_at)`

- **PK:** `(id)`
- **FK:** `(reservation_id) → RESERVATION(id)`
- **UK:** `(reservation_id)`

La restricción `UNIQUE` permite como máximo un registro de facturación por reserva.

### PAYMENT

`PAYMENT (id, reservation_id*, method, provider [NULL], transaction_reference, amount, currency, status, paid_at_utc [NULL], created_at)`

- **PK:** `(id)`
- **FK:** `(reservation_id) → RESERVATION(id)`
- **UK:** `(transaction_reference)`

### ADMIN_LOG

`ADMIN_LOG (id, admin_user_id*, action, entity_type, entity_id [NULL], details [NULL], created_at)`

- **PK:** `(id)`
- **FK:** `(admin_user_id) → USER_ACCOUNT(id)`
