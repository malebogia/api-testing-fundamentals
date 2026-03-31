package api.client;

import api.base.BaseService;
import api.endPoints.InvoiceEndPoints;
import api.utils.LanguageHeader;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.Map;

public class InvoiceClient extends BaseService {


    /**
     * Fetches a list of invoices with optional filtering and pagination.
     * * @param queryParams Map containing keys like:
     * "order_by" (string),
     * "order" (asc/desc),
     * "per_page" (1-1000),
     * "page" (int),
     * "search" (string),
     * "type" (deb, cred, prof, etc.)
     *
     * @param lang The preferred language for the response
     * @return Response   The API response object
     */


        @Step("Fetch invoices with filters: {queryParams}")
        public Response getInvoicesWithParams (Map < String, Object > queryParams, LanguageHeader lang ){

            return getWithParams(InvoiceEndPoints.GET_INVOICE,queryParams,true,lang);

        }





}



