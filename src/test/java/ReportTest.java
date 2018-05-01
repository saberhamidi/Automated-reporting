import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReportTest {

    private ExtentReports report;
    private ExtentTest test;

    @Test
    public void verifyHomePageTitle(){

        report = new ExtentReports("/report.html", false);
        test = report.startTest("Verify Home Page Title");

        System.setProperty("webdriver.chrome.driver", "../chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        test.log(LogStatus.INFO, "Browser started");
        driver.get("https://www.qa.com/");

        String title = driver.getTitle();

        System.out.println(title);

        if(title.equals("IT Training | Project Management Training | Business Skills Training | QA")){
            test.log(LogStatus.PASS, "Verify Home Page Title");
        }
        else test.log(LogStatus.FAIL, "Verify Home Page Title");

        report.endTest(test);
        report.flush();
        driver.quit();
    }
}
