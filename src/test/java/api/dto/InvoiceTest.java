package api.dto;

import api.base.BaseTest;
import api.client.InvoiceClient;
import api.dto.DTOFactories.InvoiceFactory;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceTest extends BaseTest {

    @Test
    public void getInvoices(){

        InvoiceClient client = new InvoiceClient();

        Response getResponse = client.getInvoices();

        getResponse.then().statusCode(200);

    }


        @Test
        public void createInvoice(){

            InvoiceDTO invoiceBody = InvoiceFactory.createInvoice();
            InvoiceClient client = new InvoiceClient();

            Response response = client.postInvoice(invoiceBody);
            response.then().statusCode(201);

            int id = response.jsonPath().getInt("id");

            Response getResponse = client.getExactInvoice(id);
            getResponse.then().statusCode(200);

            Assertions.assertEquals(invoiceBody.getToAddress(),
                    getResponse.jsonPath().getString("to_address"));







    }
}
