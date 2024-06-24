
CREATE SCHEMA IF NOT EXISTS `customerdb` DEFAULT CHARACTER SET utf8;

DROP TABLE IF EXISTS customerdb.client;
DROP TABLE IF EXISTS customerdb.person;

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


CREATE SCHEMA IF NOT EXISTS `accountdb` DEFAULT CHARACTER SET utf8;

DROP TABLE IF EXISTS accountdb.movement;
DROP TABLE IF EXISTS accountdb.account;


CREATE TABLE accountdb.account (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_id VARCHAR(255) UNIQUE NOT NULL,
    client_id VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL,
    balance DECIMAL(19, 2) NOT NULL,
    status BOOLEAN NOT NULL,
    UNIQUE KEY UK_account_id (account_id),
    INDEX idx_account_id (account_id),
    INDEX idx_client_id (client_id)
);

INSERT INTO accountdb.account (account_id, client_id, type, balance, status)
VALUES
('478758', 'JD123', 'SAVINGS', 5000.00, true),
('225689', 'JD123', 'CURRENT', 4655.00, true),
('225690', 'JS456', 'CURRENT', 4655.00, true),
('478759', 'CB789', 'SAVINGS', 132.00, true),
('475489', 'AW012', 'SAVINGS', 2356.00, true),
('225691', 'LG345', 'CURRENT', 9874.00, true);

CREATE TABLE accountdb.movement (
    id BIGINT NOT NULL AUTO_INCREMENT,
    account_id VARCHAR(255) NOT NULL,
    date TIMESTAMP NOT NULL,
    amount DOUBLE NOT NULL,
    type VARCHAR(255) NOT NULL,
    balance DOUBLE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (account_id) REFERENCES account(account_id)
);

INSERT INTO accountdb.movement (account_id, date, type, amount, balance)
VALUES
('478758', '2024-06-21', 'DEPOSIT', 1000.00, 6000.00),
('478758', '2024-06-22', 'WITHDRAWAL', -500.00, 5500.00),
('478758','2024-06-23', 'WITHDRAWAL', -200.00, 5300.00),
('225689', '2024-06-21', 'DEPOSIT', 500.00, 5155.00),
('225689', '2024-06-20', 'WITHDRAWAL', -300.00, 4855.00),
('225689', '2024-06-22', 'DEPOSIT', 100.00, 4955.00),
('225690', '2024-06-10', 'DEPOSIT', 1000.00, 5655.00),
('225690', '2024-06-15', 'WITHDRAWAL', -700.00, 4955.00),
('225690', '2024-06-16', 'DEPOSIT', 300.00, 5255.00),
('478759', '2024-06-20', 'DEPOSIT', 50.00, 182.00),
('478759', '2024-06-15', 'WITHDRAWAL', -80.00, 102.00),
('478759', '2024-06-01', 'DEPOSIT', 32.00, 134.00),
('475489', '2024-06-05', 'DEPOSIT', 200.00, 2556.00),
('475489', '2024-06-10', 'WITHDRAWAL', -300.00, 2256.00),
('475489','2024-06-15', 'DEPOSIT', 456.00, 2712.00);




