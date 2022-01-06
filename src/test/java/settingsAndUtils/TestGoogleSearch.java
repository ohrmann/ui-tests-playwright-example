package settingsAndUtils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.GoogleElements;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestGoogleSearch extends SettingsPreconditions {
    public String searchPhrase = "devs.one";
    public String expectedResult = "Devs One";
    @Test
    @DisplayName("Test Google search, you should get expected search result")
    public void checkBranchSelectorWorks() {
        GoogleElements ge = new GoogleElements(page);
        page.navigate(urlGoogle);
        ge.enterSearchPhrase(searchPhrase);
        page.keyboard().press("Enter");
        ge.checkResult(expectedResult);
    }//checkBranchSelectorWorks

    @AfterEach
    public void after() {
        closeWebDriver();
    }
}//class
