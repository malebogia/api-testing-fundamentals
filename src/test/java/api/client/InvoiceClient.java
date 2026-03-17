package api.client;

import api.base.BaseService;
import api.base.InvoiceEndPoints;
import api.dto.InvoiceDTO;
import io.restassured.response.Response;

import java.util.Map;

public class InvoiceClient extends BaseService {

    public Response getInvoices(){
       return get(InvoiceEndPoints.getInvoices);

    }

    public Response getInvoicesWithParam(Map<String,Object> queryParams){

        return request()
                .queryParams(queryParams)
                .when()
                .get(InvoiceEndPoints.getInvoices);
    }

    public Response getExactInvoice(int id){
        return request()
                .pathParam("id",id)
                .when()
                .get(InvoiceEndPoints.INVOICE_BY_ID);


    }

    public Response postInvoice(InvoiceDTO invoice){

       return post(InvoiceEndPoints.getInvoices,invoice);

    }




}
