import org.junit.After;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.PersonalCabinetPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static util.UserInteraction.assertElementInState;

public class PersonalCabinetTest extends BaseTest {

    @After
    public void after() {
        PersonalCabinetPage personalCabinetPage = page(PersonalCabinetPage.class);
        personalCabinetPage.waitUntilPageLoads();

        personalCabinetPage.clickLogOutButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitUnitPageLoads();
        loginPage.clickLogo();
    }

    @Test
    public void testPersonalCabinet() {
        LoginPage loginPage = mainPage.clickLogInButton();
        loginPage.waitUnitPageLoads();

        loginPage.enterSignInInfo(EMAIL, PASSWORD);
        loginPage.clickSignInButton();

        MainPage mainPageFromRedirect = page(MainPage.class);

        PersonalCabinetPage personalCabinetPage = mainPageFromRedirect.clickPersonalCabinetButtonToOpenProfile();

        assertElementInState(personalCabinetPage.getLogOutButton(), visible);
    }
}
