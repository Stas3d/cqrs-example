CREATE MATERIALIZED VIEW orders_mview AS
SELECT order_number, first_name, last_name, country, status, created_at
FROM orders
WITH DATA;

CREATE UNIQUE INDEX ON orders_mview (order_number);
