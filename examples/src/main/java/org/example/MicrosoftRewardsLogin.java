package org.example;

import com.microsoft.playwright.*;


public class MicrosoftRewardsLogin {

  public static void main(String[] args) throws Exception {
    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    Page page = browser.newPage();
    page.navigate("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&rver=7.3.6963.0&wp=MBI_SSL&wreply=https%3a%2f%2fwww.microsoft.com%2fen-us%2frewards&lc=1033&id=74335&aadredir=1");
    page.waitForSelector("[name='loginfmt']");
    page.fill("[name='loginfmt']", "YOUR_EMAIL_HERE");
    page.click("[type='submit']");
    page.waitForTimeout(5000);
    page.waitForSelector("[name='passwd']");
    page.fill("[name='passwd']", "YOUR_PASSWORD_HERE");
    page.click("[type='submit']");
    page.waitForTimeout(5000);
    page.click("[type='submit']");
    page.waitForTimeout(5000);
    page.waitForSelector("[data-testid='dashboard-heading']");
    browser.close();
  }
}
