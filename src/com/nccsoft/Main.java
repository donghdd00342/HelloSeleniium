package com.nccsoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        // Chỉ rõ đường dẫn đến file chromedriver.exe ("C:\\chrome\\chromedriver.exe")
        // Nếu sử dụng windows thì comment Linux và ngược lại
        // Window
        //System.setProperty("webdriver.chrome.driver", "ChromeDriver/chromedriver.exe");

        // Linux
        System.setProperty("webdriver.chrome.driver", "ChromeDriver/chromedriver");

        // Tao new myBrowser
        WebDriver myBrowser = new ChromeDriver();

        // url để vào web
        String urlStart = "http://localhost:63342/HelloSelenium/sample.html?_ijt=ieq2k0blhu5vvv5psm1r39qno";

        // Mở web
        myBrowser.get(urlStart);
        ////////////////// Thao tác các test case ở đây //////////////////////
        myBrowser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // chờ ngầm bao nhiêu phút, giây ...

        // DEMO with sample.html
        WebElement userNameInputElement = myBrowser.findElement(By.xpath("/html/body/form/input[1]"));
        WebElement passwordInputFormElement = myBrowser.findElement(By.xpath("/html/body/form/input[2]"));
        WebElement submitButton = myBrowser.findElement(By.xpath("/html/body/form/input[3]"));

        userNameInputElement.sendKeys("Ho Duc Dong");
        passwordInputFormElement.sendKeys("Secret pass");
        submitButton.click();

        String currentUrl = myBrowser.getCurrentUrl(); // currentUrl = urlStart
        String pageTitle = myBrowser.getTitle(); // Tiêu đề trang (xuất hiện phía trên đầu trình duyệt)
        String windowHandleName = myBrowser.getWindowHandle(); //
        Set<String> setWindowHandleNames = myBrowser.getWindowHandles();
        String sourceHTML = myBrowser.getPageSource(); // Source code HTML

        WebDriver.Navigation navigation = myBrowser.navigate();
        navigation.refresh();
        navigation.to("http://google.com.vn");
        myBrowser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // chờ ngầm bao nhiêu phút, giây ...
        navigation.back();

        WebElement element1 = myBrowser.findElement(By.id("myId"));
        WebElement element2 = myBrowser.findElement(By.className("myClassName"));
        WebElement element3 = myBrowser.findElement(By.xpath("/html/body/h1[3]")); // myXpath
        WebElement element4 = myBrowser.findElement(By.cssSelector("myCssSelector"));

        List<WebElement> webElements1 = myBrowser.findElements(By.id("myIds"));
        List<WebElement> webElements2 = myBrowser.findElements(By.className("myClassNames"));
        List<WebElement> webElements3 = myBrowser.findElements(By.xpath("/html/body/h1")); // myXpaths
        List<WebElement> webElements4 = myBrowser.findElements(By.cssSelector("myClassNames")); // myCssSelector

        element1.click();
        String textOnElement = element1.getText();

        // element.findElement(By...)
        // element.findElements(By...)

        WebDriver.Options options = myBrowser.manage();


        myBrowser.manage().timeouts().implicitlyWait(5, TimeUnit.DAYS); // chờ ngầm bao nhiêu phút, giây ...
        /////////////////////////////////////////////////////////////////////
        //đóng trình duyệt
        System.console().readLine();
        myBrowser.close();

    }
}
