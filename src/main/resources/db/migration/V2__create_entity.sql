create TABLE IF NOT EXISTS products (
    id SERIAL PRIMARY KEY,
    c_name VARCHAR(50) NOT NULL,
    c_price FLOAT NOT NULL,
    c_category VARCHAR(50),
    c_description VARCHAR(100)
);