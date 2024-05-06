package org.assessment.desiredproduct1pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DP1HomePageObjects {

    WebDriver driver;
    By slides_Text = By.xpath("//div[contains(@class,'TileHeroStories_tileHeroStoriesButtons')]/button/div[contains(@class,'TileHeroStories_tileHeroStoriesButtonTitle')]");
    By slides = By.xpath("//div[contains(@class,'TileHeroStories_tileHeroStoriesButtons')]/button");
    public DP1HomePageObjects(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getSlides_Text(){
        return driver.findElements(slides_Text);
    }

    public List<WebElement> getSlides(){
        return driver.findElements(slides);
    }

}
