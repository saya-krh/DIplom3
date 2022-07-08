package test;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorTest extends BaseTest {

    @Test
    public void testNavigationToBuns() {
        waitForJsToLoad();
        mainPage.clickSauces();

        mainPage.clickBuns();
        waitUntilCategoryIsActive(mainPage.getBunsButton());
    }

    @Test
    public void testNavigationToSauces() {
        waitForJsToLoad();
        mainPage.clickIngredients();

        mainPage.clickSauces();
        waitUntilCategoryIsActive(mainPage.getSaucesButton());
    }

    @Test
    public void testNavigationToIngredients() {
        waitForJsToLoad();
        mainPage.clickSauces();

        mainPage.clickIngredients();
        waitUntilCategoryIsActive(mainPage.getIngredientsButton());
    }

    @Step("Wait until elements parent has 'current' class")
    private void waitUntilCategoryIsActive(SelenideElement element) {
        new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(1))
                .until(ExpectedConditions.attributeContains(element.parent(), "class", "tab_tab_type_current__2BEPc"));
    }

    private void waitForJsToLoad() {
        WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }
}
