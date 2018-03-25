package com.github.kovaku.pageobjects.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

public class BasePageObject {

    private static final int TIMEOUT_IN_SEC = 15;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    /**
     * Primary constructor for PageObjects
     */
    public BasePageObject(WebDriver webDriver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver,TIMEOUT_IN_SEC), this);
        webDriverWait = new WebDriverWait(webDriver, TIMEOUT_IN_SEC);
    }

    /**
     * Secondary constructor for PageSections
     * @param parentElement is the parent webelement of the section
     */
    public BasePageObject(WebDriver webDriver, WebElement parentElement) {
        PageFactory.initElements(new DefaultElementLocatorFactory(parentElement), this);
        webDriverWait = new WebDriverWait(webDriver, TIMEOUT_IN_SEC);
    }

    protected void clickWithWait(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }
}
