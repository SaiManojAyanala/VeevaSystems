package org.assessment.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.assessment.utilities.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;


public class Hooks {

    WebDriver driver = Driver.getInstance();

    @After
    public void beforeScenario(Scenario scenario){
        if(scenario.isFailed()){
            TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
            byte[] data = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(data,"image/png", scenario.getName());
            scenario.log(scenario.getStatus().toString());
        }

    }

}
