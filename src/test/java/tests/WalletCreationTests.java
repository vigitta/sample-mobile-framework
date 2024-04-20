package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utils.DriverUtils;

public class WalletCreationTests extends BaseTest {
    LandingPage landingPage;

    @BeforeMethod
    public void Init(){
        landingPage = new GetStartedPage().start();
    }
    @Test(description = "checking user cannot continue without checking all secret phrase information")
    public void testContinueButtonDisabled__WhenTwoCheckbox(){
        SecretPhraseCheckListPage secretPhraseCheckListPage = landingPage.clickCreateNew().manualBackup();
        secretPhraseCheckListPage.selectTwo();
        Assert.assertFalse(secretPhraseCheckListPage.isContinueEnabled(),"not enabled for two checkboxes");
    }
    @Test(description = "checking user cannot continue with 1 checkbox selected")
    public void testContinueButtonDisabled_WhenOneCheckbox(){
        SecretPhraseCheckListPage secretPhraseCheckListPage = landingPage.clickCreateNew().manualBackup();
        secretPhraseCheckListPage.selectOne();
        Assert.assertFalse(secretPhraseCheckListPage.isContinueEnabled(),"not enabled for one checkbox");

    }
    @Test(description = "checking user can continue with all checkbox selected")
    public void testContinueButtonEnabled_WhenAllCheckbox(){
        SecretPhraseCheckListPage secretPhraseCheckListPage = landingPage.clickCreateNew().manualBackup();
        secretPhraseCheckListPage.selectAll();
        Assert.assertTrue(secretPhraseCheckListPage.isContinueEnabled(),"enabled for all checkbox");
    }

    @Test(description = "checking creation of wallet without backup is working")
    public void testMainWalletVisible_WhenSamePasswordEntered() {
        CreatePasscodePage createPassPhrase = landingPage.clickCreateNew().skip();

        createPassPhrase
                .PressDigit(1)
                .PressDigit(2)
                .PressDigit(3)
                .PressDigit(4)
                .PressDigit(5)
                .PressDigit(6);
        createPassPhrase
                .PressDigit(1)
                .PressDigit(2)
                .PressDigit(3)
                .PressDigit(4)
                .PressDigit(5)
                .PressDigit(6);
        HomePage home = createPassPhrase.denyBiometricLogin();
        ;
        Assert.assertTrue(home.closeDialog().openSettings().hasMainWallet());

    }
    @Test(description = "checking confirm password validation")
    public void testValidationErrorVisible_WhenDifferentPasswordsEntered() {
        CreatePasscodePage createPassPhrase = landingPage.clickCreateNew().skip();

        createPassPhrase
                .PressDigit(1)
                .PressDigit(2)
                .PressDigit(3)
                .PressDigit(4)
                .PressDigit(5)
                .PressDigit(6);
        createPassPhrase
                .PressDigit(6)
                .PressDigit(1)
                .PressDigit(3)
                .PressDigit(4)
                .PressDigit(5)
                .PressDigit(6);
        Assert.assertTrue(createPassPhrase.isErrorShowing());

    }

}
