CREATE TABLE CUSTOMERS (
                           id int auto_increment primary key,
                           name varchar(15) NOT NULL ,
                           surname varchar(25) NOT NULL ,
                           age int check ( age BETWEEN 0 AND 120),
                           phone_number varchar(12)
);

CREATE TABLE ORDERS (
                        id serial primary key ,
                        date date,
                        customer_id int,
                        product_name varchar(250),
                        amound int,
                        FOREIGN KEY (customer_id)
                            REFERENCES CUSTOMERS(id)
);