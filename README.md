# Flipkart Website Automation Testing Project

This project is aimed at automating testing scenarios for the Flipkart website using Selenium, Java, Maven, and TestNG. The project implements various features and best practices to ensure efficient and reliable testing.

## Features Implemented

1. Automated testing of the Flipkart website across different flows and screens.
2. Page Object Model (POM) implemented using Page Factory for better code organization and maintenance.
3. Test data read from Excel files, allowing selective test case execution based on the "Execution Required" field.
4. Configuration files used for managing global parameters.
5. Proper waits (implicit and explicit) utilized for synchronized test execution.
6. Tests run on Microsoft Edge, Chrome, Firefox browsers with an option to run in headless mode.
7. Grouping, priority, and enable/disable features of TestNG used for managing test cases.
8. Assertions used throughout the suite for validating expected outcomes.
9. Error screenshots and detailed assertions added to the Extent Report for effective reporting.
10. Reusable libraries created and imported as JARs for code modularity.
11. ReadMe document provided for installation and running instructions.
12. Integration with Jenkins and GitHub for Continuous Integration/Continuous Deployment (CI/CD) pipelines.
13. Test Suite executable from the command line using Maven.
14. Logger implemented for logging test case execution details.
15. Swipe scroll and Dimensions used for enhanced user interactions.

## Tools Used

- Selenium
- Java
- TestNG
- Maven

## How to Install and Run the Code

1. Clone the repository from GitHub: [repository_link](https://github.com/your-repo-link)
2. Ensure you have Java JDK, Maven, and relevant browsers installed on your system.
3. Set up the project in your preferred IDE (Eclipse, IntelliJ, etc.).
4. Configure the project dependencies and ensure all necessary libraries are included.
5. Update the configuration files with the required parameters such as URLs, API keys, etc.
6. Run the test suite using the Maven command:
   ```
   mvn test
   ```
7. View the test results in the Extent Report generated after the test execution.
8. For CI/CD integration, configure the Jenkins pipeline to pull code from the GitHub repository and execute the tests automatically.


## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
