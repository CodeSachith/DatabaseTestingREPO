import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class jdbcconnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		String host = "localhost";
		String port = "3306";
		
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port +"/demo" ,"root","sachith123");
		
		Statement s = con.createStatement();
		
		ResultSet rs = s.executeQuery("select * from credentials where scenario = 'zerobalancecard'");
		
		//rs is an array, by default it is in the base index(0th). when s.executeQuery returns results, it stores it starting from the 1st index. therefore to access the 1st index, rs.next  is used to move the pointer to
		
		
		//while loop check whether there is a first index
		while(rs.next()) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sachith\\Downloads\\jars for selenium\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://login.salesforce.com/?locale=eu");
			
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(rs.getString("username"));

			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(rs.getString("password"));
			
			//getString(columnLabel)
			System.out.println(rs.getString("username"));
			System.out.println(rs.getString("password"));
			
			
		}
		
		
		
		

	}

}
