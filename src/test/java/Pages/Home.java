package Pages;

import Pages.Base.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static Extensions.ExtendedMethods.Click;

public class Home extends BaseWebPage {

    private WebDriver _driver;

    public Home(WebDriver webDriver) throws Exception {
        super(webDriver);
        _driver = webDriver;
    }

        @FindBy(how = How.ID, using = "block_top_menu") private WebElement HorizontalBarElement;
        @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[1]/a") private WebElement WomanButton;
        @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a") private WebElement TopsTshirtButton;
        @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[2]/a") private WebElement TopsBlousesButton;
        @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[1]/a") private WebElement DressesCasualButton;
        @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[2]/a") private WebElement DressesEveningButton;
        @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[3]/a") private WebElement DressesSummerButton;
        @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[2]/a") private WebElement DressesButton;
        @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a") private WebElement CasualDressesButton;
        @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[2]/a") private WebElement EveningDressesButton;
        @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a") private WebElement SummerDressesButton;
        @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[3]/a") private WebElement TshirtsButton;
        @FindBy(how = How.CLASS_NAME, using = "login") private WebElement SignInLink;


    private By pageElement = By.xpath("//*[@id=\"center_column\"]/h1/span[1]");

    public Tshirts NavigateToWomansTshirts() throws Exception {
        this.ClickWomensTshirt();
        return new Tshirts(_driver, pageElement);
    }

    // Instantiating the navigation from one class to the desired one through the method
    public Tshirts NavigateToTshirts() throws Exception {
        ClickTshirt();
        return new Tshirts(_driver, pageElement);
    }

    public Dresses NavigateToDresses() throws Exception {
        ClickDresses();
        return new Dresses(_driver);
    }

    public Woman NavigateToWomen()  throws Exception {
        ClickWoman();
        return new Woman(_driver);
    }

    public Login NavigateToLogin() throws Exception {
        ClickSignIn();
        return new Login(_driver);
    }

    public boolean IsSignOutDisplayed()
    {
        boolean result = _driver.findElement(By.className("logout")).isDisplayed() == true;
        return result;
    }

    private void ClickWomensTshirt() {
        HoverClick(WomanButton, TopsTshirtButton);
    }

    // Action
    private void ClickTshirt() {
        Click(TshirtsButton, _driver);
    }

    private void ClickTshirts() {
        TshirtsButton.click();
    }

    private void ClickDresses() {
        Click(DressesButton, _driver);
    }

    private void ClickWoman() {
        Click(WomanButton, _driver);
    }

    private void ClickSignIn() {
        Click(SignInLink, _driver);
    }

    private String element;

    public void CheckElementExists(String element) throws Exception {
        AssertElementIsDisplayed(element);
    }
}
