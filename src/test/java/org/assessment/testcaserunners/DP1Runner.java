package org.assessment.testcaserunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
       features = "src/test/java/org/assessment/features/derivedproduct1"
        ,glue = {"org/assessment/stepdefinitions","org/assessment/hooks"}
        ,plugin = {"pretty", "html:target/report.html","json:target/JsonReports/derivedproduct1.json"}
        ,monochrome = true
)

public class DP1Runner extends AbstractTestNGCucumberTests {
}
