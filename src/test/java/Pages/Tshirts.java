package Pages;

import Pages.Base.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Tshirts extends BaseWebPage {

    private WebDriver _driver;
    private By pageElement = By.xpath("//*[@id=\"center_column\"]/h1/span[1]");

    public Tshirts(WebDriver webDriver, By controlId) throws Exception {
        super(webDriver, controlId);
        _driver = webDriver;
        controlId = pageElement;
    }

    @FindBy(how = How.ID, using = "block_top_menu") private WebElement HorizontalBarElement;
    @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[1]/a") private WebElement WomanButton;
}
