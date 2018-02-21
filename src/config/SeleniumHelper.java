package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumHelper {
    private SeleniumHelper() {
    }

    public static WebDriver prepareDriver() {
        // Chỉ rõ đường dẫn đến file chromedriver.exe ("C:\\chrome\\chromedriver.exe")
        // Nếu sử dụng windows thì comment Linux và ngược lại
        // Window
        //System.setProperty("webdriver.chrome.driver", "ChromeDriver/chromedriver.exe");

        // Linux
        System.setProperty("webdriver.chrome.driver", "ChromeDriver/chromedriver");

        return new ChromeDriver();
    }
}
