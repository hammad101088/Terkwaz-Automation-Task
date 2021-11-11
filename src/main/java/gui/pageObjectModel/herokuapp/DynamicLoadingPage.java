package gui.pageObjectModel.herokuapp;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    //****** variables ******//
    private WebDriver driver;

    //****** constructor ******//
    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    //****** locators ******//
    private static By example2_button_locator(){
        return By.xpath("//*[@href='/dynamic_loading/2']");
    }

    //****** keywords ******//
    /**
     * open example two page.
     * @return self-reference to be used in fluent design.
     */
    public ExampleTwoPage openExampleTwoPage(){
        (new ElementActions(driver))
                .click(example2_button_locator());
        return new ExampleTwoPage(driver);
    }
}
