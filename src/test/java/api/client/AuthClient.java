package api.client;

import api.base.BaseService;
import api.dto.LoginRequestDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AuthClient extends BaseService {


    public Response login(LoginRequestDTO loginRequest) {
        return postWithoutAut("login/token", loginRequest);
    }



    public Response loginWithoutAuth(LoginRequestDTO loginRequest) {
        return given()
                .spec(RestAssured.requestSpecification)
                .body(loginRequest)
                .when()
                .post("login/token")
                .then()
                .log().ifValidationFails()
                .extract()
                .response();
    }


}
