package api.catFacts;

import api.objectModel.CatFacts;
import com.shaft.api.RestActions;
import com.shaft.driver.DriverFactory;
import com.shaft.validation.Validations;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCatFacts {

    //****** variables ******//
    RestActions apiObject;
    CatFacts catFacts;

    //****** methods ******//
    @BeforeClass
    public void beforeClass() {
        apiObject = DriverFactory.getAPIDriver(CatFacts.getBASE_URL());
        catFacts = new CatFacts(apiObject);
    }

    @Test(description = "Test one cat fact")
    @Description("""
            Steps:
            - get one random cat fact
            - Check that the response "text" is not empty
            """)
    public void testCatFacts(){
        Response oneCatFact_response = catFacts.getCatFact();
        Validations.assertThat()
                .response(oneCatFact_response)
                .extractedJsonValue("[0].text")
                .isNotNull()
                .withCustomReportMessage("Check that the response \"text\" is not empty")
                .perform();
    }
}
