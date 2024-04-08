-- Populate PAYMENT_TYPES table
INSERT INTO PAYMENT_TYPES (ID, type) VALUES (1, 'Cash');
INSERT INTO PAYMENT_TYPES (ID, type) VALUES (2, 'Credit Card');

-- Populate PRODUCTS table
INSERT INTO PRODUCTS (ID, name, description, price) VALUES (1, 'Wireless Mouse', 'High-precision wireless mouse with ergonomic design', 29.99);
INSERT INTO PRODUCTS (ID, name, description, price) VALUES (2, 'Bluetooth Earbuds', 'True wireless Bluetooth earbuds with noise-cancelling technology', 79.99);
INSERT INTO PRODUCTS (ID, name, description, price) VALUES (3, 'Portable SSD', 'Portable solid-state drive for fast and reliable storage', 99.99);
INSERT INTO PRODUCTS (ID, name, description, price) VALUES (4, 'Gaming Keyboard', 'Mechanical gaming keyboard with customizable RGB lighting', 149.99);
INSERT INTO PRODUCTS (ID, name, description, price) VALUES (5, 'Smartwatch', 'Fitness-tracking smartwatch with heart rate monitor and GPS', 199.99);

-- Populate INVOICES table
INSERT INTO INVOICES (ID, invoice_date, customer_name, invoice_number, invoice_amount, payment_type) VALUES (1, TO_DATE('01-04-2024', 'DD-MM-YYYY'), 'John Smith', 1001, 59.98, 1);
INSERT INTO INVOICES (ID, invoice_date, customer_name, invoice_number, invoice_amount, payment_type) VALUES (2, TO_DATE('02-04-2024', 'DD-MM-YYYY'), 'Emma Johnson', 1002, 549.96, 2);
INSERT INTO INVOICES (ID, invoice_date, customer_name, invoice_number, invoice_amount, payment_type) VALUES (3, TO_DATE('03-04-2024', 'DD-MM-YYYY'), 'David Brown', 1003, 999.95, 1);

-- Populate INVOICE_ITEMS table
INSERT INTO INVOICE_ITEMS (ID, invoice_id, product_id, quantity, amount) VALUES (1, 1, 1, 2, 59.98);
INSERT INTO INVOICE_ITEMS (ID, invoice_id, product_id, quantity, amount) VALUES (2, 2, 3, 1, 99.99);
INSERT INTO INVOICE_ITEMS (ID, invoice_id, product_id, quantity, amount) VALUES (3, 2, 4, 3, 449.97);
INSERT INTO INVOICE_ITEMS (ID, invoice_id, product_id, quantity, amount) VALUES (4, 3, 5, 5, 999.95);
