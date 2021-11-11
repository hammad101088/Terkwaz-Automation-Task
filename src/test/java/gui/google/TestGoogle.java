package gui.google;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import gui.pageObjectModel.google.GoogleHomePage;
import gui.pageObjectModel.google.GoogleSearchResultsPage;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestGoogle {
    //****** variables ******//
    private WebDriver driver;
    private JSONFileManager jsonFileManager_googleTestData;

    //****** methods ******//
    @BeforeClass
    public void beforeClass() {
        jsonFileManager_googleTestData = new JSONFileManager(System.getProperty("testDataFolderPath")+"/guiTestData/google.json");
    }
    @BeforeMethod
    public void beforeMethod() {
        driver = DriverFactory.getDriver();
    }

    @Test(description = "Test Google Search using Valid Data")
    @Description("""
            Test searching for \"selenium webdriver\" and check that the third result text contains \"What is Selenium WebDriver?\"
            Steps:
            - open google
            - search for \"selenium webdriver\"
            - check that the third result text contains \"What is Selenium WebDriver?\"
            """)
    public void TestGoogleSearch_validData() {
        (new GoogleHomePage(driver))
                .openGoogleHomePage()
                .searchInGoogle(jsonFileManager_googleTestData.getTestData("TestGoogleSearch.searchData"));

        Validations.assertThat()
                .element(driver, GoogleSearchResultsPage.googleSearchResult_text_locator(3))
                .text()
                .isEqualTo(jsonFileManager_googleTestData.getTestData("TestGoogleSearch.expected_results"))
                .withCustomReportMessage("assert that the third result contains \"What is Selenium WebDriver?\"")
                .perform();
    }

    @AfterMethod
    public void afterMethod() {
        BrowserActions.closeCurrentWindow(driver);
    }
}
