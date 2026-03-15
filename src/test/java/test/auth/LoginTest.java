package test.auth;

import api.base.BaseTest;
import api.client.AuthClient;
import api.dto.LoginRequestDTO;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginSuccessfully(){

        AuthClient client = new AuthClient();

        LoginRequestDTO request =
                new LoginRequestDTO(
                        "kirikam62@gmail.com",
                        "parola123",
                        "kam"
                );

        Response response = client.loginWithoutAuth(request);

        response.then().statusCode(200);

        String token = response.jsonPath().getString("token");

        Assertions.assertNotNull(token);
        Assertions.assertFalse(token.isEmpty());



    }
}
