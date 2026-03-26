package api.endPoints;

public class InvoiceEndPoints {

    public static final String GET_INVOICE = "/invoices";
    public static final String INVOICE_BY_ID = "/invoices/{id}";
    public static final String INVOICE_PAYMENT_STATUS = GET_INVOICE + "/payment-statuses";
    public static final String INVOICE_HISTORY = GET_INVOICE + "/history";
    public static final String SEND_EMAIL = GET_INVOICE + "/{id}/emails";



}
