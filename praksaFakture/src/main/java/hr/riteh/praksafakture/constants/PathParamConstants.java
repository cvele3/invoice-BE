package hr.riteh.praksafakture.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PathParamConstants {
    public static final String GET_ALL_INVOICE_ITEMS_FROM_INVOICE_ID = "/getAllInvoiceItemsFromInvoiceId";
    public static final String GET_ALL_INVOICES = "/getAllInvoices";
    public static final String GET_ALL_PAYMENT_TYPES = "/getAllPaymentTypes";
    public static final String GET_ALL_PRODUCTS = "/getAllProducts";
    public static final String GET_PRODUCT_BY_ID = "/getProductById";
    public static final String CREATE_PRODUCT = "/createProduct";
    public static final String UPDATE_PRODUCT = "/updateProduct";
    public static final String DELETE_PRODUCT = "/deleteProduct";
    public static final String GET_PAYMENT_TYPE_BY_ID = "/getPaymentTypeById";
    public static final String CREATE_PAYMENT_TYPE = "/createPaymentType";
    public static final String UPDATE_PAYMENT_TYPE = "/updatePaymentType";
    public static final String DELETE_PAYMENT_TYPE = "/deletePaymentType";
    public static final String CREATE_INVOICE = "/createInvoice";
    public static final String UPDATE_INVOICE = "/updateInvoice";
    public static final String DELETE_INVOICE = "/deleteInvoice";
    public static final String GET_INVOICE_BY_ID = "/getInvoiceById";
    public static final String GET_INVOICE_ITEM_BY_ID = "/getInvoiceItemById";
}
