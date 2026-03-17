package test;

import api.base.BaseTest;
import api.client.FirmClient;
import api.dto.FirmDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirmTest extends BaseTest {

    @Test
    public void getFirmInfo() {

        FirmClient client = new FirmClient();

        Response response = client.getFirmInfo();

        response.prettyPrint();
        response.then().statusCode(200);

    }


    @Test
    public void UpdateALlFirmData() {

        FirmClient client = new FirmClient();
        Response getFirmInfoResponse = client.getFirmInfo();
        getFirmInfoResponse.then().statusCode(200);

        FirmDTO patchBody = new FirmDTO(
                "patch1"
                , "7895467"
                , "patchedTown"
                , "Patched address 1"
                , "kirikam62@gmail.com");

        Response patchResponse = client.patchFirmData(patchBody);


        Response verifyResponse = client.getFirmInfo();
        patchResponse.then().statusCode(204);


        String updatedName = verifyResponse.jsonPath().getString("name");
        String updatedEmail = verifyResponse.jsonPath().getString("email");
        String updatedTown = verifyResponse.jsonPath().getString("town");
        String updatedBulstat = verifyResponse.jsonPath().getString("bulstat");

        Assertions.assertAll(
                () -> Assertions.assertEquals("patch1", updatedName),
                () -> Assertions.assertEquals("kirikam62@gmail.com", updatedEmail),
                () -> Assertions.assertEquals("patchedTown", updatedTown)
        );


    }


}
