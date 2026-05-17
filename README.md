# KrystalBall Selenium Automation Framework

## Project Overview

This project is a Selenium WebDriver automation framework developed for testing the KrystalBall / SmartPad Customer Feedback web application.

The framework validates key workflows such as landing page navigation, alcohol type selection, login popup validation, continue without account flow, product search, empty login validation, and invalid login validation.

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Gradle
- WebDriverManager
- ChromeDriver
- Extent Reports

## Framework Design

The project follows the Page Object Model design pattern.

### Folder Structure

- Base: Contains BaseTest and BasePage classes
- pages: Contains page object classes and reusable page actions
- tests: Contains TestNG test classes
- utils: Contains configuration reader and reporting utilities
- resources: Contains config.properties and testng.xml

## Key Improvements Implemented

- Refactored test-script driven code into Page Object Model structure
- Moved locators and page actions into separate page classes
- Added reusable wrapper methods for click, type, waits, scrolling, and JavaScript click
- Removed Thread.sleep usage
- Removed implicit waits and used explicit waits
- Added config.properties for external test data
- Added TestNG priorities and groups
- Improved exception handling for optional popups and stale elements
- Integrated Extent Reports for HTML reporting
- Configured Gradle test logging for passed, failed, and skipped tests

## Note on Locators

XPath locators were used only where stable IDs, names, or data-testid attributes were not available in the application DOM. All locators are centralized inside Page Object classes to improve maintainability and reduce duplication.

## Test Scenarios Automated

- Verify landing page loads successfully
- Verify alcohol type navigation
- Verify login popup modal display
- Verify continue without account functionality
- Verify valid product search
- Verify invalid product search
- Verify empty login validation
- Verify invalid login validation

## How To Run Tests

```bash
./gradlew clean test --rerun-tasks
```