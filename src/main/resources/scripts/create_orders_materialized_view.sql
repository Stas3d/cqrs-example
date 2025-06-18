CREATE MATERIALIZED VIEW orders_view AS
SELECT order_number, first_name, last_name, country, status, created_at
FROM orders
WITH DATA;

CREATE FUNCTION refresh_orders()
    RETURNS TRIGGER LANGUAGE plpgsql
    AS $$
        BEGIN REFRESH MATERIALIZED VIEW CONCURRENTLY orders_view;
        RETURN NULL;
    END $$;

CREATE TRIGGER refresh_orders_after_insert
AFTER INSERT
ON orders
FOR EACH STATEMENT
EXECUTE PROCEDURE refresh_orders();
