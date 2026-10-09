CREATE TABLE city (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    country_id BIGINT UNSIGNED NOT NULL,
    name VARCHAR(100) NOT NULL,
    UNIQUE KEY uq_city_country_name (country_id, name),
    CONSTRAINT fk_city_country FOREIGN KEY (country_id) REFERENCES country(id)
) ENGINE=InnoDB;