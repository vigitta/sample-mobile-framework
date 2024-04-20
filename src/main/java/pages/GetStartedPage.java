package pages;

import org.openqa.selenium.By;

public class GetStartedPage extends BasePage{
    By btnGetStarted = By.xpath("//android.widget.Button");
    public LandingPage start(){
        click(btnGetStarted);
        return new LandingPage();
    }
}
