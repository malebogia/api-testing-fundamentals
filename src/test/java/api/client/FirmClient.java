package api.client;

import api.base.BaseService;
import api.dto.FirmDTO;
import api.endPoints.EndPoints;
import api.utils.LanguageHeader;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class FirmClient extends BaseService {

    /**
     * Updates firm information with specific auth and language settings.
     * @param objectBody The DTO containing updated firm details.
     * @param withAuth Whether to include the Bearer token.
     * @param lang The preferred language header.
     * @return io.restassured.response.Response
     */


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

    public Response patchFirmInfoEnLang(FirmDTO objectBody){
        return patch(EndPoints.FIRM,objectBody,true,LanguageHeader.EN);

    }

    public Response patchFirmInfoBgLang(FirmDTO objectBody){
        return patch(EndPoints.FIRM,objectBody,true,LanguageHeader.BG);

    }

    public Response patchFirmInfoEnLangNoAuth(FirmDTO objectBody){
        return patch(EndPoints.FIRM,objectBody,false,LanguageHeader.EN);

    }








}
