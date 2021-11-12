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
    //todo: enhance this locator, make it more accurate by excluding "people also ask" section.
    /**
     * get specific google search result by providing its number.
     * @param searchResultNumber the number of the desired search result.
     * @return element locator
     */
    public static By googleSearchResult_text_locator(int searchResultNumber){
        /*
        ----(//div[@class="g"]//h3[not(ancestor::div[@class="_OKe"])])[16]
        16 means the third result ... unreliable locator
        ----//h2[text()='Web results']/following-sibling::div/h3
        ----(//h3[contains(@class,'LC20lb')])[3]
        */
        return By.xpath("(//h1[contains(text(),'Search Result')]/following-sibling::div//a/h3)[" +searchResultNumber+ "]");
    }

    //****** keywords ******//
}
