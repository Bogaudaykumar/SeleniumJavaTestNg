
# Selenium testng project

Automates functional testing of web applications using Selenium WebDriver.

Uses TestNG for test management, organizing test suites, and executing test cases.
Supports data-driven testing via Excel and JSON integration.

Implements cross-browser testing to ensure compatibility across different browsers.
Provides retry mechanisms for failed test cases to enhance reliability.

Generates detailed reports with ExtentReports for visual insights into test results.
Includes screen recording of test executions for better debugging.

Sends automated email notifications with test results and reports.
Suitable for QA engineers and developers automating web testing in CI environments.
Easily integrates with tools like Jenkins for continuous integration and testing.

## Prerequisites
Before setting up and running the project, ensure the following prerequisites are met:
 
- **Java JDK:** Version 8 or above. You can download it from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html).
- **Apache Maven:** Make sure Maven is installed and configured. [Maven Installation Guide](https://maven.apache.org/install.html).
- **WebDriver Executables:** Depending on the browsers you intend to test, download the relevant WebDriver executables (e.g., ChromeDriver for Chrome).
- **IDE:** An IDE like IntelliJ IDEA, Eclipse, or any preferred Java development environment.
 
## Project Setup
 Cloning the Repository
 Clone the project repository using the following command:
 
```bash
git clone https://github.com/Bogaudaykumar/SeleniumJavaTestNg.git
```
 
Navigate to the project directory:
 
```bash
cd SeleniumJavaTestNg
```
 
Install the required dependencies using Maven:
 
```bash
mvn clean install
```
 
This command will download and configure all necessary dependencies specified in the `pom.xml` file.
## Project Structure
Folder Structure :

```
SeleniumJavaTestNG/
│
├── reports/
│   ├── report.html
│
├── src/
│   ├── main/
│   │   ├── resources/
│   │       ├── config.properties
│   │       ├── testData.json
│   │    
│   │       ├── readData.xlsx
│   └── test/
│       ├── java/
│       │   ├── DriverFactory/
│       │   │   ├── BaseTest.java
│       │   ├── pages/
│       │   │   ├── LoginPage.java
│       │   │   ├── AddToCartPage.java
│       │   │   ├── PlaceOrderPage.java
│       │   │   ├── LogoutPage.java
│       │   ├── tests/
│       │   │   ├── Login.java
│       │   │   ├── AddToCart.java
│       │   │   ├── PlaceOrder.java
│       │   │   ├── LoginInvalidTestcase.java
│       │   │   ├── Logout.java
│       │   ├── mail/
│       │   │   ├── Gmail.java
│       │   ├── utilities/
│       │   │   ├── ExcelReader.java
│       │   │   ├── JsonReader.java
│       │   │   ├── RecordUtil.java
│       │   ├── listeners/
│       │   │   ├── Listener.java
│       │   │   ├── Retry.java
│       └── reports/
│           ├── ExtentReportClass.java
│
├── test-recording/
│   ├── screen-recording.avi
│
├── pom.xml
├── testng.xml
├── crossbrowsing.xml
├── grouping.xml
└── parallel.xml

```
## Dependencies with versions

1. `Selenium WebDriver (v4.23.1): For browser automation`
2. `TestNG (v7.10.2): Testing framework`
3. `Apache POI (v5.3.0): For handling Excel files`
4. `JavaMail API (v1.6.2): For email operations`
5. `JSON (v20240303): For JSON processing`
6. `Monte Screen Recorder (v0.7.7.0): For screen recording`
7. `WebDriverManager (v5.9.2): For managing WebDriver binaries`
8. `ExtentReports (v5.0.6): For test reporting`

## Running tests
Running from Command Line
```bash
mvn clean test
```
crossbrowsing execution



## Reports
TestNG Reports
 
After test execution, TestNG generates reports using

`htmlextentreporter`

`extentreport`

 These reports provide insights into test execution, including pass/fail status, execution time, and stack traces for failed tests.
## Screen Recording

This framework includes screen recording capabilities to capture video of test executions. This feature is particularly useful for analyzing failures or demonstrating test scenarios.

`monte-screen-recorder`

Screen recordings are saved in the test-recording directory
Each test method generates a separate video file named after the test
Recordings are in AVI format
## Gmail

The framework can send email notifications with test execution results. This feature keeps stakeholders informed about test outcomes without needing to access the test environment.
Email notifications include:

`com.sun.mail`

`javax.mail`

Overall test suite summary (pass/fail counts)
Links to detailed TestNG reports

## Excel Reader
The Excel reader utility allows you to easily read test data from Excel files. This is particularly useful for data-driven testing scenarios.
Key features:

`apache-poi`

Read data from specific sheets in an Excel workbook
Support for both .xls and .xlsx formats
Ability to read entire rows or specific cells
## Json Reader
The JSON reader utility provides functionality to parse and read data from JSON files, which is useful for configuring tests or storing complex test data structures.
Key features:
`json`

Parse JSON files into Java objects
Read specific fields or nested structures from JSON data
Support for arrays and complex JSON structures
Retry Mechanism

The framework includes a `RetryAnalyzer` that automatically retries failed test cases. This mechanism is controlled by the `retryAnalyzer` attribute in your `@Test` annotations:

```java
@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
public void testMethod() {
    // Test code
}
```

The `RetryAnalyzer` class can be customized to control the number of retries and logging behavior.
 
---
## Continuous Integration (CI)

Integrate the project with CI/CD tools like Jenkins, GitHub Actions, or CircleCI for automated test execution. A typical Jenkins job might look like this:

1. **Create a new job** in Jenkins and link it to your GitHub repository.
2. **Configure the build step** to run Maven commands:
  
3. **Set up post-build actions** to archive test reports and send notifications on build success/failure.

---
## Common Issues

- **WebDriver Version Mismatch:** Ensure your WebDriver executable matches the installed browser version.
- **Dependency Conflicts:** Verify that all dependencies are compatible by reviewing the `pom.xml` and resolving conflicts.
- **TestNG Version Issues:** If you encounter issues with TestNG annotations or execution, ensure you are using the correct TestNG version.

## Debugging Tips

- Use breakpoints and step through the code using your IDE's debugger.
- Add logging statements to track test execution flow.
- Review screenshots or logs generated during test failures to pinpoint issues.