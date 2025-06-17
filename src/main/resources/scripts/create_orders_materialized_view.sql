CREATE MATERIALIZED VIEW orders_view AS
SELECT order_number, first_name, last_name, country, status, created_on
FROM orders
WITH DATA;


CREATE FUNCTION refresh_orders()
    RETURN TRIGGER LANGUAGE plpgsql
    AS $$
        BEGIN REFRESH MATERIALIZED VIEW CONCURRENTLY orders_view;
        RETURN NULL;
    END $$;


CREATE TRIGGER refresh_orders_after_insert
ON orders
FOR EACH STATEMENT
EXECUTE PROCEDURE refresh_orders();
