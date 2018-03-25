package com.github.kovaku.pageobjects;

import com.github.kovaku.pageobjects.base.BasePageObject;
import com.github.kovaku.pageobjects.section.GithubProfileSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GithubProfilePage extends BasePageObject {

    private static final String GITHUB_PROFILE_PAGE_URL = "https://github.com/kovaku";

    @FindBy(className = "h-card")
    private WebElement profileCard;

    private WebDriver webDriver;
    private GithubProfileSection githubProfileSection;

    @Autowired
    public GithubProfilePage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public GithubProfilePage getPage() {
        webDriver.get(GITHUB_PROFILE_PAGE_URL);
        return this;
    }

    public GithubProfileSection getGithubProfileSection() {
        if (githubProfileSection == null) {
            githubProfileSection = new GithubProfileSection(webDriver, profileCard);
        }
        return githubProfileSection;
    }
}
