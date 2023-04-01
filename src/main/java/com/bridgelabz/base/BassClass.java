package com.bridgelabz.base;

import com.bridgelabz.util.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BassClass {

    public static WebDriver driver=null;

    Properties properties;

    EventFiringWebDriver eventFiringWebDriver;
    WebEventListener webEventListener;

    public BassClass() {
        properties =new Properties();
        FileInputStream fileInputStream=null;
        try {
            fileInputStream =new FileInputStream("src/main/resources/application.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public WebDriver launchBrowser() {

        String browser = properties.getProperty("browser");

        if (browser.equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-notifications");
            driver =  new ChromeDriver(options);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        } else if (browser.equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }
        eventFiringWebDriver=new EventFiringWebDriver(driver);
        webEventListener = new WebEventListener();
        driver=eventFiringWebDriver.register(webEventListener);

        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        return driver;
    }

}
