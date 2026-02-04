import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class runTest {
    public static void main(String[] args) {
        // 设置驱动 - 不会有任何日志输出
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // 打开百度
            driver.get("https://www.baidu.com");

            // 执行搜索
            WebElement searchBox = driver.findElement(By.id("kw"));
            searchBox.sendKeys("自动化测试");

            WebElement searchButton = driver.findElement(By.id("su"));
            searchButton.click();

            // 等待结果
            Thread.sleep(5000);

            // 简单验证
            if (driver.getTitle().contains("自动化测试")) {
                System.out.println("测试成功！");
            }

        } catch (Exception e) {
            System.out.println("测试失败: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}


