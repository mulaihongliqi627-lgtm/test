import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class firstTest {
//    public void aaa(){
//        //下载驱动——驱动在哪里~~~
//        WebDriverManager.chromedriver().setup();
//
//    }

    //百度搜索关键词
    public void search() throws InterruptedException {
//        1、打开浏览器（驱动）
        WebDriverManager.chromedriver().setup();
//        2)添加浏览器配置
        ChromeOptions options = new ChromeOptions();
        //允许访问所有链接
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
//        2、输入网址:https://www.baidu.com/
        driver.get("https://www.baidu.com/");

//        3、找到输入框,输入关键词:"迪丽热巴"
        driver.findElement(By.cssSelector("#chat-textarea")).sendKeys("迪丽热巴");
//        4、找到百度一下按钮,并点击
        driver.findElement(By.cssSelector("#chat-submit-button")).click();
//        5、关闭浏览器

        driver.quit();
    }
}

