# Google.com Selenium Automation Footers Test
This Java program uses the Selenium FireFox geckodriver.exe driver to test all of the footers in the Google.com search home page.

# Program Overview:
1. Initializes WebDriver: The program sets up the Firefox WebDriver and opens the Google homepage.

2. Testing Settings Menu: The program clicks on the settings menu (the gear icon), tests various options within the menu, and verifies whether each corresponding page title matches the expected title.

3. Testing Dark Mode: The program tests both the "Dark Theme: Off" and "Dark Theme: On" settings by toggling the dark theme and checking if the page source contains the expected text.

4. Footer Testing: The program defines a method `testFooter()` that accepts a footer element's text and its expected title as parameters. This method clicks on the footer link, waits for the page to load, and checks if the page title matches the expected title.

5. Output and Reporting: The program prints the results of each test to the console, indicating whether the test was successful or failed.

6. Cleanup: After each test, the WebDriver instance is closed.

# Additional Notes:
Note that the program includes some hard-coded paths to the Firefox WebDriver executable, which may need to be updated based on your system configuration. The main class, `FooterTest`, contains the test scenarios and method calls.

The program is primarily focused on verifying the titles of various settings and footer tabs on the Google homepage. It uses Selenium WebDriver commands to interact with the web elements and perform assertions on the page content.

Additionally, some improvements could be made to enhance the code's readability and maintainability, such as using constants for repeated values and separating concerns into separate methods or classes.

It's important to keep in mind that Selenium tests are sensitive to changes in web page structure, so regular updates to the program might be required to ensure continued functionality as the Google homepage evolves.
