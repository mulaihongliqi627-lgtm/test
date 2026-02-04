import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

public class Test_3 {
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

    public void test01() throws InterruptedException {
        start();
        driver.get("https://www.baidu.com/");
        driver.findElement(By.cssSelector("#chat-textarea")).sendKeys("命运石之门");
        driver.findElement(By.cssSelector("#chat-submit-button")).click();
        Thread.sleep(2000);
        stop();
    }
    public void test02(){
        start();
        driver.get("https://www.baidu.com/");
        String testContent = driver.findElement(By.cssSelector("#hotsearch-content-wrapper > li:nth-child(10) > a > span.title-content-title")).getText();
        //System.out.println(testContent);
        String testContent2 = driver.findElement(By.cssSelector("#chat-submit-button")).getAttribute("div class");
        //System.out.println(testContent2);
        driver.findElement(By.cssSelector("#chat-textarea")).sendKeys("命运石之门");
        driver.findElement(By.cssSelector("#chat-submit-button")).click();

        String curWindows = driver.getWindowHandle();
        Set<String> totalWindows = driver.getWindowHandles();
        System.out.println("总窗口数量为 " + totalWindows.size());
        System.out.println(driver.getCurrentUrl());
//        for(String w : totalWindows){
//            System.out.println(w);//打印遍历的属性句柄
//        }
        //driver.close();
        //stop();
    }
}
