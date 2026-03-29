package api.client;

import api.base.BaseService;
import api.endPoints.EndPoints;
import api.utils.LanguageHeader;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class FirmClient extends BaseService {


    public Response getFirmInfoEn(){
        return get(EndPoints.FIRM,
                true,
                LanguageHeader.EN);

    }

    public Response getFirmInfoNoAuthEn(){

        return  get(EndPoints.FIRM,
                false,
                LanguageHeader.EN);

    }






}
