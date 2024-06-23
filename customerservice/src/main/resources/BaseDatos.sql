CREATE SCHEMA `customerdb` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE customerdb.person (
    id BIGINT NOT NULL AUTO_INCREMENT,
    address VARCHAR(255) NOT NULL,
    age INTEGER,
    gender VARCHAR(255),
    identification VARCHAR(255),
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB;


CREATE TABLE customerdb.client (
    id BIGINT NOT NULL PRIMARY KEY,
    client_id VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    status BIT NOT NULL,
    UNIQUE KEY UK_client_id (client_id),
    CONSTRAINT FK_client_person_id FOREIGN KEY (id) REFERENCES person (id),
    INDEX idx_client_id (client_id)
) ENGINE=InnoDB;


INSERT INTO customerdb.person (name, gender, age, identification, address, phone)
VALUES
('John Doe', 'MALE', 30, '1234567890', '123 Fake Street', '5551234'),
('Jane Smith', 'FEMALE', 25, '2345678901', '742 Evergreen Terrace', '5555678'),
('Carlos Brown', 'MALE', 40, '3456789012', '456 Dream Blvd', '5559876'),
('Anna White', 'FEMALE', 35, '4567890123', '321 Forgotten Road', '5558765'),
('Louis Green', 'MALE', 28, '5678901234', '789 Liberty Ave', '5554321');

INSERT INTO customerdb.client (client_id, password, status, id)
VALUES
('JD123', '1234', b'1', 1),
('JS456', '5678', b'1', 2),
('CB789', '1245', b'1', 3),
('AW012', '4589', b'1', 4),
('LG345', '8743', b'1', 5);




