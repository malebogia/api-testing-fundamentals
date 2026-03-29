package api.client;

import api.base.BaseService;
import api.dto.LoginRequestDTO;
import api.endPoints.EndPoints;
import api.utils.LanguageHeader;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AuthClient extends BaseService {



    /**
     * Sends POST request to /login/token
     *
     * @param loginRequest login request DTO containing email, password and domain
     * @return Response
     */

    @Step("Login with valid credentials")
    public Response login(LoginRequestDTO loginRequest) {
        return post(EndPoints.LOGIN,loginRequest,false, LanguageHeader.EN);
    }



    @Step("login without authentication header")
    public Response loginWithoutAuth(LoginRequestDTO loginRequest) {
        return given()
                .spec(RestAssured.requestSpecification)
                .body(loginRequest)
                .when()
                .post(EndPoints.LOGIN)
                .then()
                .log().ifValidationFails()
                .extract()
                .response();
    }


}
