package org.eugene;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AddCustomerTest { //TODO добавить базовый класс BaseTest
    public static AddCustomerPage addPage;
    public static WebDriver myDriver;
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        myDriver = new ChromeDriver();
        myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        myDriver.get(ConfProperties.getProperty("addpage"));
        addPage = new AddCustomerPage(myDriver);
    }
    @Test
    public void addCustomerTest() {
        String PostCode = addPage.generatePostCode();
        try {
            // Задержка на 2 секунды (2000 миллисекунд)
            Thread.sleep(2000);                     //TODO сделаиь нормальную задержку
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addPage.clickAddCustomer();
        try {
            // Задержка на 2 секунды (2000 миллисекунд)
            Thread.sleep(1000);                     //TODO сделаиь нормальную задержку
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addPage.inputPostCode(PostCode);
        addPage.inputFirstName(PostCode);
        addPage.inputLastName("Scherbakov");
        addPage.clickAddButton();
    }
}
