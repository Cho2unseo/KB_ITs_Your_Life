DROP TABLE IF EXISTS tbl_restaurant;

CREATE TABLE tbl_restaurant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    category VARCHAR(100),
    address VARCHAR(255),
    description TEXT
);