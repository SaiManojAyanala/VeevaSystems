package org.assessment.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
import org.testng.xml.XmlTest;

public class Driver {

    // ThreadLocal used to manage the driver
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Private constructor to prevent the creation of new instances of Driver
    private Driver(){}

    // Public method to access the driver instance
    public static WebDriver getInstance(){
        XmlTest xmlTest = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest();
        System.out.println(xmlTest.getParameter("browser"));
        if(driver.get() == null){
            if((xmlTest.getParameter("browser")).equalsIgnoreCase("CHROME")){
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                driver.set(WebDriverManager.chromedriver().capabilities(chromeOptions).create());
            } else if ((xmlTest.getParameter("browser")).equalsIgnoreCase("FIREFOX")) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                driver.set(WebDriverManager.firefoxdriver().capabilities(firefoxOptions).create());
            }

        }
        return driver.get();
    }
}

