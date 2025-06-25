CREATE FUNCTION refresh_orders()
    RETURNS TRIGGER LANGUAGE plpgsql
    AS $$
        BEGIN REFRESH MATERIALIZED VIEW CONCURRENTLY orders_mview;
        RETURN NULL;
    END $$;

CREATE TRIGGER refresh_orders_after_insert
AFTER INSERT
ON orders
FOR EACH STATEMENT
EXECUTE PROCEDURE refresh_orders();
