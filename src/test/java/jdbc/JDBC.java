package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JDBC {

	public static void main(String[]args) throws SQLException {
		
		String host ="localhost";
		String port ="3306";
		Connection con =DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/efat", "root", "ifefatt1980");
		Statement s = con.createStatement();
		ResultSet r=s.executeQuery("select*from userName where User='user';");
		
		while(r.next()) {		
			System.setProperty("webdriver.chrome.driver", "/Users/efat/Desktop/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.get("https://login.salesforce.com/");
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys(r.getString("User"));
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(r.getString("Password"));
			
		}
		
	}
}
