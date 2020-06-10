package searchCreate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {
	
	public static void main(String[] args) throws IOException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Projects\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Get the home URL
		
		String BaseUrl = "http://127.0.0.1:8081/mimacs/";
		String ExpectedTitle = "MIMACS-II LMS/AMS Console";
		String ActualTitle = "";
		driver.get(BaseUrl);
		driver.manage().window().maximize();
		ActualTitle = driver.getTitle();
	
		// Create object of SimpleDateFormat class and decide the format
		DateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		//get current date time with Date()
		Date date = new Date();
		// Now format the date
		String Date1= DateFormat.format(date);
		
		String TestFile = "C:\\Selenium Projects\\Home Page Test\\selenium_logs.txt";
		File FC = new File(TestFile);//Created object of java File class.
		FC.createNewFile();//Create file.
		  
		//Writing In to file.
		//Create Object of java FileWriter and BufferedWriter class.
		FileWriter FW = new FileWriter(TestFile);
		BufferedWriter BW = new BufferedWriter(FW);
		  //BW.write(""); //Writing In To File.
		  //BW.newLine();//To write next string on new line.
		  //BW.write("This Is Second Line."); //Writing In To File.
		  //BW.close();
		
		if (ActualTitle.contentEquals(ExpectedTitle))
         {
			System.out.println("****************************************");
			System.out.println("*************");
			System.out.println("Test Passed!");
            System.out.println("**************");
            System.out.println("Title Page:" + ActualTitle);
            BW.write(Date1 + " " + ActualTitle);
            BW.newLine();
            //BW.close();
            System.out.println("****************************************");  
         }
        else 
         {
            System.out.println("Test Failed");
            BW.write("Test Failed");
            BW.newLine();
            BW.close();
         }
		//get home page details
		// Grab the table 
		WebElement table = driver.findElement(By.id("j_idt88")); 

		// Now get all the TR elements from the table 
		List<WebElement> allRows = table.findElements(By.tagName("tr")); 

		// And iterate over them, getting the cells 
		BW.write(Date1 + " ");
		for (WebElement row : allRows) 
		{ 
		    List<WebElement> cells = row.findElements(By.tagName("td")); 

		    // Print the contents of each cell
		    for (WebElement cell : cells) 
		    { 
		    	System.out.println(cell.getText());
		    	BW.write(cell.getText()); 
		    }
		}
		 BW.newLine(); 
		 BW.close();
		driver.close(); 
		 
	}
	
	
	
	
	
}
