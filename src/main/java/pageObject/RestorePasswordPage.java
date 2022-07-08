package pageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class RestorePasswordPage {
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement logInButton;

    @Step("Click \"Log In\" button")
    public LoginPage clickLoginButton() {
        logInButton.should(visible)
                .scrollIntoView(true)
                .click();

        return page(LoginPage.class);
    }
}
