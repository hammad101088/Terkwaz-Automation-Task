# Terkwaz Test Automation Assignment

* Implementing a test automation framework using **SHAFT_Engine** fot testing both **GUI** and **API**.
* Implementing modular design by Applying the Page Object Model design pattern (POM).
* Implementing method chaining by Applying the fluent design.
* Externalizing test data using JSON files And Applying data driven testing (DDT).


# Technologies

* JDK-17
* [Maven](https://maven.apache.org/) as a build tool
* [TestNG](https://testng.org/) as a unit test framework
* [SHAFT_ENGINE](https://github.com/MohabMohie/SHAFT_ENGINE) which is a Test Automation Engine that provides a unified high-level interface to any of the underlying test automation frameworks.
* [Selenium WebDriver](https://www.selenium.dev/documentation/en/) for GUI testing.
* [REST-Assured](https://rest-assured.io/) for API testing.
* [Allure Report Framework](https://docs.qameta.io/allure/) for generating test execution report.
* [Docker](https://docs.docker.com/)
* [Selenium Grid](https://www.selenium.dev/documentation/grid/) for remote execution.


# Run the Test
## 1. LOCALLY
Prerequisites: jdk-17 and maven should be installed

### 1.1 Run the Test locally using Eclipse IDE

* Import this project to your eclipse.
* Run the test cases/classes
* The report will be generated automatically after running the test.

### 1.2 Run the Test locally using IntelliJ IDEA

* Import this project to your intellij.
* Kindly, refere to this [link](https://github.com/MohabMohie/using_SHAFT_ENGINE) and follow the steps to add the listeners in intellij.
* Run the test cases/classes
* The report will be generated automatically after running the test.

### 1.3 Run the Test locally using the Terminal or CMD

* Clone or download the project.
* At the root directory of the project (e.g. downloads/projectName/); run the following command ```mvn test```
* The report will be generated automatically after running the test.

------------------

#### Important Note (for local execution):
- By default the report will be automatically generated, but you can check the result of the the test by running "generate_allure_report.bat" or "generate_allure_report.sh" files.

## 2. REMOTELY
Prerequisites: Docker should be installed

### 2.1. Run the Test remotely using Selenium-Grid and Docker
* Clone or download the project.
* To start selenium-grid using docker-compose; at the root directory of the project, run the following command <br />
```
docker-compose -f src/main/resources/docker-compose.yml up --scale chrome=2 --remove-orphans -d
```
* Open [http://localhost:4444/grid/console](http://localhost:4444/grid/console) to monitor selenium grid.
* Run the test using the following command <br />
```
mvn test -DexecutionAddress="localhost:4444" -DtargetOperatingSystem="Linux-64" -DmaximumPerformanceMode="2"
```
* To generate the report: <br />
    - run "generate_allure_report.sh" file if you're using linux/mac. <br />
    - run "generate_allure_report.bat" file if you're using windows.

* To end selenium grid; at the root directory, run the following
```
docker-compose -f src/main/resources/docker-compose.yml down --remove-orphans
```

