package org.assessment.coreproductpageobjects;

import org.openqa.selenium.*;

public class HomePageObjects {

    WebDriver driver;

    By shop = By.xpath("//a[@class = 'accent-primary-border style__link_2QXEv']/span[text() = 'Shop']");
    By close_Signup = By.xpath("//div[@class='p-2 absolute right-3 hover:cursor-pointer']");
    By men = By.xpath(" //li[@class = 'menu-item']//child::nav//li/a[contains(text(),'Men')]");

    public HomePageObjects(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnCloseSignup(){
        driver.findElement(close_Signup).click();
    }


    public void clickOnMen(){
        WebElement element = driver.findElement(men);
        JavascriptExecutor driver1 = (JavascriptExecutor) driver;
        driver1.executeScript("arguments[0].click();",element);
    }

}
