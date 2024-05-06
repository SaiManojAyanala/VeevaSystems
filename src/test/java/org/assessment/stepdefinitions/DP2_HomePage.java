package org.assessment.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assessment.desiredproduct2pageobjects.DP2HomePageObjects;
import org.assessment.utilities.Driver;
import org.assessment.utilities.FileUtilities;
import org.assessment.utilities.GenericMethods;
import org.assessment.utilities.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DP2_HomePage {

    WebDriver driver = Driver.getInstance();
    ReadProperties prop = new ReadProperties();
    SoftAssert softAssert = new SoftAssert();
    DP2HomePageObjects dp2HomePageObjects = new DP2HomePageObjects(driver);
    FileUtilities fileUtilities = new FileUtilities();
    GenericMethods genericMethods = new GenericMethods();

    @Given("Login to Derived Product2 HomePage")
    public void login_to_derived_product2_HomePage(){
        try {
            genericMethods.launchBrowser(driver,prop.getdesiredProduct2Url());
        }catch (Exception e){
            softAssert.fail(e.getMessage());
        }
        softAssert.assertAll();
    }

    @And("Scroll to the Footer section of Homepage")
    public void scroll_to_the_footer_section_of_homepage(){
        try {
            dp2HomePageObjects.scrollToFooterSection();
        }catch (Exception e){
            softAssert.fail(e.getMessage());
        }
        softAssert.assertAll();
    }

    @Then("Validate duplicated hyperlinks in Footer section")
    public void validate_duplicated_hyperlinks_in_Footer(){
        try{
            String csvFilePath = System.getProperty("user.dir") + prop.getDP2DuplicateHyperLinksFilePath();
            fileUtilities.createDirectory(csvFilePath);
            Set<String> hashSet = new HashSet<>();
            List<String[]> duplicate_href = new ArrayList<>();
            List<WebElement> footerSections  =  dp2HomePageObjects.getFooterSectionsLinks();
            for (WebElement section: footerSections) {
                String href = section.getAttribute("href");
                if(!hashSet.contains(href)){
                    hashSet.add(href);
                }else {
                    duplicate_href.add(new String[] {href});
                }
            }
            if(duplicate_href.size()==0){
                System.out.println(duplicate_href);
                duplicate_href.add(new String[] {"No Duplicates Links are found"});
            }
            fileUtilities.writeToCSV(csvFilePath+"/"+prop.getDP2DuplicateHyperLinksFileName(),duplicate_href);
        }catch (Exception e){
            softAssert.fail(e.getMessage());
        }
        softAssert.assertAll();
    }

}
