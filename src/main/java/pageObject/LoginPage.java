package pageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static util.UserInteraction.setText;

public class LoginPage {
    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logoButton;
    @FindBy(how = How.NAME, using = "name")
    private SelenideElement emailField;
    @FindBy(how = How.NAME, using = "Пароль")
    private SelenideElement passwordField;
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement logInButton;
    @FindBy(how = How.XPATH, using = ".//a[text()='Зарегистрироваться']")
    private SelenideElement signUpButton;
    @FindBy(how = How.XPATH, using = ".//a[text()='Восстановить пароль']")
    private SelenideElement restorePasswordButton;

    @Step("Click Stellar Burgers logo")
    public MainPage clickLogo() {
        logoButton.should(visible)
                .scrollIntoView(true)
                .click();

        return page(MainPage.class);
    }

    @Step("Click \"Sign Up\" link")
    public SignUpPage clickSignUpButton() {
        signUpButton.should(visible)
                .scrollIntoView(true)
                .click();

        return page(SignUpPage.class);
    }

    @Step("Click \"Sign In\" button")
    public MainPage clickSignInButton() {
        logInButton.should(visible)
                .scrollIntoView(true)
                .click();

        return page(MainPage.class);
    }

    @Step("Click \"Restore password\" button")
    public RestorePasswordPage clickRestorePasswordButton() {
        restorePasswordButton.should(visible)
                .scrollIntoView(true)
                .click();

        return page(RestorePasswordPage.class);
    }

    @Step("Enter data for sign in")
    public void enterSignInInfo(String email, String password) {
        setText(emailField, email);
        setText(passwordField, password);
    }

    public void waitUnitPageLoads() {
        restorePasswordButton.should(visible, Duration.of(2, ChronoUnit.SECONDS));
    }

    public SelenideElement getLogInButton() {
        return logInButton;
    }
}
