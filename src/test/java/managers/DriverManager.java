package managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {


    public  WebDriver driver;

    public  void setDriver(String testBrowser) throws MalformedURLException {
        //SET BROWSER DRİVER FİLE PATH
        //No read to set for Grid (Remote WebDriver) and Bonigarcia. Tyey dont need these setting
       // System.setProperty("webdriver.chrome.driver","src/test/resourses/drivers/chromedriver.exe");
       // System.setProperty("webdriver.gecko.driver","src/test/resourses/drivers/geckodriver.exe");

            switch (testBrowser) {
                case "grid-firefox":
                    FirefoxOptions firefoxOptions=new FirefoxOptions();
                    firefoxOptions.addArguments("start-maximized");
                    driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),firefoxOptions);
                    System.out.println("******* Selenium Grid Firefox **********");
                    break;
                case "grid-chrome":
                    ChromeOptions chromeOptions=new ChromeOptions();
                    chromeOptions.addArguments("start-maximized");
                    driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),chromeOptions);
                    System.out.println("******* Selenium Grid Chrome **********");
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    System.out.println("******* Browser is Firefox **********");
                    break;
                case "firefox-headless":
                    FirefoxOptions firefoxOptions2=new FirefoxOptions();
                    firefoxOptions2.addArguments("--headless");
                    firefoxOptions2.addArguments("--remote-allow-origins=*");
                    firefoxOptions2.addArguments("--window-size=1920,1080");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(firefoxOptions2);
                    System.out.println("******* Browser is Firefox-headless **********");
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    System.out.println("******* Browser is Chrome **********");
                    break;
                case "chrome-headless":
                    ChromeOptions options=new ChromeOptions();
                    options.addArguments("--headless");
                    options.addArguments("--remote-allow-origins=*");
                    options.addArguments("--window-size=1920,1080");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                    System.out.println("******* Browser is Chrome -headless **********");
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    System.out.println("******* Browser is Edge **********");
                    break;
                case "edge-headless":
                    EdgeOptions edgeOptions1=new EdgeOptions();
                    edgeOptions1.addArguments("--headless");
                    edgeOptions1.addArguments("--remote-allow-origins=*");
                    edgeOptions1.addArguments("--window-size=1920,1080");
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver(edgeOptions1);
                    System.out.println("******* Browser is Edge -headless **********");
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    System.out.println("******* Browser is Chrome-bonigarcia **********");
                    break;
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }



}
