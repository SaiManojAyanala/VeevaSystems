# VeevaSystems

Getting Started

This is an example of how you may give instructions on setting up your project locally. To get a local copy up and running follow these simple example steps.
	
Prerequiste:

1. Java version 15
2. Intellij / Eclipse IDE
3. Chrome/ FireFox browser
4. Maven

Description:

Built the Automation Selenium framework, with Maven, Java, TestNG, Cucumber. Choosen Singleton Design pattern to build the framework, and as mentioned in the assignment, choose page object model as object repository to store all the objects of webelements.

Framework Supports the below features.

1. Parallel Execution
2. Cross Browser Testing
3. Parameterization of Testdata either from feature file or from properties file.
4. Generates consolidated cucumber report after completion of Execution.

Versions:

Selenium - 4.19.1
Webdriver Manager - 5.7.0
Cucumber-Core - 7.14.0
Cucumber-testng - 7.14.0
Cucumber-java - 7.14.0

How to Use Framework:

Copy the automation zip folder shared to the local directory and unzip the folder. Open the framework either in Intellij/Eclipse IDE. Once all the dependencies are downloaded, Run it with mvn clean test command.

Update the browser value in testng.xml file, so execution will starts in respective folder.
Increase the thread count greater than 1, so the execution will starts parallel
All the URLs and Folders details of output files are available in EnvironmentVariables.properties file.


Command line to execute the suite: mvn clean test

Results:

After succesful completion of Execution, Results are generated in target folder under project folder. 
 


