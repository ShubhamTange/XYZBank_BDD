package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties props;
	static String filename = "src/main/resources/config/config.properties";
	
	public static void launchBrowser() throws IOException {
		fis = new FileInputStream(filename);
		props = new Properties();
		props.load(fis);
		
		if(props.getProperty("Browser").equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
		}else if(props.getProperty("Browser").equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
		}else {
			System.out.println("Browser name is invalid");
		}
	}
	
	public static void navigateToURL() throws IOException{
		fis = new FileInputStream(filename);
		props = new Properties();
		props.load(fis);
		driver.manage().window().maximize();
		driver.get(props.getProperty("URL"));
		
		
	}
	
	public static String captureScreenshots(String scrName) {

		System.out.println("Screenshot for " + scrName);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH_mm_ss");
		String timeStamp = sdf.format(date);

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String scnShotFileName = "src/test/resources/output/screenshot_"+scrName+"_" + timeStamp + ".png";
		File DestFile = new File(scnShotFileName);
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scnShotFileName;

	}
}
