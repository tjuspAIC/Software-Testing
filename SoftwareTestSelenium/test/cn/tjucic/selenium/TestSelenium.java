package cn.tjucic.selenium;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import jxl.*;
import jxl.read.biff.BiffException;
import java.io.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class TestSelenium {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  static Selenium s;
  private static String[] id;
  private static String[] name;
  private static String[] url;
  private String oneId;
  private String oneName;
  private String oneUrl;

  @Before
  public void setUp() throws Exception {
	  String driverPath = System.getProperty("user.dir") + "/src/resources/driver/geckodriver.exe";
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  driver = new FirefoxDriver();
	  baseUrl = "http://121.193.130.195:8800";
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	  
  }
  
  @Parameters
	public static Collection<Object[]> getData() throws BiffException, IOException{   
		s=new Selenium("»Ìº˛≤‚ ‘√˚µ•.xls");  
		  id=s.id;
		  name=s.name;
		  url=s.url;
		List<Object[]> result=new ArrayList<>();
		   for(int i=0;i<id.length;i++) {
			   result.add(new Object[] {id[i],name[i],url[i]});
		   }
	   return result;
	}
  public TestSelenium(String oneId,String oneName,String oneUrl) {
	  this.oneId=oneId;
	  this.oneName=oneName;
	  this.oneUrl=oneUrl;
  }
  @Test
  public void Test() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.name("id")).click();
    driver.findElement(By.name("id")).clear();
    driver.findElement(By.name("id")).sendKeys(oneId);
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(oneId.substring(4));
    driver.findElement(By.id("btn_login")).click();
    String studentId=driver.findElement(By.id("student-id")).getText();
    assertEquals(oneId,studentId);
    String studentName=driver.findElement(By.id("student-name")).getText();
    assertEquals(oneName,studentName);
    String studentUrl=driver.findElement(By.id("student-git")).getText();
    assertEquals(oneUrl,studentUrl);

    driver.findElement(By.id("btn_logout")).click();
    driver.findElement(By.id("btn_return")).click();
    //assertEquals("Software Test 2019", driver.getTitle());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

