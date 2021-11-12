package gui.pageObjectModel.herokuapp;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import gui.pageObjectModel.google.GoogleHomePage;
import gui.pageObjectModel.google.GoogleSearchResultsPage;
import io.netty.handler.codec.http.multipart.FileUpload;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HerokuappHomePage {
    //****** variables ******//
    private WebDriver driver;
    private final String herokuapp_url = "https://the-internet.herokuapp.com/";

    //****** constructor ******//
    public HerokuappHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //****** locators ******//

    /**
     * get file upload button
     * @return element locator
     */
    private static By fileUpload_button_locator(){
        /*
        //*[text()='File Upload']
        */
        return By.xpath("//*[@href='/upload']");
    }

    /**
     * get dynamic loading button
     * @return element locator
     */
    private static By dynamicLoading_button_locator(){
        return By.xpath("//*[@href='/dynamic_loading']");
    }


    //****** keywords ******//
    /**
     * open Herokuapp Home Page.
     * @return self-reference to be used in fluent design.
     */
    public HerokuappHomePage openHerokuappHomePage(){
        BrowserActions.navigateToURL(driver,herokuapp_url);
        return new HerokuappHomePage(driver);
    }

    /**
     * open file upload page.
     * @return self-reference to be used in fluent design.
     */
    public FileUploadPage openFileUploadPage(){
        (new ElementActions(driver))
                .click(fileUpload_button_locator());
        return new FileUploadPage(driver);
    }

    /**
     * open dynamic loading page.
     * @return self-reference to be used in fluent design.
     */
    public DynamicLoadingPage openDynamicLoadingPage(){
        (new ElementActions(driver))
                .click(dynamicLoading_button_locator());
        return new DynamicLoadingPage(driver);
    }
}
