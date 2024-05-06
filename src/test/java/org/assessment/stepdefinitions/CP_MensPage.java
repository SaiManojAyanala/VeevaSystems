package org.assessment.stepdefinitions;

import io.cucumber.java.en.Then;
import org.assessment.coreproductpageobjects.MensPageObjects;
import org.assessment.utilities.Driver;
import org.assessment.utilities.FileUtilities;
import org.assessment.utilities.GenericMethods;
import org.assessment.utilities.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CP_MensPage {

    WebDriver driver = Driver.getInstance();
    GenericMethods genericMethods = new GenericMethods();
    MensPageObjects mensPageObjects = new MensPageObjects(driver);
    FileUtilities fileUtilities = new FileUtilities();
    SoftAssert softAssert = new SoftAssert();
    ReadProperties prop = new ReadProperties();

    @Then("Collect the all jackets Price Title and Top Seller Message to a text file")
    public void Collect_all_jackets_Price_Title_and_Top_Seller_Message_to_text_file(){

        List<String> data = new ArrayList<>();
        try{
            String folderPath = System.getProperty("user.dir") + prop.getCPMensProductTXTFilePath();
            // Create Folder under Target Folder
            fileUtilities.createDirectory(folderPath);
            fileUtilities.createFile(folderPath+"/"+prop.getCPMensProductTXTFileName());

            String parentWindow = genericMethods.getParentWindow(driver);
            Set<String> windowIds = genericMethods.getWindowIds(driver);
            for (String str:windowIds) {
                if(!str.equals(parentWindow)){
                    genericMethods.switchWindow(driver,str);
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(150));
                    wait.until(ExpectedConditions.visibilityOfAllElements(mensPageObjects.getShirtsPrice()));
                    List<WebElement> shirtsPrice = mensPageObjects.getShirtsPrice();
                    List<WebElement> shirtsTitle =  mensPageObjects.getShirtTitle();
                    for (int i = 0; i < shirtsPrice.size(); i++) {
                        String[] price = shirtsPrice.get(i).getText().split("\n");
                        data.add(price[0] + "--" + shirtsTitle.get(i).getAttribute("title"));
                    }
                    fileUtilities.writeToTXTFile(folderPath + "/"+prop.getCPMensProductTXTFileName(),data.toString());
                    driver.close();
                    driver.switchTo().window(parentWindow);
                }
            }
        }catch (Exception e){
            softAssert.fail(e.getMessage());
        }
        softAssert.assertAll();
    }

}
