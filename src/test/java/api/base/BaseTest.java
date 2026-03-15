package api.base;

import api.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import static org.hamcrest.Matchers.lessThan;


public class BaseTest {
    //TODO logger.debug("Response body: {}", response.getBody().asPrettyString());
    //TODO Log4j, then the best practice is usually:
    // Keep this in BaseTest
    //RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    //
    //Then log manually when needed:
    //
    //logger.debug("Response body: {}", response.getBody().asPrettyString());

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;

    @BeforeAll
    static void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("base.uri"))
                .setBasePath(ConfigReader.getProperty("base.path"))
                .setContentType(ContentType.JSON)
                .addHeader("User-Agent", "API-Test-Framework")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectResponseTime(lessThan(5000L))
                .build();

        RestAssured.requestSpecification = requestSpec;
        RestAssured.responseSpecification = responseSpec;

    }


}
