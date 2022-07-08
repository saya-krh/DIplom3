package test;

import org.junit.After;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.PersonalCabinetPage;

import static com.codeborne.selenide.Condition.visible;
import static util.UserInteraction.assertElementInState;

public class ConstructorNavigationTest extends BaseTest {

    @After
    public void after() {
        logOut();
    }

    @Test
    public void testConstructorOpensWithButtonClick() {
        PersonalCabinetPage personalCabinetPage = logIn();

        MainPage mainPageFromProfile = personalCabinetPage.clickConstructorButton();

        assertElementInState(mainPageFromProfile.getConstructBurgerLabel(), visible);
    }

    @Test
    public void testConstructorOpensWithLogoClick() {
        PersonalCabinetPage personalCabinetPage = logIn();

        MainPage mainPageFromProfile = personalCabinetPage.clickLogo();

        assertElementInState(mainPageFromProfile.getConstructBurgerLabel(), visible);
    }

    private PersonalCabinetPage logIn() {
        LoginPage loginPage = mainPage.clickLogInButton();
        loginPage.waitUnitPageLoads();

        loginPage.enterSignInInfo(EMAIL, PASSWORD);
        MainPage mainPageFromRedirect = loginPage.clickSignInButton();
        mainPageFromRedirect.waitUntilPageLoads();

        return mainPageFromRedirect.clickPersonalCabinetButtonToOpenProfile();
    }
}
