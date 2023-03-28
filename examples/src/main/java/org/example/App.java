package org.example;

import java.util.regex.Pattern;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class App {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      // Launch in headed mode
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
      Page page = browser.newPage();
      page.navigate("http://playwright.dev");

      // Expect a title "to contain" a substring.
      assertThat(page).hasTitle(Pattern.compile("Playwright"));

      // create a locator
      Locator getStarted = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get Started"));

      // Expect an attribute "to be strictly equal" to the value.
      assertThat(getStarted).hasAttribute("href", "/docs/intro");

      // Click the get started link.
      getStarted.click();

      // Sleep for 5 seconds.
      page.waitForTimeout(5000);

      // Expects the URL to contain intro.
      assertThat(page).hasURL(Pattern.compile(".*intro"));
    }
  }
}
