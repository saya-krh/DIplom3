import org.junit.Test;
import pageObject.LoginPage;
import pageObject.SignUpPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static util.UserInteraction.assertElementInState;
import static util.UserInteraction.goToSignUpPage;

public class SignUpTest extends BaseTest {
    public static final String EMAIL = "testUser" + getUniqueId() + "@gmail.com";
    public static final String CORRECT_PASSWORD = "12345678";
    private static final String INCORRECT_PASSWORD = "123";

    @Test
    public void testSuccessfulSignUp() {
        SignUpPage signUpPage = goToSignUpPage(mainPage);
        signUpPage.waitUntilPageLoads();

        signUpPage.enterSignUpInfo(NAME, EMAIL, CORRECT_PASSWORD);
        signUpPage.clickSignUpButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.waitUnitPageLoads();

        assertElementInState(loginPage.getLogInButton(), visible);
    }

    @Test
    public void testUnsuccessfulSignUpDueToShortPassword() {
        SignUpPage signUpPage = goToSignUpPage(mainPage);
        signUpPage.waitUntilPageLoads();

        signUpPage.enterSignUpInfo(NAME, EMAIL, INCORRECT_PASSWORD);
        signUpPage.clickSignUpButton();

        assertElementInState(signUpPage.getIncorrectPasswordMessage(), visible);
    }
}
