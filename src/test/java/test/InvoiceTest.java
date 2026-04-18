package test;

import api.base.BaseTest;
import api.client.InvoiceClient;
import api.client.DTOFactories.InvoiceFactory;
import api.dto.SendEmailDTO;
import api.dto.InvoiceDTO;
import api.utils.LanguageHeader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;


public class InvoiceTest extends BaseTest {

    @Test
    @DisplayName("Filter invoices by type and search term")
    @Tag("positive")
    public void FilterInvoices() {

        InvoiceClient client = new InvoiceClient();

        Map<String, Object> filters = Map.of(

                "per_page", 10,
                "page", 1,
                "order", "desc",
                "type", "deb", // Filter for debit invoices
                "search", "Software"

        );

        Response response = client.getInvoicesWithParams(filters, LanguageHeader.EN);

        response.then().statusCode(201);

    }


    @Test
    @DisplayName("Create invoice")
    @Tag("positive")
    public void CreateInvoice() {

        InvoiceDTO invoiceBody = InvoiceFactory.createInvoice();
        InvoiceClient client = new InvoiceClient();

        Response response = client.postInvoice(invoiceBody, true, LanguageHeader.EN);

        int invoiceId = response.jsonPath().getInt("id");

        response.then().statusCode(201);


       Response newInvoiceResponse = client.getInvoiceById(invoiceId,true,LanguageHeader.EN);

       InvoiceDTO actualInvoice = newInvoiceResponse.jsonPath().getObject("", InvoiceDTO.class);



        Assertions.assertEquals(invoiceBody.getToBulstat(), actualInvoice.getToBulstat()

        );


    }

    @Test
    @DisplayName("Send document Email")
    @Tag("Positive")
    public void sendEmail(){

        SendEmailDTO emailBody = new SendEmailDTO("naydinidis@gmail.com");
        InvoiceDTO invoiceBody = InvoiceFactory.createInvoice();

        InvoiceClient client = new InvoiceClient();

        Response postInvoiceResponse = client.postInvoice(invoiceBody,true,LanguageHeader.EN);
        postInvoiceResponse.then().log().all();
 //        int invoiceId = postInvoiceResponse.jsonPath().getInt("id");


/*

        Response sendEmailResponse = client.sendEmailWithDocument(invoiceId,emailBody);

        sendEmailResponse.then().statusCode(200);

        String message = sendEmailResponse.jsonPath().getString("message");

        Assertions.assertEquals("The document was sent", message);
*/




    }





}
