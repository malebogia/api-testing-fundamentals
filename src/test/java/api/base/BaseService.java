package api.base;

import api.utils.LanguageHeader;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import test.auth.TokenManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class BaseService {

    protected static final Logger logger = LogManager.getLogger(BaseService.class);

    /**
     * MASTER SPEC BUILDER
     * Centralized logic for headers.
     */
    protected RequestSpecification request(boolean withAuth, LanguageHeader lang) {
        RequestSpecification spec = given()
                .header("Accept-Language", lang.getCode());

        if (withAuth) {
            spec.header("Authorization", "Bearer " + TokenManager.getToken());
        }
        return spec;
    }

    // --- GET METHODS ---
    @Step("GET {endpoint}")
    protected Response get(String endpoint, boolean auth, LanguageHeader lang) {
        logger.info("GET {} [Auth: {}, Lang: {}]", endpoint, auth, lang.getCode());
        return request(auth, lang).when().get(endpoint).then().extract().response();
    }

    protected Response getWithAuth(String endpoint) {
        return get(endpoint, true, LanguageHeader.EN);
    }

    // --- POST METHODS ---
    @Step("POST {endpoint}")
    protected Response post(String endpoint, Object body, boolean auth, LanguageHeader lang) {
        logger.info("POST {} [Auth: {}, Lang: {}]", endpoint, auth, lang.getCode());
        return request(auth, lang).body(body).when().post(endpoint).then().extract().response();
    }

    protected Response postWithAuth(String endpoint, Object body) {
        return post(endpoint, body, true, LanguageHeader.EN);
    }

    // --- PUT METHODS (Replace) ---
    @Step("PUT {endpoint}")
    protected Response put(String endpoint, Object body, boolean auth, LanguageHeader lang) {
        logger.info("PUT {} [Auth: {}, Lang: {}]", endpoint, auth, lang.getCode());
        return request(auth, lang).body(body).when().put(endpoint).then().extract().response();
    }

    /**
     * Standard PUT with Path Parameter (e.g., /invoices/{id})
     */
    @Step("PUT {endpoint} | ID: {paramValue}")
    protected Response putWithPath(String endpoint, String paramName, Object paramValue, Object body, boolean auth) {
        logger.info("PUT {} with PathParam {}={}", endpoint, paramName, paramValue);
        return request(auth, LanguageHeader.EN)
                .pathParam(paramName, paramValue)
                .body(body)
                .when().put(endpoint)
                .then().extract().response();
    }

    // --- PATCH METHODS (Partial Update) ---
    @Step("PATCH {endpoint}")
    protected Response patch(String endpoint, Object body, boolean auth, LanguageHeader lang) {
        logger.info("PATCH {} [Auth: {}, Lang: {}]", endpoint, auth, lang.getCode());
        return request(auth, lang).body(body).when().patch(endpoint).then().extract().response();
    }

    /**
     * Standard PATCH with Path Parameter (e.g., /invoices/{id})
     */
    @Step("PATCH {endpoint} | ID: {paramValue}")
    protected Response patchWithPath(String endpoint, String paramName, Object paramValue, Object body, boolean auth) {
        logger.info("PATCH {} with PathParam {}={}", endpoint, paramName, paramValue);
        return request(auth, LanguageHeader.EN)
                .pathParam(paramName, paramValue)
                .body(body)
                .when().patch(endpoint)
                .then().extract().response();
    }

    // --- DELETE METHODS ---
    @Step("DELETE {endpoint}")
    protected Response deleteWithPath(String endpoint, String paramName, Object paramValue, boolean auth) {
        logger.info("DELETE {} with PathParam {}={}", endpoint, paramName, paramValue);
        return request(auth, LanguageHeader.EN)
                .pathParam(paramName, paramValue)
                .when().delete(endpoint)
                .then().extract().response();
    }
}