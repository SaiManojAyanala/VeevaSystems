package org.assessment.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.lang.time.StopWatch;
import org.assessment.desiredproduct1pageobjects.DP1HomePageObjects;
import org.assessment.utilities.Driver;
import org.assessment.utilities.GenericMethods;
import org.assessment.utilities.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.assessment.utilities.Constants.applicationWait;

public class DP1_HomePage {
    WebDriver driver = Driver.getInstance();
    ReadProperties prop = new ReadProperties();
    DP1HomePageObjects dp2HomePageObject = new DP1HomePageObjects(driver);
    SoftAssert softAssert = new SoftAssert();

    GenericMethods genericMethods = new GenericMethods();
    @Given("Login to Derived Product1")
    public void login_to_derived_product1(){
        try {
            genericMethods.launchBrowser(driver,prop.getdesiredProduct1Url());
        }catch (Exception e){
            softAssert.fail(e.getMessage());
        }
        softAssert.assertAll();
    }

    @Then("Validate the count of number of slides present")
    public void validate_count_of_number_of_slides_present(DataTable dataTable){
        try {
            List<Map<String,String>> att =  dataTable.asMaps(String.class,String.class);
            List<WebElement> slides = dp2HomePageObject.getSlides_Text();
            softAssert.assertEquals(Integer.toString(slides.size()),att.get(0).get("slidesCount"), "Validation of Slides count failed");
        }catch (Exception e){
            softAssert
                    .fail(e.getMessage());
        }
        softAssert.assertAll();
    }

    @Then("Validate the tile of each slide")
    public void validate_tile_of_each_slide(DataTable dataTable){
        try {
            int i=1;
            List<Map<String,String>> att =  dataTable.asMaps(String.class,String.class);
            List<WebElement> slides = dp2HomePageObject.getSlides_Text();
            for (WebElement slide:slides) {
                softAssert.assertEquals(slide.getText(),att.get(0).get("slide"+i));
                i++;
            }
        }catch (Exception e){
            softAssert
                    .fail(e.getMessage());
        }
        softAssert.assertAll();
    }

    @Then("Validate the duration of each slide")
    public void validate_the_duration_of_each_slide(DataTable dataTable){

        try {
            List<Map<String,String>> att =  dataTable.asMaps(String.class,String.class);
            List<WebElement> slides = dp2HomePageObject.getSlides();
            StopWatch watch1 = new StopWatch();
            int i =1;
            for (WebElement slide: slides) {
                System.out.println(slide.getCssValue("transition-duration"));
                softAssert.assertEquals(slide.getCssValue("transition-duration"),att.get(0).get("slide"+i+"_Duration"));
                i++;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
