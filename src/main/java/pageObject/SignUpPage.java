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

public class SignUpPage {
    @FindBy(how = How.XPATH, using = "//div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement nameField;
    @FindBy(how = How.XPATH, using = "//div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement emailField;
    @FindBy(how = How.XPATH, using = "//div/main/div/form/fieldset[3]/div/div/input")
    private SelenideElement passwordField;
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement signUpButton;
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement signInButton;
    @FindBy(how = How.XPATH, using = ".//p[text()='Такой пользователь уже существует']")
    private SelenideElement userAlreadyExistsMessage;
    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    private SelenideElement incorrectPasswordMessage;

    @Step("Enter data for sign up")
    public void enterSignUpInfo(String name, String email, String password) {
        setText(nameField, name);
        setText(emailField, email);
        setText(passwordField, password);
    }

    @Step("Click \"Sign Up\" button")
    public void clickSignUpButton() {
        signUpButton.should(visible)
                .scrollIntoView(true)
                .click();
    }

    @Step("Click \"Sign In\" button")
    public LoginPage clickSignInButton() {
        signInButton.should(visible)
                .scrollIntoView(true)
                .click();

        return page(LoginPage.class);
    }

    public void waitUntilPageLoads() {
        signUpButton.should(visible, Duration.of(2, ChronoUnit.SECONDS));
    }

    public SelenideElement getIncorrectPasswordMessage() {
        return incorrectPasswordMessage;
    }
}
