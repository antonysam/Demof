import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicTabbedPaneUI.TabSelectionHandler;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.openqa.selenium.support.ui.Select;

public class Tour {
	WebDriver d;
	XSSFWorkbook w;
	XSSFSheet s;
	XSSFCell cell;
	public void newtour() {
		try {
			System.setProperty("webdriver.chrome.driver","F:\\selenium stuffs\\selenium\\chromedriver.exe");
			d = new  ChromeDriver();
			
			String actualurl = "http://newtours.demoaut.com/mercurysignon.php";
			String demo = "http://newtours.demoaut.com/mercurysignon.php";
			
			//to verify wheather the launched URL is correct
			if(actualurl.equals(demo)) 
			{
				System.out.println("The entered URL is correct");
			}
			else 
			{
				System.out.println("The entered URL is in correct");
			}
			
			//launching the demo url 
			d.get(demo);
			
			Thread.sleep(2000);
			
			
    //login page
			//details to be printed in console
			System.out.println("==========================LOGIN PAGE (WEB ELEMENTS COUNT)==================================");
		    System.out.println();
		    //no of images
			List<WebElement>lo1= d.findElements(By.tagName("img"));
			System.out.println("1)No of images "+lo1.size());
			System.out.println();
		   
			//no of input boxes
			List<WebElement>lo2 = d.findElements(By.tagName("input"));
			System.out.println("2)No of input boxes "+lo2.size());
			System.out.println();
			
			//footer 
			WebElement footer = d.findElement(By.xpath("//div[@class='footer']"));
			Boolean bf = footer.isDisplayed();
			System.out.println("Footer :"+bf);
			
			File src = new File("F:\\selenium stuffs\\excel\\login_dataset.xlsx");
			
			
			//load the file
			FileInputStream finput = new FileInputStream(src);
			
			//load the workbook
			w = new XSSFWorkbook(finput);
			
			//load the sheet
			s = w.getSheetAt(0);
			
			for(int i=1; i<=s.getLastRowNum();i++) {
			
				//Import data to demo site
				   //incrementing the row and accessing the 1st cell
				try {
					
					cell = s.getRow(i).getCell(1);
					cell.setCellType(cell.CELL_TYPE_STRING);
					d.findElement(By.name("userName")).sendKeys(cell.getStringCellValue());
					
					System.out.println("there is no problem in excell sheet");
					cell = s.getRow(i).getCell(2);
					cell.setCellType(cell.CELL_TYPE_STRING);
					d.findElement(By.name("password")).sendKeys(cell.getStringCellValue());
				} catch (Exception e) {
					System.out.println("there is some problem in excell sheet");
					e.printStackTrace();
				}
		
			   FileOutputStream foutput = new FileOutputStream(src);
			   
			   String message = "Data imported successfully";
			   
			   s.getRow(i).createCell(3).setCellValue(message);
			   
			   w.write(foutput);
			   
			   foutput.close();
			}
			
			//signin page
			/*d.findElement(By.name("userName")).sendKeys("tutorial");
			d.findElement(By.name("password")).sendKeys("tutorial");
			//d.findElement(By.xpath("//input[@type='image']")).click();*/
			d.findElement(By.xpath("//input[@type='image']")).submit();
			
	//flight details
		
			//d.navigate().back();
			//d.navigate().forward();
			
			//details to be printed in console
			System.out.println("==========================FLIGHT DETAILS PAGE(WEB ELEMENTS COUNT)==================================");
			System.out.println();
			System.out.println("Flight Details page details ");
			
			//to get the title of the Flight details page
			String title1 = d.getTitle();
			System.out.println("Title  "+ title1);
			int title_length = d.getTitle().length();
			System.out.println();
			System.out.println("Length of the title "+title_length);
			
			
			System.out.println();
			
			//to print the url of the flight detail page
			String url1 = d.getCurrentUrl();
			System.out.println("url  "+  url1);
			
			System.out.println();
			
			 //checks wheather the type radio button is enabled
		    WebElement ll2 = d.findElement(By.xpath("//input[@value='roundtrip']"));
		    Boolean b2 =ll2.isEnabled();
		    System.out.println(b2);
			
		    System.out.println();
			//to get the no of dropdowns in the flight details page
			List<WebElement> l2 = d.findElements(By.tagName("Select"));
			System.out.println("1)No.of drop downs "+l2.size());
			
			System.out.println();
			
			//to get the no of radio buttons in the flight details page
			List<WebElement> l3 = d.findElements(By.xpath("//input[@type='radio']"));
			System.out.println("2)No of radio buttons  "+l3.size());
			
			System.out.println();
			
			//to get the no of link-text in the Flight details page
			List<WebElement>l4 = d.findElements(By.tagName("a"));
			System.out.println("3)No of link-text  "+l4.size());
			
			System.out.println();
			
			//to count the no of images present in the flight details page
			List<WebElement>l1 = d.findElements(By.tagName("img"));
			System.out.println("4)No of images "+ l1.size());
			
			//footer 
			WebElement footer2 = d.findElement(By.xpath("//div[@class='footer']"));
			Boolean bf2 = footer2.isDisplayed();
			System.out.println("Footer :"+bf2);
			
			System.out.println();
			
			//to print pagesource
			System.out.println("==========================PAGE SOURCE(FLIGHT DETAILS)==================================");
			String pg1 = d.getPageSource();
			System.out.println(pg1);
			System.out.println();
			System.out.println("==========================END==================================");
			System.out.println();
			int page_source_length = d.getPageSource().length();
			System.out.println("Length of the above page_source "+page_source_length);
			System.out.println("");
			//Type
			
			
			//Passengers
			
			String s0 = d.getTitle();
			System.out.println("Tilte  "+s0);
			System.out.println("");
			
			System.out.println("Displays the selected and remaining options");
			System.out.println("");
			WebElement pass = d.findElement(By.name("passCount"));
			Select passCount = new Select (pass);
			passCount.selectByVisibleText("2");
			passCount.selectByIndex(1);
			
			
			String s1 =pass.getText();
			System.out.println("options displayed in passenger dropdown");
			System.out.println(s1.trim());
			
			
			
			
			
			System.out.println("");
			//departing from
			WebElement depart = d.findElement(By.name("fromPort"));
			Select fromPort = new Select(depart);
			fromPort.selectByVisibleText("Acapulco");
			fromPort.getOptions();
			fromPort.selectByIndex(3);
			String s2 = depart.getText();
			System.out.println("options displayed in depart dropdown");
			System.out.println(s2.trim());
			
			
			
			System.out.println("");
			//On
			WebElement month =d.findElement(By.name("fromMonth"));
			Select fromMonth = new Select(month);
			fromMonth.selectByVisibleText("June");
			fromMonth.selectByIndex(3);
			String s3 = month.getText();
			fromMonth.getFirstSelectedOption();
			System.out.println("options displayed in on_month dropdown");
			System.out.println(s3.trim());
			
			//d.findElement(By.xpath("//select[@name='fromDay']//option[@value='2']")).click();
		
			 WebElement year1 = d.findElement(By.name("fromDay"));
			 Select year = new Select(year1);
		     year.selectByVisibleText("14");
		     year.getOptions();
		     year.selectByIndex(3);
		     System.out.println("options displayed in on_year dropdown");
		     System.out.println(year1.getText());
			
			
		     System.out.println("");
			//Arriving In
		    try {
				WebElement port_ =  d.findElement(By.xpath("//select[@name='toPort']"));
				Select toPort_ = new Select (port_);
				toPort_.selectByVisibleText("Acapulco");
				toPort_.getOptions();
				toPort_.selectByIndex(4);
				System.out.println("options displayed in to_port dropdown");
				 System.out.println(port_.getText());
			} catch (Exception e) {
				System.out.println("lines dint executed");
				e.printStackTrace();
			}
			
			 System.out.println("");
			 //Returning 
			WebElement Month = d.findElement(By.name("toMonth"));
			Select toMonth  = new Select (Month);
			toMonth.selectByVisibleText("June");
			toMonth.selectByIndex(4);
			System.out.println("options displayed in to_month dropdown");
			System.out.println(month.getText());
			System.out.println("");
			
			WebElement year2 =d.findElement(By.name("toDay"));
			Select year2_ = new Select(year2);
			 year2_.selectByVisibleText("14");
			 year2_.selectByIndex(7);
		     System.out.println("options displayed in on_year dropdown");
		     System.out.println(year2.getText());
			
			System.out.println("");
			//service class
			
			d.findElement(By.xpath("//input[@name='servClass' and @value='Business']")).click();
			
			System.out.println("");
			//Airline
			WebElement air = d.findElement(By.name("airline"));
			Select airline = new Select(air);
			airline.selectByVisibleText("No Preference");
			airline.selectByIndex(2);
			System.out.println("options displayed in airline dropdown");
			System.out.println(air.getText());
			
			
			
			//continue
			d.findElement(By.name("findFlights")).click();
			
			//to print the url of the select flight page
			
			
			//robot class for clicking ctrl+t
			Robot r = new Robot();
			/*r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_T);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_T);
			
			
			
			ArrayList<String> tabs = new ArrayList<String>(d.getWindowHandles());
		    d.switchTo().window(tabs.get(1));
		    d.get(url2);
		    
		 //Book a flight 
		    //passenger details
			
			d.get("http://newtours.demoaut.com/mercurypurchase.php");*/
			System.out.println("==========================BOOK A FLIGHT==================================");
			System.out.println("");
			String btitle = d.getTitle();
			System.out.println("Title of Book a Flight :"+btitle);
			
			System.out.println("");
			String url2 = d.getCurrentUrl();
			System.out.println("url of the BOOK A FLIGHT page "+ url2);
			
			List<WebElement> l5 = d.findElements(By.tagName("Select"));
			System.out.println("1)No.of drop downs "+l5.size());
			
			System.out.println();
			
			//to get the no of radio buttons in the flight details page
			List<WebElement> l6 = d.findElements(By.xpath("//input[@type='radio']"));
			System.out.println("2)No of radio buttons  "+l6.size());
			
			System.out.println();
			
			//to get the no of link-text in the Flight details page
			List<WebElement>l7 = d.findElements(By.tagName("a"));
			System.out.println("3)No of link-text  "+l7.size());
			
			System.out.println();
			
			//to count the no of images present in the flight details page
			List<WebElement>l8 = d.findElements(By.tagName("img"));
			System.out.println("4)No of images "+ l8.size());
			
			System.out.println();
			
			//footer 
			WebElement footer1 = d.findElement(By.xpath("//div[@class='footer']"));
			Boolean bf1 = footer1.isDisplayed();
			System.out.println("Footer :"+bf1);
			
			System.out.println();
			
			//for passenger1
			d.findElement(By.xpath("//input[@name='reserveFlights']")).click();
		    d.findElement(By.xpath("//input[@name='passFirst0']")).sendKeys("Sam");
		    d.findElement(By.xpath("//input[@name='passLast0']")).sendKeys("Dany");
		    
		    //meal
		    WebElement meal1 = d.findElement(By.name("pass.0.meal"));
		    Select meal = new Select(meal1);
		    meal.selectByVisibleText("No preference");
		    meal.getFirstSelectedOption();
		    meal.selectByIndex(3);
		    System.out.println("options displayed in meal dropdown");
		    System.out.println(meal1.getText().trim());
		    
		    WebElement fn2 = d.findElement(By.xpath("//input[@name='passFirst1']"));
		    fn2.sendKeys("Sam");
		    d.findElement(By.xpath("//input[@name='passLast1']")).sendKeys("Dany");
		   
		    //meal
		    WebElement meal2 = d.findElement(By.name("pass.1.meal"));
		    Select meal_ = new Select(d.findElement(By.name("pass.1.meal")));
		    meal_.selectByVisibleText("No preference");
		    meal_.selectByIndex(3);
		    meal_.getFirstSelectedOption();
		    //System.out.println("option selected "+meal2.getText());
		 
		    System.out.println("");
		    //credit card details
		    //cardtype
		    WebElement cardty = d.findElement(By.name("creditCard"));
		    Select cardtype = new Select(cardty);
		    cardtype.selectByVisibleText("American Express");
		    cardtype.selectByIndex(2);
		    System.out.println("options displayed in card dropdown");
		    System.out.println(cardty.getText());
		   
		    //card number
		    d.findElement(By.name("creditnumber")).sendKeys("1456894759632175");
		    
		    //expiration
		    WebElement day = d.findElement(By.name("cc_exp_dt_mn"));
		    Select day_ = new Select(day);
		    day_.selectByVisibleText("None");
		    day_.selectByIndex(3);
		    System.out.println("options displayed in credit_day dropdown");
		    System.out.println(day.getText());
		    System.out.println("");
		    
		    WebElement yearc = d.findElement(By.name("cc_exp_dt_yr"));
		    Select year_ = new Select(yearc);
		    year_.selectByVisibleText("None");
		    year_.selectByIndex(3);
		    System.out.println("options displayed in credit_year dropdown");
		    System.out.println(yearc.getText());
		    
		    //FirstName
		    d.findElement(By.name("cc_frst_name")).sendKeys("Sam");
		    
		    //Middle
		    d.findElement(By.name("cc_mid_name")).sendKeys("william");
	  
		    //Last
		    d.findElement(By.name("cc_last_name")).sendKeys("Dany");
		 //Billing Address
		    //Address
		    WebElement addr = d.findElement(By.name("billAddress1"));
		    addr.clear();
		    addr.sendKeys("#12,enclave1,racecourse");
		    //city
		    WebElement city =d.findElement(By.name("billCity"));
		    city.clear();
		    city.sendKeys("coimbatore");
		    //State
		    WebElement state = d.findElement(By.name("billState"));
		    state.clear();
		    state.sendKeys("Tamil Nadu");
		    //postal code
		    WebElement code =d.findElement(By.name("billZip"));
		    code.clear();
		    code.sendKeys("641035");
		    //country
		    WebElement country = d.findElement(By.name("billCountry"));
		    Select country_ = new Select(country);
		    country_.selectByVisibleText("UNITED STATES ");
		    country_.selectByIndex(91);
		    System.out.println("options displayed in country dropdown");
		    System.out.println(country.getText());
		    
		    
		    //same as Billing Address
		    //Address
		    WebElement addr1 = d.findElement(By.name("delAddress1"));
		    addr1.clear();
		    addr1.sendKeys("#12,enclave1,racecourse");
		    //city
		    WebElement city1 =d.findElement(By.name("delCity"));
		    city1.clear();
		    city1.sendKeys("coimbatore");
		    //State
		    WebElement state1 = d.findElement(By.name("delState"));
		    state1.clear();
		    state1.sendKeys("Tamil Nadu");
		    //postal code
		    WebElement code1 =d.findElement(By.name("delZip"));
		    code1.clear();
		    code1.sendKeys("641035");
		   
		    
		    d.quit();
		    
		} catch (Exception e) {
		 e.printStackTrace();
		}
	
	
	
	
	}

	public static void main(String[] args) {
		Tour o = new Tour();
		o.newtour();

	}

}
