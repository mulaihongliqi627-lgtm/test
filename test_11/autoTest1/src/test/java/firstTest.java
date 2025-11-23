import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class firstTest {
    public void searchTest() throws InterruptedException {
        //下载浏览器驱动
        WebDriverManager.chromedriver().setup();
        //添加浏览器配置
        ChromeOptions options = new ChromeOptions();
        //允许访问所有链接
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //输入网址
        Thread.sleep(1000);
        driver.get("https://www.baidu.com/");
        //找到搜索框，输入关键词
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#chat-textarea")).sendKeys("哔哩哔哩");
        //找到搜索按钮，点击搜索
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#chat-submit-button")).click();
        //关闭浏览器
        Thread.sleep(1000);
        driver.quit();

    }
}
