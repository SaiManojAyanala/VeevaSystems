package org.assessment.desiredproduct2pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DP2HomePageObjects {

    WebDriver driver;

    By footerSection = By.xpath("//footer[contains(@role,'contentinfo')]");
    By footerSectionsLinks = By.xpath("//footer//nav//li/a");
    public DP2HomePageObjects(WebDriver driver){
        this.driver = driver;
    }

    public void scrollToFooterSection(){
        JavascriptExecutor var = (JavascriptExecutor) driver;
        var.executeScript("arguments[0].scrollIntoView(false);",driver.findElement(footerSection));
    }

    public List<WebElement> getFooterSectionsLinks(){
        return driver.findElements(footerSectionsLinks);
    }

}
