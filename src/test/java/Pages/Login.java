package Pages;

import Pages.Base.BaseWebPage;
import org.openqa.selenium.WebDriver;

public class Login extends BaseWebPage {

    private WebDriver _driver;

    public Login(WebDriver webDriver) throws Exception {
        super(webDriver);
        _driver = webDriver;
    }
}