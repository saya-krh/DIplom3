package util;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.SignUpPage;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static com.codeborne.selenide.Condition.visible;

public class UserInteraction {

    @Step("Navigate to sign up page")
    public static SignUpPage goToSignUpPage(MainPage mainPage) {
        LoginPage loginPage = mainPage.clickLogInButton();
        loginPage.waitUnitPageLoads();

        return loginPage.clickSignUpButton();
    }

    public static void setText(SelenideElement element, String text) {
        element.should(visible)
                .scrollIntoView(true)
                .setValue(text);
    }

    @Step("Wait until '{element}' is {state}")
    public static void assertElementInState(SelenideElement element, Condition state) {
        element.shouldBe(state, Duration.of(2, ChronoUnit.SECONDS));
    }
}
