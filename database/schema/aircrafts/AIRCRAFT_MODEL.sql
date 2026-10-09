CREATE TABLE aircraft_model (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    manufacturer VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    capacity SMALLINT UNSIGNED NOT NULL,
    UNIQUE KEY uq_aircraft_model (manufacturer, model),
    CONSTRAINT chk_aircraft_model_capacity CHECK (capacity > 0)
) ENGINE=InnoDB;