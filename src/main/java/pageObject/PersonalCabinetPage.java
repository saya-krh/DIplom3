package pageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class PersonalCabinetPage {

    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logOutButton;
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;
    @FindBy(how = How.XPATH, using = "//div/header/nav/div/a")
    private SelenideElement logoButton;

    @Step("Log out")
    public void clickLogOutButton() {
        logOutButton.should(visible)
                .scrollIntoView(true)
                .click();
    }

    @Step("Click \"Constructor\" button")
    public MainPage clickConstructorButton() {
        constructorButton.should(visible)
                .scrollIntoView(true)
                .click();

        return page(MainPage.class);
    }

    @Step("Click Stellar Burgers logo")
    public MainPage clickLogo() {
        logoButton.should(visible)
                .scrollIntoView(true)
                .click();

        return page(MainPage.class);
    }

    public void waitUntilPageLoads() {
        logOutButton.should(visible, Duration.of(2, ChronoUnit.SECONDS));
    }

    public SelenideElement getLogOutButton() {
        return logOutButton;
    }
}
