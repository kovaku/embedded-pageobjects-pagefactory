package com.github.kovaku.pageobjects.section;

import com.github.kovaku.pageobjects.base.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class GithubProfileSection extends BasePageObject {

    /**
     * Testing with general css locator.
     */
    @FindBy(css = "a > img")
    private WebElement avatarImage;

    private WebElement parentElement;

    public GithubProfileSection(WebDriver webDriver, WebElement parentElement) {
        super(webDriver, parentElement);
        this.parentElement = parentElement;
    }

    public void clickAvatarImage() {
        avatarImage.click();
    }
}
