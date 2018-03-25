package com.github.kovaku;

import com.github.kovaku.config.TestConfig;
import com.github.kovaku.pageobjects.GithubProfilePage;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Sample test as to investigate the possibility of the embedded PageObjects
 * using PageFactory to initialize them
 */
@Test
@ContextConfiguration(classes = TestConfig.class)
public class SampleTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebDriver webDriver;

    @Autowired
    private GithubProfilePage githubProfilePage;

    @Test
    public void PageObjectTest() {
        githubProfilePage.getPage().getGithubProfileSection().clickAvatarImage();
    }

    @Test(description = "Try to trigger StaleElementReferenceException")
    public void PageObjectTestRerun() {
        githubProfilePage.getPage().getGithubProfileSection().clickAvatarImage();
    }


}
