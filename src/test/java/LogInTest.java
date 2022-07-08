import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Test;
import pageObject.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;
import static util.UserInteraction.*;

public class LogInTest extends BaseTest {

    @After
    public void after() {
        logOut();
    }

    @Test
    public void testLoginWorksFromMainPage_LogInButton() {
        LoginPage loginPage = mainPage.clickLogInButton();

        loginPage.enterSignInInfo(EMAIL, PASSWORD);
        loginPage.clickSignInButton();

        assertSuccessfulLogin();
    }

    @Test
    public void testLoginWorksFromMainPage_PersonalCabinetButton() {
        LoginPage loginPage = mainPage.clickPersonalCabinetButtonToOpenLoginPage();

        loginPage.enterSignInInfo(EMAIL, PASSWORD);
        loginPage.clickSignInButton();

        assertSuccessfulLogin();
    }

    @Test
    public void testLoginWorksFromSignUpPage() {
        SignUpPage signUpPage = goToSignUpPage(mainPage);

        LoginPage loginPage = signUpPage.clickSignInButton();

        loginPage.enterSignInInfo(EMAIL, PASSWORD);
        loginPage.clickSignInButton();

        assertSuccessfulLogin();
    }

    @Test
    public void testLoginWorksFromRestorePasswordPage() {
        LoginPage loginPage = mainPage.clickLogInButton();

        RestorePasswordPage restorePasswordPage = loginPage.clickRestorePasswordButton();
        LoginPage loginPageFromRestore = restorePasswordPage.clickLoginButton();

        loginPageFromRestore.enterSignInInfo(EMAIL, PASSWORD);
        loginPageFromRestore.clickSignInButton();

        assertSuccessfulLogin();
    }

    private void assertSuccessfulLogin() {
        MainPage currentPage = page(MainPage.class);
        assertElementInState(currentPage.getOrderButton(), visible);

        assertEquals("Should have been redirected to main page!", STELLAR_BURGERS_MAIN_PAGE, WebDriverRunner.getWebDriver().getCurrentUrl());
    }
}
