package api.objectModel;
import com.shaft.api.RestActions;
import io.restassured.response.Response;

public class CatFacts {
    //******* variables *******//
    RestActions apiObject;
    public static String getBASE_URL() {
        return System.getProperty("catFact_baseUrl");
    }
    private final String FACT_ENDPOINT = System.getProperty("fact_endPoint");

    //******* constructor *******//
    public CatFacts(RestActions apiObject) {
        this.apiObject = apiObject;
    }

    //******* keywords *******//

    /**
     * get cat facts API request
     * @return list of cat facts as a response object
     */
    public Response getCatFact(){
        return apiObject.buildNewRequest(FACT_ENDPOINT, RestActions.RequestType.GET).performRequest();
    }
}
