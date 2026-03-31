package test;

import api.base.BaseTest;
import api.client.FirmClient;
import api.dto.FirmDTO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

public class FirmTest extends BaseTest {

    private FirmClient client;

    @BeforeEach
    void setContext(){
        client = new FirmClient();
    }

    @Test
    public void getFirmInfo() {

        Response response = client.getFirmInfoEn();

        response.prettyPrint();
        response.then().statusCode(200);

    }

    @Test
    @Tag("positive")
    @DisplayName("Get firm info without Auth")
    public void getFirmInfoNoAuth() {

        Response response = client.getFirmInfoNoAuthEn();

        response.then()
                .statusCode(401)
                .contentType(ContentType.JSON);

        String status = response.jsonPath().getString("status");
        String message = response.jsonPath().getString("message");

        Assertions.assertAll(
                () -> Assertions.assertEquals("error", status),
                () -> Assertions.assertEquals("Token not found.", message)
        );


    }


    @Test
    @DisplayName("Update firm info")
    @Tag("positive")
    public void updateFirmInfo() {

        FirmDTO patchBody = new FirmDTO(
                "patch1"
                , "7895467"
                , "patchedTown"
                , "Patched address 1"
                , "kirikam62@gmail.com");


        Response response = client.patchFirmInfoEnLang(patchBody);

        response.then().statusCode(204);

        Response getResponse = client.getFirmInfoEn();

        String updatedName = getResponse.jsonPath().getString("name");
        String updatedBulstat = getResponse.jsonPath().getString("bulstat");
        String updatedEmail = getResponse.jsonPath().getString("email");



        Assertions.assertAll(
                () -> Assertions.assertEquals(patchBody.getName(), updatedName),
                () -> Assertions.assertEquals(patchBody.getBulstat(), updatedBulstat),
                () -> Assertions.assertEquals(patchBody.getEmail(),updatedEmail)
                );

    }

    @Test
    @Tag("negative")
    @DisplayName("Attempt to update firm info without valid Auth.")
    public void updateFirmInfoNoToken(){

        FirmDTO patchBody = new FirmDTO(
                "patch1"
                , "7895467"
                , "patchedTown"
                , "Patched address 1"
                , "kirikam62@gmail.com");

        Response response = client.patchFirmInfoEnLangNoAuth(patchBody);

        String status = response.jsonPath().getString("status");
        String message = response.jsonPath().getString("message");

        response.then().statusCode(401);

        Assertions.assertAll(
                () -> Assertions.assertEquals("error",status),
                () -> Assertions.assertEquals("Token not found.", message)
        );





    }








}
