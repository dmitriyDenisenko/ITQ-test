CREATE TABLE IF NOT EXISTS public.orders
(
    id bigint PRIMARY KEY NOT NULL,
    customer_name character varying(256) NOT NULL,
    customer_address character varying(256) NOT NULL,
    total_count integer NOT NULL,
    date date NOT NULL
);

CREATE TABLE IF NOT EXISTS public.order_details
(
    id bigint NOT NULL,
    product_number character varying(256) NOT NULL,
    product_name character varying(256) NOT NULL,
    product_count integer NOT NULL,
    order_id bigint NOT NULL,
    CONSTRAINT order_details_pkey PRIMARY KEY (id),
    CONSTRAINT fk_order_details_orders FOREIGN KEY (order_id)
        REFERENCES public.orders (id) ON UPDATE NO ACTION ON DELETE NO ACTION
);

INSERT INTO public.orders (id, customer_name, customer_address, total_count, date)
VALUES
  (1, 'Customer1', 'Address1', 10, '2023-11-15'),
  (2, 'Customer2', 'Address2', 20, '2023-11-16'),
  (3, 'Customer3', 'Address3', 15, '2023-11-17'),
  (4, 'Customer4', 'Address4', 25, '2023-11-18'),
  (5, 'Customer5', 'Address5', 30, '2023-11-19'),
  (6, 'Customer6', 'Address6', 31, '2023-11-19');

INSERT INTO public.order_details (id, product_number, product_name, product_count, order_id)
VALUES
  (1, '101', 'Product1', 5, 1),
  (2, '102', 'Product2', 10, 1),
  (3, '103', 'Product3', 8, 2),
  (4, '104', 'Product4', 15, 3),
  (5, '105', 'Product5', 20, 4);
