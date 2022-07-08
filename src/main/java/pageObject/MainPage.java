package pageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement logInButton;
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement personalCabinetButton;
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement orderButton;
    @FindBy(how = How.XPATH, using = ".//h1[text()='Соберите бургер']")
    private SelenideElement constructBurgerLabel;

    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsButton;
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement saucesButton;
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement ingredientsButton;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private SelenideElement bunsHeader;
    @FindBy(how = How.XPATH, using = ".//h2[text()='Соусы']")
    private SelenideElement saucesHeader;
    @FindBy(how = How.XPATH, using = ".//h2[text()='Начинки']")
    private SelenideElement ingredientsHeader;

    @Step("Click \"Log In\" button")
    public LoginPage clickLogInButton() {
        logInButton.should(visible)
                .scrollIntoView(true)
                .click();

        return page(LoginPage.class);
    }

    @Step("Click \"Personal Cabinet\" button")
    public LoginPage clickPersonalCabinetButtonToOpenLoginPage() {
        personalCabinetButton.should(visible)
                .scrollIntoView(true)
                .click();

        return page(LoginPage.class);
    }

    @Step("Click \"Personal Cabinet\" button")
    public PersonalCabinetPage clickPersonalCabinetButtonToOpenProfile() {
        personalCabinetButton.should(visible)
                .scrollIntoView(true)
                .click();

        return page(PersonalCabinetPage.class);
    }

    @Step("Click \"Buns\" button")
    public void clickBuns() {
        bunsButton.should(visible)
                .scrollIntoView(true)
                .click();
    }

    @Step("Click \"Sauces\" button")
    public void clickSauces() {
        saucesButton.should(visible)
                .scrollIntoView(true)
                .click();
    }

    @Step("Click \"Ingredients\" button")
    public void clickIngredients() {
        ingredientsButton.should(visible)
                .scrollIntoView(true)
                .click();
    }

    public void waitUntilPageLoads() {
        constructBurgerLabel.should(visible, Duration.of(2, ChronoUnit.SECONDS));
    }

    public SelenideElement getLogInButton() {
        return logInButton;
    }

    public SelenideElement getOrderButton() {
        return orderButton;
    }

    public SelenideElement getConstructBurgerLabel() {
        return constructBurgerLabel;
    }

    public SelenideElement getBunsHeader() {
        return bunsHeader;
    }

    public SelenideElement getSaucesHeader() {
        return saucesHeader;
    }

    public SelenideElement getIngredientsHeader() {
        return ingredientsHeader;
    }

    public SelenideElement getBunsButton() {
        return bunsButton;
    }

    public SelenideElement getSaucesButton() {
        return saucesButton;
    }

    public SelenideElement getIngredientsButton() {
        return ingredientsButton;
    }
}
