CREATE SCHEMA `accountdb` DEFAULT CHARACTER SET utf8;

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
