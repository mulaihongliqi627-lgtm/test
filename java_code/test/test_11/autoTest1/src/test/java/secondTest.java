import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class secondTest {
    public static WebDriver driver = null;
    public static void start(){
        //1.打开驱动
        WebDriverManager.chromedriver().setup();
        //2.添加对应浏览器配置
        ChromeOptions options = new ChromeOptions();
        //允许访问所有链接
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
    }
    //断开驱动
    public static void stop(){
        driver.quit();
    }
    public void test1(){
        start();
        //打开网址链接
        driver.get("https://www.baidu.com/");
        //查找单个元素
//        WebElement ele = driver.findElement(By.cssSelector("#chat-submit-button"));
//        System.out.println(ele);
        //查找多个元素
        List<WebElement> eles = driver.findElements(By.xpath("//*[@id=\"s-hotsearch-wrapper\"]"));
        //打印元素
        for(WebElement ele : eles){
            System.out.println(ele.getText());
        }
        stop();
    }
    public void test2() throws InterruptedException {
        start();
        driver.get("https://www.baidu.com/");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#chat-textarea")).sendKeys("不想写代码");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#chat-textarea")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#chat-textarea")).sendKeys("不想上课");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#chat-submit-button")).click();
        stop();
    }
}
