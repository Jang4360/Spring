--CREATE TABLE IF NOT EXISTS purchase (
--    id INT AUTO_INCREMENT PRIMARY KEY,
--    product VARCHAR(50) NOT NULL,
--    price DECIMAL(10,2) NOT NULL
--);
create table account(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    amount DOUBLE NOT NULL
);