package com.java.study.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class Test01 {
    public static void main(String[] args) throws IOException {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        // Optional: Set Chrome options, such as headless mode
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true); // Run in headless mode (without opening a visible browser window)

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver(options);

        // Navigate to a web page
        driver.get("https://fpbc.nongsu.co.kr");

        // Take a screenshot and save it
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("screenshot.png"));

        // Close the browser
        driver.quit();
    }
}
