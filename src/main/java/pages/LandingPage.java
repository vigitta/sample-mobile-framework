package pages;

import org.openqa.selenium.By;

public class LandingPage extends BasePage{
    By btnCreateNew = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]");
    public BackupSecretPhrase clickCreateNew(){
        click(btnCreateNew);
        return new BackupSecretPhrase();
    }
}
