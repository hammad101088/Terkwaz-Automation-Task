package gui.pageObjectModel.herokuapp;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    //****** variables ******//
    private WebDriver driver;

    //****** constructor ******//
    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    //****** locators ******//
    private static By fileUpload_input_locator(){ return By.id("file-upload");}
    private static By fileUpload_button_locator(){ return By.id("file-submit");}
    public static By fileUploadedSuccessfully_text_locator(){ return By.xpath("//div[@class='example']//h3");}

    //****** keywords ******//

    /**
     * upload file by providing its path.
     * @param photoPath path to the desired photo (hint: better to locate it in the project's files and convert the path from relative to absolute)
     * @return self-reference to be used in method chaining.
     */
    public FileUploadPage uploadPhoto(String photoPath){
        (new ElementActions(driver))
                .typeFileLocationForUpload(fileUpload_input_locator(),photoPath)
                .click(fileUpload_button_locator());
        return new FileUploadPage(driver);
    }
}
