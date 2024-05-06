package org.assessment.testcaserunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
       features = "src/test/java/org/assessment/features/derivedproduct2"
        ,glue = {"org/assessment/stepdefinitions","org/assessment/hooks"}
        ,plugin = {"pretty", "html:target/report.html","json:target/JsonReports/derivedproduct2.json"}
        ,monochrome = true
)

public class DP2Runner extends AbstractTestNGCucumberTests {
}
