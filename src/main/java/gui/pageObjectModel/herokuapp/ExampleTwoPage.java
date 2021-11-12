package gui.pageObjectModel.herokuapp;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExampleTwoPage {
    //****** variables ******//
    private WebDriver driver;

    //****** constructor ******//
    public ExampleTwoPage(WebDriver driver) {
        this.driver = driver;
    }

    //****** locators ******//

    /**
     * get start button
     * @return element locator
     */
    private static By start_button_locator(){
        return By.xpath("//*[@id='start']/button");
    }

    /**
     * get finish button
     * @return element locator
     */
    public static By helloWorld_text_locator(){
        return By.id("finish");
    }


    //****** keywords ******//
    /**
     * start loading
     * @return self-reference for method chaining
     */
    public ExampleTwoPage startLoading(){
        (new ElementActions(driver))
                .click(start_button_locator());
        return new ExampleTwoPage(driver);
    }

    /**
     * wait for loading to finish
     * @return self-reference for method chaining
     */
    public ExampleTwoPage waitForLoadingToFinish(){
        (new ElementActions(driver))
                .waitForElementToBePresent(helloWorld_text_locator(),5,true);
        return new ExampleTwoPage(driver);
    }
}
