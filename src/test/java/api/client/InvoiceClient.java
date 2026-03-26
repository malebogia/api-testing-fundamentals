package api.client;

import api.base.BaseService;
import api.dto.SendEmailDTO;
import api.endPoints.InvoiceEndPoints;
import api.dto.InvoiceDTO;
import io.restassured.response.Response;

import java.util.Map;

public class InvoiceClient extends BaseService {

    public Response getInvoices() {
        return get(InvoiceEndPoints.GET_INVOICE);

    }

    public Response getInvoiceWithoutAuth(){

        return getWithoutAuth(InvoiceEndPoints.GET_INVOICE);

    }

    public Response getInvoicesWithParam(Map<String, Object> queryParams) {

        return request()
                .queryParams(queryParams)
                .when()
                .get(InvoiceEndPoints.GET_INVOICE);
    }

    public Response getExactInvoice(int id) {
        return request()
                .pathParam("id", id)
                .when()
                .get(InvoiceEndPoints.INVOICE_BY_ID);


    }

    public Response postInvoice(InvoiceDTO invoice) {

        return post(InvoiceEndPoints.GET_INVOICE, invoice);

    }

    public Response patchInvoice(int id, InvoiceDTO invoice) {
        return request()
                .pathParam("id", id)
                .body(invoice)
                .when()
                .patch(InvoiceEndPoints.INVOICE_BY_ID);

    }

    public Response deleteInvoice(int id) {
        return request()
                .pathParam("id", id)
                .when()
                .delete(InvoiceEndPoints.INVOICE_BY_ID);


    }


    public Response getInvoicePaymentStatus(){

        return get(InvoiceEndPoints.INVOICE_PAYMENT_STATUS);

    }

    public Response getInvoiceHistory(){

        return get(InvoiceEndPoints.INVOICE_HISTORY);

    }

    public Response postEMail(int id, SendEmailDTO sendEmailDTO){
        return request()
                .pathParam("id",id)
                .body(sendEmailDTO)
                .when()
                .post(InvoiceEndPoints.SEND_EMAIL);


    }






}
