package Pages;

import Pages.Base.BaseWebPage;
import org.openqa.selenium.WebDriver;

public class Woman extends BaseWebPage {

    private WebDriver _driver;

    public Woman(WebDriver webDriver) throws Exception {
        super(webDriver);
        _driver = webDriver;
    }
}
