package api.base;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import test.auth.TokenManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseService {

    protected static final Logger logger = LogManager.getLogger(BaseService.class);


    protected RequestSpecification request(Boolean withAuth) {

        RequestSpecification spec = given()
                .filter(new AllureRestAssured());
        if (withAuth) {
            spec.header("Authorization", "Bearer " + TokenManager.getToken());
        }

        return spec;
    }


    private Response get(String endpoint, boolean userAuth) {
        logger.info("GET {}", endpoint);
        return request(userAuth)
                .when()
                .get(endpoint)
                .then()
                .log().ifValidationFails()
                .extract().
                response();

    }

    @Step("GET {endpoint} (Auth)")
    protected Response getWithAuth(String endpoint) {
        return get(endpoint, true);
    }

    @Step("GET {endpoint} (No Auth)")
    protected Response getWithoutAut(String endpoint) {
        return get(endpoint, false);
    }


    protected Response getWithPath(String endpoint, String paramName, Object paramValue, boolean withAuth) {
        logger.info("GET {} with {}={}", endpoint, paramName, paramValue);
        return request(withAuth)
                .pathParam(paramName, paramValue)
                .when()
                .get(endpoint)
                .then()
                .log().ifValidationFails()
                .extract().response();
    }


    protected Response getWithParams(String endpoint, Map<String, ?> queryParams, boolean withAuth) {
        logger.info("GET {} with params {}", endpoint, queryParams);
        return request(withAuth)
                .queryParams(queryParams)
                .when()
                .get(endpoint)
                .then()
                .log().ifValidationFails()
                .extract().response();
    }


    private Response post(String endpoint, Object body, boolean userAuth) {
        logger.info("POST {}", endpoint);

        return request(userAuth)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .log().ifValidationFails()
                .extract().response();

    }

    @Step("POST {endpoint} (Auth)")
    protected Response postWithAut(String endpoint, Object body) {
        return post(endpoint, body, true);
    }

    @Step("POST {endpoint} (No Auth)")
    protected Response postWithoutAut(String endpoint, Object body) {
        return post(endpoint, body, false);
    }


    private Response put(String endpoint, Object body, boolean userAuth) {
        logger.info("PUT {}", endpoint);

        return request(userAuth)
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract().response();
    }

    @Step("PUT {endpoint} (Auth)")
    protected Response putWithAut(String endpoint, Object body) {
        return put(endpoint, body, true);
    }

    @Step("PUT {endpoint} (No Auth)")
    protected Response putWithoutAut(String endpoint, Object body) {
        return put(endpoint, body, false);
    }


    private Response patch(String endpoint, Object body, boolean userAuth) {
        logger.info("Patch {}", endpoint);

        return request(userAuth)
                .body(body)
                .when()
                .patch(endpoint)
                .then()
                .extract().response();
    }

    @Step("patch {endpoint} (Auth)")
    protected Response patchWithAut(String endpoint, Object body) {
        return patch(endpoint, body, true);
    }

    @Step("patch {endpoint} (No Auth)")
    protected Response patchWithoutAut(String endpoint, Object body) {
        return patch(endpoint, body, false);
    }


    private Response delete(String endpoint, boolean userAuth) {
        logger.info("Delete {}", endpoint);

        return request(userAuth)
                .when()
                .delete(endpoint)
                .then()
                .extract().
                response();

    }

    @Step("Delete {endpoint} (Auth)")
    protected Response deleteWithAut(String endpoint) {
        return delete(endpoint, true);
    }

    @Step("Delete {endpoint} (No Auth)")
    protected Response deleteWithoutAut(String endpoint) {
        return delete(endpoint, false);
    }

    @Step("Delete {endpoint} {paramName} {paramValue} (Auth)")
    protected Response deleteWithPath(String endpoint, String paramName, Object paramValue) {
        logger.info("DELETE {} with {}={}", endpoint, paramName, paramValue);
        return request(true)
                .pathParam(paramName, paramValue)
                .when()
                .delete(endpoint)
                .then()
                .log().ifValidationFails()
                .extract().response();
    }

    @Step("DELETE {endpoint} {queryParams} (Auth)")
    protected Response deleteWithParams(String endpoint, Map<String, ?> queryParams) {
        logger.info("DELETE {} with params {}", endpoint, queryParams);
        return request(true)
                .queryParams(queryParams)
                .when()
                .delete(endpoint)
                .then()
                .log().ifValidationFails()
                .extract().response();
    }


}
