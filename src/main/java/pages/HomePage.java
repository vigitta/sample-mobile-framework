package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]/android.widget.Button[1]")
    WebElement btnGear;

    By txtMainWallet = By.xpath("//android.widget.TextView[@text=\"Main Wallet 1\"]");
    By btnX = By.xpath("//android.view.ViewGroup/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.Button");

    public HomePage openSettings(){
        click(btnGear);
        return this;
    }
    public boolean hasMainWallet(){
        return isVisible(txtMainWallet);
    }


    public HomePage closeDialog() {
        click(btnX);
        return this;
    }
}
