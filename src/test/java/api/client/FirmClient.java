package api.client;

import api.base.BaseService;
import api.endPoints.EndPoints;
import api.dto.FirmDTO;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class FirmClient extends BaseService {

    public Response getFirmInfo(){
        return getWithAuth(EndPoints.FIRM);
    }

  /* public Response patchFirmData(FirmDTO firm){
        return patch(EndPoints.FIRM,firm);
    }

    public Response putFirm(FirmDTO firm){
        return put(EndPoints.FIRM,firm);

    }

*/
}
