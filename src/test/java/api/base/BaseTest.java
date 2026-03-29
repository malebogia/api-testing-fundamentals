package api.base;

import api.utils.ConfigReader;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import static org.hamcrest.Matchers.lessThan;

public class BaseTest {

    @BeforeAll
    static void setup() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();


        RestAssured.filters(new AllureRestAssured());


        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("base.uri"))
                .setBasePath(ConfigReader.getProperty("base.path"))
                .setContentType(ContentType.JSON)
                .addHeader("User-Agent", "INVBG-API-Framework")
                .build();


        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectResponseTime(lessThan(5000L))
                .build();

        BaseService.logger.info("===== Framework Initialized: BaseURI: {} =====", ConfigReader.getProperty("base.uri"));
    }
}