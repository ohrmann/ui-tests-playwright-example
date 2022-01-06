package ui;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains all elements and steps that we can do with these lements
 * **/
public class GoogleElements {
    private Page page;
    //logo
    private String serachInput = "xpath=//html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[2]/div[2]/input";
    private String resultElementSelector = "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/a/h3";

    public GoogleElements(Page page) {
        this.page = page;
    }

    @Step("enter search phrase")
    public void enterSearchPhrase(String value) {
        page.click(serachInput);
        page.fill(serachInput, value);
    }

    @Step("check that you found what you wanted to")
    public void checkResult(String value) {
        assertEquals(value, page.innerText(resultElementSelector));
    }

}
