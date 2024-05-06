package org.assessment.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assessment.coreproductpageobjects.HomePageObjects;
import org.assessment.utilities.Driver;
import org.assessment.utilities.GenericMethods;
import org.assessment.utilities.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;


public class CP_HomePage {

    WebDriver driver = Driver.getInstance();
    ReadProperties prop = new ReadProperties();
    HomePageObjects homePageObjects = new HomePageObjects(driver);
    GenericMethods genericMethods = new GenericMethods();
    SoftAssert softAssert = new SoftAssert();

    @Given("User Login to the Core Product Application")
    public void user_login_to_the_Core_Product_Application(){
            try {
                genericMethods.launchBrowser(driver,prop.getcoreProductUrl());
            }catch (Exception e){
                softAssert.fail(e.getMessage());
            }
            softAssert.assertAll();
    }

    @Then("Skip Signup")
    public void skip_Signup(){
        try {
            homePageObjects.clickOnCloseSignup();
        }catch (Exception e){
            softAssert.fail(e.getMessage());
        }
        softAssert.assertAll();
    }

    @When("User Navigate to shop menu mens")
    public void user_navigate_to_menu(){
        try {
            homePageObjects.clickOnMen();
        }catch (Exception e){
            softAssert.fail(e.getMessage());
        }
        softAssert.assertAll();
    }

    @Given("User Navigate to the CP HomePage")
    public void user_navigate_to_the_CP_HomePage(){
        try {
            Driver.getInstance().get(prop.getcoreProductUrl());
        }catch (Exception e){
            softAssert.fail(e.getMessage());
        }
        softAssert.assertAll();
    }

}
