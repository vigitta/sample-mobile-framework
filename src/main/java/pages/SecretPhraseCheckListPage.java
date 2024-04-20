package pages;

import org.openqa.selenium.By;

public class SecretPhraseCheckListPage extends BasePage{
    By chkFirst = By.xpath("//android.widget.ScrollView/android.view.View[1]");
    By chkSecond = By.xpath("//android.widget.ScrollView/android.view.View[2]");
    By chkThird = By.xpath("//android.widget.ScrollView/android.view.View[3]");

    By btnContinue = By.xpath("//android.widget.ScrollView/android.view.View[4]");
    public void selectTwo(){
        click(chkFirst);
        click(chkSecond);
    }
    public void selectOne(){
        click(chkFirst);
    }
    public void selectAll(){
        click(chkFirst);
        click(chkSecond);
        click(chkThird);
    }
    public void Continue(){
        click(btnContinue);
    }

    public boolean isContinueEnabled() {
        return isEnabled(btnContinue);
    }
}
