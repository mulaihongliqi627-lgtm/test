import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test_1 {
    public static WebDriver driver;
    public void start(){
        //使用插件管理工具
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //添加浏览器配置
        ChromeOptions options = new ChromeOptions();
        //允许访问所有链接
        options.addArguments("--remote-allow-origins=*");
        //创建浏览器驱动对象
        driver = new ChromeDriver(options);
    }
    public void stop(){
        driver.quit();
    }

    //输入测试
    public void test_print() throws InterruptedException {
        start();
        //访问百度网址
        driver.get("https://www.baidu.com/index.php?tn=68018901_58_oem_dg");
        Thread.sleep(500);
        //找到搜索框输入“命运石之门”
        driver.findElement(By.cssSelector("#chat-textarea")).sendKeys("命运石之门");
        Thread.sleep(500);
        //点击搜索
        driver.findElement(By.cssSelector("#chat-submit-button")).click();
        Thread.sleep(500);
        //找到输入框并清空输入的内容
        WebElement inputBox = driver.findElement(By.cssSelector("#chat-textarea"));
        inputBox.clear();
        //判断清空后的输入框是否可以点击
        WebElement realSubmitButton = driver.findElement(By.cssSelector("#chat-textarea"));
        if(realSubmitButton.isDisplayed() && realSubmitButton.isEnabled()){
            realSubmitButton.click();
        }else{
            throw new InterruptedException("元素不可交互");
        }
        Thread.sleep(500);
        //对清空后的输入框输入“许嵩”

        driver.findElement(By.cssSelector("#chat-textarea")).sendKeys("许嵩");
        Thread.sleep(500);
        driver.findElement(By.cssSelector("#chat-submit-button")).click();
        stop();
    }
}
