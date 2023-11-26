package com.java.study.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * ! 비육돈 생체 100kg당 생산비 (년 2008~2022)
 * 농축산물생산비조사 > 축산물 > 비육돈 > 2008년 이후 > 비육돈 생체 100kg당 생산비 (년 2008~2022)
 */
public class Test03 {
    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        // false : gui, true: none
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 60);

        String url = "https://kosis.kr/statHtml/statHtml.do?orgId=101&tblId=DT_1EE305&conn_path=I2";
        driver.get(url);

        try {

            // 바깥쪽 iframe 찾기 (첫 번째 iframe)
            WebElement outerIframe = getDom(wait, "#iframe_rightMenu");

            // 바깥쪽 iframe으로 전환
            driver.switchTo().frame(outerIframe);

            // 안쪽 iframe 찾기 (안쪽 iframe 내에서의 ID)
            WebElement innerIframe = getDom(wait, "#iframe_centerMenu1");

            // 안쪽 iframe으로 전환
            driver.switchTo().frame(innerIframe);


            // ! ----------------------------------------------------------------------
//            Thread.sleep(1000);
            WebElement btnElement = getDom(wait, "#btn_time");
            // onclick이 명시되어있으면 이걸써라
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",btnElement);



            List<WebElement> liElementList = getDomList(wait,"#ft-id-4 li .fancytree-checkbox");
            System.out.println("liElementList.size() = " + liElementList.size());
            for (int i = 0; i < liElementList.size(); i++) {
                if (i > 0) {    // 2022 패스
                    WebElement liElement = liElementList.get(i);
                    try {
                        liElement.click();
                        Thread.sleep(200);
                    } catch(Exception e) {
                        System.out.println("실패해서 재시도");
                        i--;
                        continue;
                    }

                }
            }

            WebElement chartElement = getDom(wait, "#divChartControll");
            js.executeScript("arguments[0].click();",chartElement);
            // ! ----------------------------------------------------------------------









            // ! 안쪽 iframe 내의 thead 찾기
            List<String> theadList = new ArrayList<>();
            List<WebElement> trElementListFromThead = getDomList(wait, "#mainTableT thead tr");


            for (WebElement trElement : trElementListFromThead) {
                List<WebElement> tdElementList = getDomList(wait, "th");
                for (WebElement tdElement : tdElementList) {
                    String value = tdElement.getText().trim();
                    if (!value.equals("")) {
                        theadList.add(tdElement.getText());
                    }
                }
            }
            System.out.println("theadList = " + theadList);



            // ! 안쪽 iframe 내의 tbody 찾기
            List<List<String>> outerList = new ArrayList<>();
            List<WebElement> trList = getDomList(wait,"#mainTable tbody tr");
            for (WebElement trElement : trList) {
                Thread.sleep(1000);
                List<WebElement> tdElementList = getDomList(wait, "td");

                List<String> innerList = new ArrayList<>();
                for (int i = 0; i < tdElementList.size(); i++) {
                    if (i == 0) continue;
                    WebElement tdElement = tdElementList.get(i);
                    String text = tdElement.getText();
                    innerList.add(text);
                }
                outerList.add(innerList);
            }

            List<Integer> v1 = new ArrayList<>();
            List<Integer> v2 = new ArrayList<>();
            List<Integer> v3 = new ArrayList<>();
            List<Integer> v4 = new ArrayList<>();
            List<Integer> v5 = new ArrayList<>();

            DecimalFormat decimalFormat = new DecimalFormat("0");
            for (int i = 0; i < outerList.size(); i++) {
                List<String> valueList = outerList.get(i);
                for (int j = 0; j < valueList.size(); j++) {
                    String valueText = String.join("", valueList.get(j).split(","));
                    Integer value = Integer.valueOf(valueText.trim());
                    if (j == 0) {
                        v1.add(value);
                    } else if (j == 1) {
                        v2.add(value);
                    } else if (j == 2) {
                        v3.add(value);
                    } else if (j == 3) {
                        v4.add(value);
                    } else if (j == 4) {
                        v5.add(value);
                    }
                }
            }

            System.out.println("1000두 미만 : " + v1);
            System.out.println("1000 ~ 1999두 미만 : " + v2);
            System.out.println("2000 ~ 2999두 미만 : " + v3);
            System.out.println("3000두 이상 : " + v4);
            System.out.println("평균 : " + v5);



            // 기본 콘텐츠로 다시 전환 (iframe 바깥으로 나오기)
            driver.switchTo().defaultContent();

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




















