package test.auth;

import api.client.AuthClient;
import api.dto.LoginRequestDTO;
import api.utils.ConfigReader;
import io.restassured.response.Response;

import java.io.ObjectInputFilter;

public class TokenManager {

    private static String token;

    public static String getToken() {

        if (token == null) {

            AuthClient client = new AuthClient();

            LoginRequestDTO requestDTO =
                    new LoginRequestDTO(
                            ConfigReader.getProperty("user.email"),
                            ConfigReader.getProperty("user.password"),
                            ConfigReader.getProperty("user.domain"));

            Response response = client.loginWithoutAuth(requestDTO);

            token = response.jsonPath().getString("token");

        }

        return token;

    }
}
