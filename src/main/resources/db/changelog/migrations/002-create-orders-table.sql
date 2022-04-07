CREATE TABLE jdbctemplate.orders (
                                     id int auto_increment primary key ,
                                     date date,
                                     customer_id int,
                                     product_name varchar(250),
                                     amound int,
                                     FOREIGN KEY (customer_id)
                                         REFERENCES jdbctemplate.customer(id)
);