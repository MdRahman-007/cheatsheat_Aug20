import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by mdrahman on 8/19/18.
 * Spring 2018
 */
public class JavaCheatSheet1 {


    @Test
    public void _1stRun() throws InterruptedException, AWTException, IOException {

        int counter = 1;

        System.setProperty("webdriver.chrome.driver",
                "/Users/mdrahman/Downloads/Selenium/Chrome/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://live.guru99.com/index.php/");
        driver.manage().window().maximize();

try {
//        String string = "Bangladesh";
//        driver.findElement(By.id("email")).sendKeys(string);


////        driver.findElement(By.id("email")).clear();
//
//
//        Actions action = new Actions(driver);
//        action.sendKeys(Keys.TAB).build().perform();
//        Thread.sleep(300);
//
//        Thread.sleep(2000);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_ESCAPE);
//        robot.keyRelease(KeyEvent.VK_TAB);
//
//
//        for (int i = 0; i < 11; i++) {
//            counter++;
//
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("h.mm.ss");
//        String dtString = sdf.format(date);
//        System.out.println(dtString);
//
//        Random random = new Random();
//        int intng = random.nextInt(100);
//        String strng = Integer.toString(intng);
//        String picName = dtString +" "+ strng ;
//
//
//            if (counter % 2 == 0) {
//                System.out.println("Counter " + counter);
//                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//                FileUtils.copyFile(src, new File("/Users/mdrahman/Downloads/ScreenShot/"
//                        + "PicName_" + picName + ".jpeg"));
//
//            } else {
//                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//                FileUtils.copyFile(src, new File("/Users/mdrahman/Downloads/ScreenShot/"
//                        + "PicName_" + picName + ".png"));
//            }
//        }

//        for (int i = 0; i< string.length(); i++) {
//
//            driver.findElement(By.id("email")).sendKeys("\b");
//        }
//
//
//            Thread.sleep(500);


    // Clickon 'Mobile' Menue
    driver.findElement(By.xpath("//li[@class = 'level0 nav-1 first']")).click();
    Thread.sleep(500);

    // In the list of all mobile, click on 'Add to Cart' for sony Xpeira mobile
    driver.findElement(By.xpath("//a[@title='Sony Xperia']//../..//*[contains(text(),'Add to Cart')]")).click();
    Thread.sleep(500);

    // Change Qutitiy value to 1000 and click 'UPDATE' button
    driver.findElement(By.xpath("//td[@class='product-cart-actions']//input")).click();
    WebElement element = driver.findElement(By.xpath("//td[@class='product-cart-actions']//input"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute ('style', 'background : yellow; color : red; border 2px solid red;')", element);

    driver.findElement(By.xpath("//td[@class='product-cart-actions']//input")).clear();
    driver.findElement(By.xpath("//td[@class='product-cart-actions']//input")).sendKeys("1000");

    driver.findElement(By.xpath("//*[@class='product-cart-actions']//button[@type='submit']" +
            "//*[contains(text(),'Update')]")).click();

         // Verify the error message
        String actualText = driver.findElement(By.xpath("//p[@class='item-msg error']")).getText();
    System.out.println(actualText);
        if(actualText.contains("* The maximum quantity allowed for purchase is 500.")){
            System.out.println("Error message displayed correctly.Error message is verified !");
            }else
        {
            System.out.println(" Error message is not matched\n"+
            "Actual : " + actualText + "\nExpected : " +"Error message displayed correctly.Error message is verified ! ");
        }
//
        // Then click on 'Empty Cart' link in the footer of list of all mobiles
        driver.findElement(By.xpath("//span[contains(text(),'Empty Cart')]")).click();
        Thread.sleep(5000);
//        // Verify cart is empty
        String qty = driver.findElement(By.xpath(" //span[@class='count']")).getText();
        int rtyInt = Integer.parseInt(qty);
        if (rtyInt == 0){
            System.out.println("cart is empty");
        }


        }catch(Exception e){

      e.printStackTrace();

        }







        driver.quit();







    }



}
