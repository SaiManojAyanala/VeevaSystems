package org.assessment.utilities;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

import static org.assessment.utilities.Constants.applicationWait;

@Slf4j
public class GenericMethods {

    public String getParentWindow(WebDriver driver) throws Exception{
        String parentWindow = "";
        try {
            parentWindow =  driver.getWindowHandle();
            log.info("Generic Methods --- getParentWindow id is " + parentWindow);
        } catch (Exception e) {
            log.error("getParentWindow exception " + e.getMessage() );
            throw new Exception(e.getMessage());
        }
        return parentWindow;
    }

    public void switchWindow(WebDriver driver, String windowId) throws Exception{

        try{
            driver.switchTo().window(windowId);
            log.info("switchWindow - successfully switch to window id " + windowId);
        }catch (Exception e){
            log.error("switchWindow exception " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public Set<String> getWindowIds(WebDriver driver) throws Exception{
        Set<String> s;
        try {
            s = driver.getWindowHandles();
            log.info("getWindowId - window Ids are " +s);
        }catch (Exception e){
            log.error("getWindowIds exception " + e.getMessage());
            throw new Exception(e.getMessage());
        }
        return s;
    }

    public void launchBrowser(WebDriver driver, String Url) throws Exception {
        try {
            driver.get(Url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(applicationWait));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
