/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.ServiceDAO;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.seleniumhq.jetty9.util.log.Log;

/**
 *
 * @author Admin
 */
public class ServiceGUISeleniumTest {

    @Test
    public void changeIntRatioSuccess() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users/Admin/Documents/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://localhost:8080/SQA_Hospital/home.jsp");
            WebElement cauhinhbtn = (WebElement) driver.findElement(By.id("cauhinh"));
            cauhinhbtn.click();
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "http://localhost:8080/SQA_Hospital/gdcauhinh.jsp");

            Integer dataInTable;
            dataInTable = (driver.findElements(By.className("service"))).size();
            Assert.assertEquals(dataInTable, new Integer(4));

            WebElement testDataBtn = (WebElement) driver.findElement(By.id("10001"));
            testDataBtn.click();
            currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "http://localhost:8080/SQA_Hospital/chiTietCauHinh.jsp?id=10001");

            WebElement ratioTest = (WebElement) driver.findElement(By.id("ratio"));
            ratioTest.clear();
            ratioTest.sendKeys("0.01");
            WebElement submitBtn = (WebElement) driver.findElement(By.id("submit"));
            submitBtn.click();
            currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "http://localhost:8080/SQA_Hospital/gdcauhinh.jsp");

            // ROLL BACK
            driver.get("http://localhost:8080/SQA_Hospital/chiTietCauHinh.jsp?id=10001");
            ratioTest = (WebElement) driver.findElement(By.id("ratio"));
            ratioTest.clear();
            ratioTest.sendKeys("0.1");
            submitBtn = (WebElement) driver.findElement(By.id("submit"));
            submitBtn.click();
            driver.close();

        } catch (Exception e) {
            driver.close();
        }

    }

    @Test
    public void changeIntRatioFailure() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users/Admin/Documents/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://localhost:8080/hospital/home.jsp");
            WebElement cauhinhbtn = (WebElement) driver.findElement(By.id("cauhinh"));
            cauhinhbtn.click();
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "http://localhost:8080/hospital/gdcauhinh.jsp");

            Integer dataInTable;
            dataInTable = (driver.findElements(By.className("service"))).size();
            Assert.assertEquals(dataInTable, new Integer(4));

            WebElement testDataBtn = (WebElement) driver.findElement(By.id("10001"));
            testDataBtn.click();
            currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "http://localhost:8080/hospital/chiTietCauHinh.jsp?id=10001");

            WebElement ratioTest = (WebElement) driver.findElement(By.id("ratio"));
            ratioTest.clear();
            ratioTest.sendKeys("-1");
            WebElement submitBtn = (WebElement) driver.findElement(By.id("submit"));
            submitBtn.click();
            currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "http://localhost:8080/hospital/error.jsp");

            String errorMsg = (driver.findElement(By.id("message")).getAttribute("innerHTML"));
            Assert.assertEquals(errorMsg, "Chiết khấu phải nằm \n"
                    + "trong khoảng hệ số 0 đến 1. Vui lòng nhập\n"
                    + "lại");
            
            driver.close();
        } catch (Exception e) {
            driver.close();
        }

    }
}
