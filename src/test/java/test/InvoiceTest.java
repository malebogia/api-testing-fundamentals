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
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;


public class InvoiceTest extends BaseTest {

    @Test
    @DisplayName("Filter invoices by type and search term")
    public void testFilterInvoices(){

        InvoiceClient client = new InvoiceClient();

        Map<String,Object> filters = Map.of(

                "per_page", 10,
                "page", 1,
                "order", "desc",
                "type", "deb", // Filter for debit invoices
                "search", "Software"

        );

        Response response = client.getInvoicesWithParams(filters, LanguageHeader.EN);

        response.then().statusCode(201);

    }



}
