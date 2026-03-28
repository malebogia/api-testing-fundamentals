package api.client;

import api.base.BaseService;
import api.dto.SendEmailDTO;
import api.endPoints.InvoiceEndPoints;
import api.dto.InvoiceDTO;
import io.restassured.response.Response;

import java.util.Map;

public class InvoiceClient extends BaseService {

    public Response getInvoices() {
        return getWithAuth(InvoiceEndPoints.GET_INVOICE);

    }

    public Response getInvoiceWithoutAuth(){

        return getWithoutAut(InvoiceEndPoints.GET_INVOICE);

    }


}
