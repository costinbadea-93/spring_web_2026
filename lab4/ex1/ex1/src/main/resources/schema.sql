CREATE TABLE IF NOT EXISTS BANK_ACCOUNT
(
    id                 INT AUTO_INCREMENT PRIMARY KEY,
    account_number     VARCHAR(100),
    account_owner_name VARCHAR(100),
    account_balance    DOUBLE PRECISION
    );
