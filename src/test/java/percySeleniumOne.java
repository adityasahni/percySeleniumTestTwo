import io.github.bonigarcia.wdm.WebDriverManager;
import io.percy.selenium.Percy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class percySeleniumOne {

    @Test
    public void exampleOfTestNgMaven() throws InterruptedException {

        WebDriver driver = null;
        WebDriverManager.chromedriver().browserVersion("87.0.4280.88").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        Percy percy = new Percy(driver);

        driver.get("https://www.invideo.io");
        percy.snapshot("Landing Page");
        WebElement loginBtn = driver.findElement(By.xpath("//*[contains(@class, 'nl-btn login') and contains(text(),'Login')]"));
        loginBtn.click();
        percy.snapshot("Login Page");
        WebElement userName = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
        userName.sendKeys("aditya.sahni@invideo.io");
        WebElement userPwd = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
        userPwd.sendKeys("03021993As!");
        WebElement loginContinue = driver.findElement(By.xpath("//*[contains(@type, 'submit') and contains(text(),'Continue')]"));
        loginContinue.click();
        Thread.sleep(5000);
        Assert.assertEquals("Online Video Editor | Video Creator | InVideo", driver.getTitle());
        percy.snapshot("Home Page");
        driver.quit();
    }

}
