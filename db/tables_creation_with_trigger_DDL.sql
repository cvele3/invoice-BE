-- Create Sequence for PAYMENT_TYPES
CREATE SEQUENCE pay_typ_seq START WITH 1;

-- Table PAYMENT_TYPES
CREATE TABLE PAYMENT_TYPES (
    ID NUMBER PRIMARY KEY,
    type VARCHAR2(50) NOT NULL
);

-- Trigger for PAYMENT_TYPES
CREATE OR REPLACE TRIGGER pt_bir 
BEFORE INSERT ON PAYMENT_TYPES 
FOR EACH ROW
BEGIN
  :new.id := pay_typ_seq.NEXTVAL;
END;
/

-- Create Sequence for PRODUCTS
CREATE SEQUENCE prdSeq START WITH 1;

-- Table PRODUCTS
CREATE TABLE PRODUCTS (
    ID NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    description VARCHAR2(255),
    price NUMBER NOT NULL
);

-- Trigger for PRODUCTS
CREATE OR REPLACE TRIGGER prod_bir 
BEFORE INSERT ON PRODUCTS 
FOR EACH ROW
BEGIN
  :new.id := prdSeq.NEXTVAL;
END;
/

-- Create Sequence for INVOICES
CREATE SEQUENCE invSeq START WITH 1;

-- Table INVOICES
CREATE TABLE INVOICES (
    ID NUMBER PRIMARY KEY,
    invoice_date DATE NOT NULL,
    customer_name VARCHAR2(100) NOT NULL,
    invoice_number NUMBER NOT NULL,
    invoice_amount NUMBER NOT NULL,
    payment_type NUMBER,
    CONSTRAINT fk_paymentType FOREIGN KEY (payment_type) REFERENCES PAYMENT_TYPES(ID)
);
CREATE INDEX idx_invoices_customer ON INVOICES(customer_name);
CREATE INDEX idx_invoices_date ON INVOICES(invoice_date);

-- Trigger for INVOICES
CREATE OR REPLACE TRIGGER inv_bir 
BEFORE INSERT ON INVOICES 
FOR EACH ROW
BEGIN
  :new.id := invSeq.NEXTVAL;
END;
/

-- Create Sequence for INVOICE_ITEMS
CREATE SEQUENCE invItemSeq START WITH 1;

-- Table INVOICE_ITEMS
CREATE TABLE INVOICE_ITEMS (
    ID NUMBER PRIMARY KEY,
    invoice_id NUMBER NOT NULL,
    product_id NUMBER NOT NULL,
    quantity NUMBER NOT NULL,
    amount NUMBER NOT NULL,
    CONSTRAINT fk_invoice FOREIGN KEY (invoice_id) REFERENCES INVOICES(ID),
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES PRODUCTS(ID)
);
CREATE INDEX idx_invoice_items_invoice ON INVOICE_ITEMS(invoice_id);
CREATE INDEX idx_invoice_items_product ON INVOICE_ITEMS(product_id);

-- Trigger for INVOICE_ITEMS
CREATE OR REPLACE TRIGGER inv_item_bir 
BEFORE INSERT ON INVOICE_ITEMS 
FOR EACH ROW
BEGIN
  :new.id := invItemSeq.NEXTVAL;
END;
/