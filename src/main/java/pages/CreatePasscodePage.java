package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePasscodePage extends BasePage{
    @FindBy(xpath = "//android.view.ViewGroup/android.view.View/android.view.View/android.view.View[1]/android.widget.Button")
    WebElement btnDeny;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Those passwords didn’t match!\"]")
    WebElement txtErrorConfirmPasscode;

    public CreatePasscodePage PressDigit(int digit){
        By btnDigitKey = By.xpath("//android.widget.TextView[@text=\""+digit+"\"]");
        click(btnDigitKey);
        return this;
    }

    public HomePage denyBiometricLogin() {
        click(btnDeny);
        return new HomePage();
    }
    public boolean isErrorShowing(){
        return isVisible(txtErrorConfirmPasscode);
    }
}
