package org.assessment.testcaserunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Parameters;

@CucumberOptions(
       features = "src/test/java/org/assessment/features/coreproduct"
        ,glue = {"org/assessment/stepdefinitions","org/assessment/hooks"}
        ,plugin = {"pretty", "html:target/report.html","json:target/JsonReports/coreproduct.json"}
        ,monochrome = true
)

public class CoreProductRunner extends AbstractTestNGCucumberTests {
}
