CREATE TABLE IF NOT EXISTS orders (

      order_id serial PRIMARY KEY,
      order_number UUID UNIQUE NOT NULL,
      first_name VARCHAR(255) NOT NULL,
      last_name VARCHAR(255) NOT NULL,
      country VARCHAR(255),
      status VARCHAR(255) NOT NULL,
      created_at TIMESTAMP NOT NULL default current_timestamp
);