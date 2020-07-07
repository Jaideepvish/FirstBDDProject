/**
 * 
 */
package com.jaiworld.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author jaideepvish
 *
 */
public class PropertyReader {
	
	private static final String configPath = "src/main/resources/properties/configuration.properties";
	
	private String browserName;
	
	private String url;
	
	private String userName;
	
	private String password;
	
	private String destination;
	
	private String checkInToDate;
	
	private String checkInFromDate;
	
	private WebDriver driver; 
	
	
	public PropertyReader() {
		try (InputStream input = new FileInputStream(configPath)) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);
            setBrowserName(prop.getProperty("browserName"));
            setUrl(prop.getProperty("url"));
            setUserName(prop.getProperty("userName"));
            setPassword(prop.getProperty("password"));
            setDestination(prop.getProperty("destination"));
            setCheckInFromDate(prop.getProperty("checkInFromDate"));
            setCheckInToDate(prop.getProperty("checkInToDate"));
            setDriver(driver);
            
		}catch (IOException ex) {
			ex.printStackTrace();
		} 		
	}	
	
	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getDestination() {
		return destination;
	}



	public void setDestination(String destination) {
		this.destination = destination;
	}



	public String getCheckInToDate() {
		return checkInToDate;
	}



	public void setCheckInToDate(String checkInToDate) {
		this.checkInToDate = checkInToDate;
	}



	public String getCheckInFromDate() {
		return checkInFromDate;
	}



	public void setCheckInFromDate(String checkInFromDate) {
		this.checkInFromDate = checkInFromDate;
	}



	public static String getConfigpath() {
		return configPath;
	}



	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}



	public String getBrowserName() {		
		return browserName;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		
		String browserName = getBrowserName();
		
		switch(browserName) {
			case "chrome" :
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox" :
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "ie" :
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			case "edge" :
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			default :
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
		}
		this.driver = driver;
	}
	
	

}
