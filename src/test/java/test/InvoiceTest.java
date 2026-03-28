package test;

import api.base.BaseTest;
import api.client.InvoiceClient;
import api.client.DTOFactories.InvoiceFactory;
import api.dto.SendEmailDTO;
import api.dto.InvoiceDTO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;


public class InvoiceTest extends BaseTest {



    //TODO Add an information that makes the project well written in company good practises
    //TODO example:  /**
    //     * Sends POST request to /login/token
    //     *
    //     * @param email    email
    //     * @param password password
    //     * @param domain   company name
    //     * @return Response
    //     */
}
