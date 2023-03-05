
# ToolsQA Demo Shop Site

### Smoke Test automation suite for testing [ToolsQA Demo Site](https://shop.demoqa.com/ "ToolsQADemoSite")

## General info

ToolsQA Demo Site is a dummy website for testing purposes. Contains all basic flows of an e-commerce website for shopping.

Users can search for wanted product(s), choose a size, color and quantity and go to checkout. Before finishing an order, a user needs to fill a billing form with personal details and shipping address. User does not need to create an account and login unless they want to check their order.


## Test suite
Test automation suite for "ToolsQA" e-commerce web application written with Selenium TestNG framework in Java using Maven following POM pattern.

Contains E2E smoke test for core functionality. All pages are separated in the pages package(src/main/java/pages) to not violate Single Responsibility Principle. Builder pattern is used for creating Billing form class.
 
In the Utilities class are all variables and methods so we can change them according to our wishes to pass or fail the test. 

Also, created and automated extent reports log(in src/test/java/test_components package). Created Listeners class which is implementing ITestListener - listener for test running. It captures screenshots for failed cases and attaches them to the extent reporter.



## Environment
Homepage: [ToolsQADemo](https://shop.demoqa.com/ "ToolsQADemoSite")

Java Version 17.0.5

Google Chrome Version 110

Ubuntu 22.04.1 LTS

## Deployment

To run test:

```mvn test```

To run smoke_testng.xml(generate custom report) :

```mvn test -PSmoke```

To run test in headless mode:

```mvn test -Dbrowser=chromeheadless```





## Status
Currently the project contains only smoke test.

It is possible to see logs in browser(reports/index.html) after running testng.xml file.
