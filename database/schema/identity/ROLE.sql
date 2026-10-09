CREATE TABLE role (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL,
    UNIQUE KEY uq_role_code (code),
    UNIQUE KEY uq_role_name (name)
) ENGINE=InnoDB;