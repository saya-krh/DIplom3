import com.codeborne.selenide.Selenide;
import org.junit.Before;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.PersonalCabinetPage;
import pageObject.SignUpPage;

import java.util.UUID;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static util.UserInteraction.assertElementInState;
import static util.UserInteraction.goToSignUpPage;

public class BaseTest {
    public static final String STELLAR_BURGERS_MAIN_PAGE = "https://stellarburgers.nomoreparties.site/";
    public static final String NAME = "Saida Karakhanova";
    public static final String EMAIL = "saida" + getUniqueId() + "@gmail.com";
    public static final String PASSWORD = "12345678";

    public static MainPage mainPage = open(STELLAR_BURGERS_MAIN_PAGE, MainPage.class);

    static {
        SignUpPage signUpPage = goToSignUpPage(mainPage);

        signUpPage.enterSignUpInfo(NAME, EMAIL, PASSWORD);
        signUpPage.clickSignUpButton();
    }

    @Before
    public void setup() {
//        Uncomment to use Yandex Browser
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");

        System.setProperty("selenide.browser", "yandex");

        mainPage = open(STELLAR_BURGERS_MAIN_PAGE, MainPage.class);

        logOut();

        Selenide.webdriver()
                .driver()
                .getWebDriver()
                .manage()
                .window()
                .maximize();
    }

    public static void logOut() {
        if (mainPage.getOrderButton().exists()) {
            PersonalCabinetPage personalCabinetPage = mainPage.clickPersonalCabinetButtonToOpenProfile();
            personalCabinetPage.waitUntilPageLoads();
            personalCabinetPage.clickLogOutButton();

            page(LoginPage.class).waitUnitPageLoads();

            mainPage = open(STELLAR_BURGERS_MAIN_PAGE, MainPage.class);

            assertElementInState(mainPage.getLogInButton(), visible);
        }
    }

    protected static String getUniqueId() {
        return UUID.randomUUID()
                .toString()
                .substring(0, 4);
    }
}
