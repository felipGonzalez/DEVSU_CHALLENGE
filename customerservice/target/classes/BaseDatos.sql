CREATE SCHEMA `customerdb` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE person (
    id BIGINT NOT NULL AUTO_INCREMENT,
    type_person VARCHAR(31) NOT NULL,
    address VARCHAR(255),
    age INTEGER NOT NULL,
    gender VARCHAR(255),
    identification VARCHAR(255),
    name VARCHAR(255),
    phone VARCHAR(255),
    PRIMARY KEY (id)
) ENGINE=InnoDB;


CREATE TABLE client (
    id BIGINT NOT NULL,
    client_id VARCHAR(255) NOT NULL,
    password VARCHAR(255),
    status BIT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY UK_client_id (client_id),
    CONSTRAINT FK_client_person_id FOREIGN KEY (id) REFERENCES person (id),
    INDEX idx_client_id (client_id)  -- Creación del índice en client_id
) ENGINE=InnoDB;


INSERT INTO person (type_person, name, gender, age, identification, address, phone)
VALUES
('CLIENTE', 'John Doe', 'Male', 30, '1234567890', '123 Fake Street', '555-1234'),
('CLIENTE', 'Jane Smith', 'Female', 25, '2345678901', '742 Evergreen Terrace', '555-5678'),
('CLIENTE', 'Carlos Brown', 'Male', 40, '3456789012', '456 Dream Blvd', '555-9876'),
('CLIENTE', 'Anna White', 'Female', 35, '4567890123', '321 Forgotten Road', '555-8765'),
('CLIENTE', 'Louis Green', 'Male', 28, '5678901234', '789 Liberty Ave', '555-4321');

INSERT INTO client (client_id, password, status, id)
VALUES
('JD123', '1234', b'1', 1),
('JS456', '5678', b'1', 2),
('CB789', '1245', b'1', 3),
('AW012', '4589', b'1', 4),
('LG345', '8743', b'1', 5);




