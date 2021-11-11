package gui.pageObjectModel.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchResultsPage {

    //****** variables ******//
    private WebDriver driver;

    //****** constructor ******//
    public GoogleSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    //****** locators ******//
    //todo: enhance this locator

    /**
     * get specific google search result by providing its number.
     * @param searchResultNumber the number of the desired search result.
     * @return
     */
    public static By googleSearchResult_text_locator(int searchResultNumber){
        return By.xpath("(//h3[contains(@class,'LC20lb')])["+searchResultNumber+"]");
    }

    //****** keywords ******//
}
