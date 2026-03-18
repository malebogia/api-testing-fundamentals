package test.invoice;

import api.base.BaseTest;
import api.client.InvoiceClient;
import api.dto.DTOFactories.InvoiceFactory;
import api.dto.InvoiceDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.core.Is.is;


public class InvoiceTest extends BaseTest {

    @Test
    public void getInvoices() {

        InvoiceClient client = new InvoiceClient();

        Response getResponse = client.getInvoices();

        getResponse.then().statusCode(200);

    }


    @Test
    public void createInvoice() {

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


    @Test
    public void updateInvoice() {

        InvoiceClient invoiceClient = new InvoiceClient();

        InvoiceDTO invoiceBody = InvoiceFactory.createInvoice();

        Response postResponse = invoiceClient.postInvoice(invoiceBody);
        int id = postResponse.jsonPath().getInt("id");

        invoiceBody.setToMol("Doctor Who");


        Response patchResponse = invoiceClient.patchInvoice(id, invoiceBody);
        patchResponse.then().statusCode(204);


        Response getResponse = invoiceClient.getExactInvoice(id);

        getResponse.then()
                .statusCode(200)
                .body("to_mol", org.hamcrest.Matchers.equalTo(invoiceBody.getToMol()));

        // worse assertion
        // Assertions.assertEquals(invoiceBody.getToMol(), getResponse.jsonPath().getString("to_mol"));

    }


    @Test
    public void deleteInvoice() {

        InvoiceDTO invoice = InvoiceFactory.createInvoice();
        InvoiceClient client = new InvoiceClient();

        Response postResponse = client.postInvoice(invoice);

        int id = postResponse.jsonPath().getInt("id");

        Response deleteResponse = client.deleteInvoice(id);
        deleteResponse.then().statusCode(204);

        Response secondDelete = client.deleteInvoice(id);
        secondDelete.then().statusCode(anyOf(is(204), is(404)));

        Response getResponse = client.getExactInvoice(id);
        getResponse.then().statusCode(404);

    }


}
