package api.base;

import api.utils.ConfigReader;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.client.methods.RequestBuilder;
import org.junit.jupiter.api.BeforeAll;
import test.auth.TokenManager;

import static io.restassured.RestAssured.given;

public class BaseService {


    //TODO Change LOG().ALL() to .log().ifValidationFails()

    protected RequestSpecification request() {
        return given()
                .spec(RestAssured.requestSpecification)
                .header("Authorization", "Bearer " + TokenManager.getToken());
    }





    protected Response get(String endpoint){
        return  request()
                .when()
                .get(endpoint)
                .then()
                .log().ifValidationFails()
                .extract().
                response();

    }

    protected Response post(String endpoint, Object body){
        return  request()
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .log().ifValidationFails()
                .extract().response();

    }

    protected Response put(String endpoint, Object body) {
        return request()
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract().response();
    }

    protected Response patch(String endpoint, Object body){
        return  request()
                .body(body)
                .when()
                .patch(endpoint)
                .then()
                .extract().response();
    }


    protected Response delete(String endpoint){
        return request()
                .when()
                .delete(endpoint)
                .then()
                .extract().
                response();

    }








}
