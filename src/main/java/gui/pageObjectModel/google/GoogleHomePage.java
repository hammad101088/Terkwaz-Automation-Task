package gui.pageObjectModel.google;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {

    //****** variables ******//
    private WebDriver driver;
    private final String googleHomePage_url = "https://www.google.com/ncr";

    //****** constructor ******//
    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //****** locators ******//

    /**
     * get google search box
     * @return element locator
     */
    private static By googleSearch_editText_locator(){ return By.name("q");}

    //****** keywords ******//

    /**
     * open google home page.
     * @return self-reference to be used in fluent design.
     */
    public GoogleHomePage openGoogleHomePage(){
        BrowserActions.navigateToURL(driver,googleHomePage_url);
        return new GoogleHomePage(driver);
    }

    /**
     * search in google search engine
     * @param searchData the data that you need to search about.
     * @return self-reference to be used in fluent design.
     */
    public GoogleSearchResultsPage searchInGoogle(String searchData){
        (new ElementActions(driver))
                .type(googleSearch_editText_locator(),searchData)
                .keyPress(googleSearch_editText_locator(), Keys.ENTER);
        return new GoogleSearchResultsPage(driver);
    }

}
