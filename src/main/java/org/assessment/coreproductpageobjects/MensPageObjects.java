package org.assessment.coreproductpageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MensPageObjects {

    By shirts_Price = By.xpath("//div[@class='product-card row']//child::div[@class = 'spacing']//child::span[@class = 'price']");
    By shirt_Title = By.xpath("//div[@class='product-card-title']/a[@title]");
    //div[@class = 'product-grid-top-area']/following-sibling::div/div[@class = 'column']//div[@class='product-card-title']/a[@title]

    //div[@class='product-card row']//child::div[@class = 'spacing']//child::span[@class = 'price']
    //div[@class='layout-row product-grid']/div//child::span[@class='sr-only']
    WebDriver driver;
    public MensPageObjects(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getShirtsPrice(){
        return driver.findElements(shirts_Price);
    }

    public List<WebElement> getShirtTitle(){
        return driver.findElements(shirt_Title);
    }
}
