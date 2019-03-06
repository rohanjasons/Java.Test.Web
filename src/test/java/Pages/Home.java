package Pages;

import Pages.Common.Header;
import org.openqa.selenium.WebDriver;

public class Home extends Header {

    private WebDriver _driver;

    public Home(WebDriver webDriver) throws Exception {
        super(webDriver);
        _driver = webDriver;
    }

    @Override
    public Dresses NavigateToDresses() throws Exception {
        return super.NavigateToDresses();
    }
}
