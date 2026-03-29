package test.auth;

import api.client.AuthClient;
import api.dto.LoginRequestDTO;
import api.utils.ConfigReader;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ObjectInputFilter;

public class TokenManager {

    private static final Logger logger = LogManager.getLogger(TokenManager.class);

    private static String token;

    public static String getToken() {

        if (token == null) {

            logger.info("Generating new token...");

            AuthClient client = new AuthClient();

            LoginRequestDTO requestDTO =
                    new LoginRequestDTO(
                            ConfigReader.getProperty("user.email"),
                            ConfigReader.getProperty("user.password"),
                            ConfigReader.getProperty("user.domain"));

            Response response = client.loginWithoutAuth(requestDTO);

            token = response.jsonPath().getString("token");

            logger.debug("Token received: {}", token);

        }

        return token;

    }
}
