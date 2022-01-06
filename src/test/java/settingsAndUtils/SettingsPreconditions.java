package settingsAndUtils;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

/**
 * We are using this class as library of methods with preconditions to group of tests
 * For Example we have a few cases with same preconditions, so we can implement it here.
 * */
public abstract class SettingsPreconditions {
    protected static String urlGoogle;
    protected static Page page;

    @BeforeAll
    public static void getProperties() throws IOException {
        Configs configs = new Configs();
        urlGoogle = configs.getProperty("url");
    }

    @BeforeEach
    public void configureDriver() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(50));
        browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1280, 800)
                .setLocale("en-US")
                .setDeviceScaleFactor(2));
        page = browser.newPage();
    }
}
