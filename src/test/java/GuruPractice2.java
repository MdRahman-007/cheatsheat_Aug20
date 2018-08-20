

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/**
     * Created by mdrahman on 8/19/18.
     * Spring 2018
     */
    public class GuruPractice2 {
    private By _1stMobileToCompare = By.xpath("//*[@class='products-grid products-grid--max-4-col first last odd']/*[1]//*[contains(text(),'Add to Compare')]");
    private By _2ndMobileToCompare = By.xpath("//*[@class='products-grid products-grid--max-4-col first last odd']/*[2]//*[contains(text(),'Add to Compare')]");
    private By _compare = By.xpath("//button[@title='Compare']//*[contains(text(),'Compare')]");
    private By _compareWindow_1stMobile = By.xpath("//tr/*[2]//*[@class='product-name']");
    private By _compareWindow_2ndMobile = By.xpath("//tr/*[3]//*[@class='product-name']");

    int counter = 1;


    @Test
    public void _1stRun() throws InterruptedException,IOException {

        System.setProperty("webdriver.chrome.driver",
                "/Users/mdrahman/Downloads/Selenium/Chrome/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://live.guru99.com/index.php/");
        driver.manage().window().maximize();

        try {

        // Clickon 'Mobile' Menue
        driver.findElement(By.xpath("//li[@class = 'level0 nav-1 first']")).click();

        // In mobile products list, click on 'Add to compare' for 2 mobiles
        driver.findElement(_1stMobileToCompare).click();
        System.out.println("1st mobile is selected");

        driver.findElement(_2ndMobileToCompare).click();
        System.out.println("2nd mobile is selected");


        // Click on 'COMPARE' button
        driver.findElement(_compare).click();

        //Verify the pop-up window and check that the products are reflected in it
        String parent = driver.getWindowHandle();
        Set <String> set = driver.getWindowHandles();
        Iterator <String> iterator = set.iterator();
        while (iterator.hasNext()){
            String child = iterator.next();
            if (! parent.equals(child)){
                driver.switchTo().window(child);
            }
        }
        String _1stMobileText = driver.findElement(_compareWindow_1stMobile).getText();
        String _2ndMobileText = driver.findElement(_compareWindow_2ndMobile).getText();

        if (_1stMobileText.contains("SONY XPERIA")){
            System.out.println("SONY XPERIA is desplayed");
        }else{
            System.out.println("SONY XPERIA is not desplayed");
        }
        if (_2ndMobileText.contains("IPHONE")){
            System.out.println("IPHONE is desplayed");
        }else{
            System.out.println("IPHONE is not desplayed");
        }

        //Close the Popup Windows
        driver.close();

        }catch(Exception e){

            e.printStackTrace();
        }
        driver.quit();

    }



}











