package com.java.study.selenium;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.util.List;


public class 한우정액공개자료 {

    private static String uploadPath2;

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        String url = "https://www.limc.co.kr/know/Sales_List_iframe.asp";

        String uploadPath = "C:\\download_here\\";

        ChromeOptions options = new ChromeOptions();

        JSONObject prefs = new JSONObject();
        prefs.put("download.default_directory", uploadPath);
        prefs.put("download.prompt_for_download", false);

        options.setHeadless(false);     // false : gui, true: none
        options.setExperimentalOption("prefs", prefs.toMap());


        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 60);

        driver.get(url);

        LocalDateTime dateTime = LocalDateTime.now();
        int year = dateTime.getYear();

        try {
            Thread.sleep(2000);
            List<WebElement> trElementList = driver.findElements(By.cssSelector("table.board02 tr"));
            int size = trElementList.size();
            System.out.println("size = " + size);
            for (WebElement trElement : trElementList) {
                WebElement tdElement = trElement.findElement(By.cssSelector("td.le"));
                String text = tdElement.getText();
                if (text.startsWith("한우정액 공개자료") && text.contains(String.valueOf(year))) {
                    System.out.println("text = " + text);
                    WebElement aElement = tdElement.findElement(By.tagName("a"));
                    System.out.println("aElement = " + aElement);
                    aElement.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(5000);
            driver.quit();
        }
    }

    public static WebElement getDom(WebDriverWait wait, String selector) throws InterruptedException {
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
        return webElement;
    }

    public static List<WebElement> getDomList(WebDriverWait wait, String selector) throws InterruptedException {
        List<WebElement> webElementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(selector)));
        return webElementList;
    }
}




















