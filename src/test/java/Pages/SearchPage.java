package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class SearchPage {
    public SearchPage(){
        PageFactory.initElements(Driver.getInstance().getDriver(), this);
    }
    @FindBy(id = "APjFqb")
    public WebElement searchInputBox;
    @FindBy(xpath = "//span[contains(text(), 'Clover')]")
    public List<WebElement> searchItems;
}