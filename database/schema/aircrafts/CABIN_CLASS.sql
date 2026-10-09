CREATE TABLE cabin_class (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(30) NOT NULL,
    name VARCHAR(50) NOT NULL,
    UNIQUE KEY uq_cabin_class_code (code),
    UNIQUE KEY uq_cabin_class_name (name)
) ENGINE=InnoDB;