package pages;

import org.openqa.selenium.By;

public class BackupSecretPhrase extends BasePage{
    By btnManual = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
    By btnGDrive = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]/android.widget.Button");

    By btnSkip = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]");
    public SecretPhraseCheckListPage manualBackup(){
        click(btnManual);
        return new SecretPhraseCheckListPage();
    }
    public SecretPhraseCheckListPage gDriveBackup(){
        click(btnGDrive);
        return new SecretPhraseCheckListPage();
    }

    public CreatePasscodePage skip() {
        click(btnSkip);
        return new CreatePasscodePage();
    }
}
