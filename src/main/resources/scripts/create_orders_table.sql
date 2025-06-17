CREATE TABLE IF NOT EXISTS orders (

      order_id serial PRIMARY KEY,
      order_number VARCHAR(255) UNIQUE NOT NULL,
      first_name VARCHAR(255) UNIQUE NOT NULL,
      last_name VARCHAR(255),
      country VARCHAR(255),
      status VARCHAR(255) NOT NULL,
      created_on TIMESTAMP default current_timestamp,
);