CREATE TABLE flowers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    color VARCHAR(50),
    price DECIMAL(10, 2)
);

INSERT INTO flowers (name, color, price) VALUES
('Rose', 'Red', 2.50),
('Tulip', 'Yellow', 1.80),
('Lily', 'White', 3.00);
