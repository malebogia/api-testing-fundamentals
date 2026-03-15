package test.auth;

import api.client.AuthClient;
import api.dto.LoginRequestDTO;
import io.restassured.response.Response;

public class TokenManager {

    private static String token;

    public static String getToken() {

        if (token == null) {

            AuthClient client = new AuthClient();

            LoginRequestDTO requestDTO =
                    new LoginRequestDTO(
                            "kirikam62@gmail.com",
                            "parola123",
                            "kam");

            Response response = client.loginWithoutAuth(requestDTO);

            token = response.jsonPath().getString("token");

        }

        return token;

    }
}
