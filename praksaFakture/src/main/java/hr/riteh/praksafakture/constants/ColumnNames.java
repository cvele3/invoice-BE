package hr.riteh.praksafakture.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ColumnNames {
    // Common column
    public static final String ID = "ID";

    // PAYMENT_TYPES columns
    public static final String TYPE = "type";

    // PRODUCTS columns
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String PRICE = "price";

    // INVOICES columns
    public static final String INVOICE_DATE = "invoice_date";
    public static final String CUSTOMER_NAME = "customer_name";
    public static final String INVOICE_NUMBER = "invoice_number";
    public static final String INVOICE_AMOUNT = "invoice_amount";
    public static final String PAYMENT_TYPE = "payment_type";

    // INVOICE_ITEMS columns
    public static final String QUANTITY = "quantity";
    public static final String AMOUNT = "amount";
    public static final String INVOICE_ID = "invoice_id";
    public static final String PRODUCT_ID = "product_id";
}
