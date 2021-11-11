package gui.herokuapp;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import gui.pageObjectModel.herokuapp.ExampleTwoPage;
import gui.pageObjectModel.herokuapp.FileUploadPage;
import gui.pageObjectModel.herokuapp.HerokuappHomePage;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHerokuapp {
    //****** variables ******//
    private WebDriver driver;
    private JSONFileManager jsonFileManager_herokuappTestData;

    //****** methods ******//
    @BeforeClass
    public void beforeClass() {
        jsonFileManager_herokuappTestData = new JSONFileManager(System.getProperty("testDataFolderPath") + "/guiTestData/herokuapp.json");
    }
    @BeforeMethod
    public void beforeMethod() {
        driver = DriverFactory.getDriver();
    }

    @Test(description = "Test Upload File using Valid Data")
    @Description("""
            Test uploading file using valid file
            Steps:
            - open Herokuapp Home Page
            - Click on "File Upload"
            - Upload any small image file
            - Check that the file has been uploaded successfully
            """)
    public void TestUploadFile_validData() {
        (new HerokuappHomePage(driver))
                .openHerokuappHomePage()
                .openFileUploadPage()
                .uploadPhoto(System.getProperty("user.dir") + "/" + System.getProperty("testDataFolderPath") + "/guiTestData/testPhoto.jpg");

        Validations.assertThat()
                .element(driver, FileUploadPage.fileUploadedSuccessfully_text_locator())
                .text()
                .isEqualTo(jsonFileManager_herokuappTestData.getTestData("TestFileUpload.uploadSuccessMessage"))
                .withCustomReportMessage("assert that \"File Uploaded!\" text is displayed")
                .perform();
    }

    @Test(description = "Test dynamic loading")
    @Description("""
            Steps:
            - open Herokuapp home page
            - Click on "Dynamic Loading"
            - Click on "Example 2"
            - Click "Start"
            - Wait for loading to finish
            - Check that the text displayed is "Hello World!"
            """)
    public void TestDynamicLoading() {
        (new HerokuappHomePage(driver))
                .openHerokuappHomePage()
                .openDynamicLoadingPage()
                .openExampleTwoPage()
                .startLoading()
                .waitForLoadingToFinish();

        Validations.assertThat()
                .element(driver, ExampleTwoPage.helloWorld_text_locator())
                .text()
                .isEqualTo(jsonFileManager_herokuappTestData.getTestData("TestDynamicLoading.successMessage"))
                .withCustomReportMessage("assert that \"Hello World!\" text is displayed")
                .perform();

    }

    @AfterMethod
    public void afterMethod() {
        BrowserActions.closeCurrentWindow(driver);
    }
}

