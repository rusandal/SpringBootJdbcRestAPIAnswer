SELECT o.product_name FROM orders o JOIN customer C on C.id = o.customer_id WHERE name=:name;