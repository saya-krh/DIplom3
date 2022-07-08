import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.PersonalCabinetPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static util.UserInteraction.assertElementInState;

public class LogOutTest extends BaseTest {

    @Test
    public void testLogOut() {
        LoginPage loginPage = mainPage.clickLogInButton();

        loginPage.enterSignInInfo(EMAIL, PASSWORD);
        loginPage.clickSignInButton();

        MainPage mainPageFromRedirect = page(MainPage.class);

        PersonalCabinetPage personalCabinetPage = mainPageFromRedirect.clickPersonalCabinetButtonToOpenProfile();
        personalCabinetPage.clickLogOutButton();

        LoginPage loginPageFromRedirect = page(LoginPage.class);
        loginPageFromRedirect.waitUnitPageLoads();
        mainPageFromRedirect = loginPage.clickLogo();

        assertElementInState(mainPageFromRedirect.getLogInButton(), visible);
    }
}
