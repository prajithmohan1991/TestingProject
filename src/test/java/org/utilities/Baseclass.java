package org.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static Alert al;
	public static TakesScreenshot tk;
	public static JavascriptExecutor js;
	public static Select s;
	public static WebElement ele;

	// METHOD--1
	public static void launchChrome() throws AWTException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		a = new Actions(driver);
		r = new Robot();
		TakesScreenshot tk = (TakesScreenshot) driver;
		JavascriptExecutor js = (JavascriptExecutor) driver;

	}

	// METHOD--2
	public static void launchFirefox() throws AWTException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

	}

	// METHOD--3
	public static void launchEdge() throws AWTException {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

	}

	// METHOD--4
	public static void winMax() {
		driver.manage().window().maximize();
	}

	// METHOD--5
	public static void loadUrl(String siteName) {
		driver.get(siteName);

	}

	// METHOD-- 6
	public static void printTitle() {
		System.out.println(driver.getTitle());
	}

	// METHOD--7
	public static void printCurrentUrl() {
		System.out.println(driver.getCurrentUrl());
	}

	// METHOD-- 8
	public static void fill(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	// METHOD-- 9
	public static void takeText(WebElement ele) {
		System.out.println(ele.getText());
	}

	// METHOD-- 10
	public static void takeattribute(WebElement ele, String attribute) {
		System.out.println(ele.getAttribute(attribute));
	}

	// METHOD-- 11
	public static void btnClick(WebElement ele) {
		ele.click();

	}

	// METHOD-- 12
	public static void closeChrome() {
		driver.close();

	}
	// METHOD-- 13
		public static void closeFirefox() {
			driver.close();

		}
		// METHOD-- 14
		public static void closeEdge() {
			driver.close();

		}
	// METHOD-- 15
	public static void quitChrome() {
		driver.quit();

	}

	// METHOD-- 16
	public static void actionMove(WebElement ele) {
		a.moveToElement(ele).perform();

	}

	// METHOD-- 17
	public static void actionMoveAndClick(WebElement ele) {
		a.moveToElement(ele).click().perform();

	}

	// METHOD-- 18
	public static void actionMoveAndClickBuild(WebElement ele) {
		a.moveToElement(ele).click().build().perform();

	}

	// METHOD-- 19
	public static void actionDrag(WebElement src, WebElement dsc) {
		a.dragAndDrop(src, dsc).build().perform();

	}

	// METHOD-- 20
	public static void actionDoubleClik(WebElement ele) {
		a.doubleClick(ele).build().perform();

	}

	// METHOD-- 21
	public static void actionContextClik(WebElement ele) {
		a.contextClick(ele).build().perform();

	}

	// METHOD-- 22
	public static void actionKeyUp(WebElement ele, Keys keys) {
		a.keyUp(ele, keys).perform();

	}

	// METHOD-- 23
	public static void actionKeyDown(WebElement ele, Keys keys) {
		a.keyDown(ele, keys).perform();

	}

	// METHOD-- 24
	public static void actionSendKeys(WebElement snd, String value) {
		a.sendKeys(snd, value).perform();

	}

	// METHOD-- 25
	public static void actionClick(WebElement clc) {
		a.click(clc).perform();

	}

	// METHOD-- 26
	public static void robotPress(int press) {
		r.keyPress(press);

	}

	// METHOD-- 27
	public static void robotRelease(int release) {
		r.keyPress(release);

	}

	// METHOD-- 28
	public static void alertAccept() {
		al = driver.switchTo().alert();
		al.accept();

	}

	// METHOD-- 29
	public static void alertDismiss() {
		al = driver.switchTo().alert();
		al.dismiss();

	}

	// METHOD-- 30
	public static void alertSendKeys(String value) {
		al = driver.switchTo().alert();
		al.sendKeys(value);

	}

	// METHOD-- 31
	public static void alertGetText() {
		al = driver.switchTo().alert();
		System.out.println(al.getText());

	}

	// METHOD-- 32
	public static void frameId(String id) {
		driver.switchTo().frame(id);

	}

	// METHOD-- 33
	public static void frameName(String name) {
		driver.switchTo().frame(name);

	}

	// METHOD-- 34
	public static void frameWebelementRef(WebElement ref) {
		driver.switchTo().frame(ref);

	}

	// METHOD-- 35
	public static void frameIndex(int index) {
		driver.switchTo().frame(index);

	}

	// METHOD-- 36
	public static void frameParent() {
		driver.switchTo().parentFrame();
	}

	// METHOD-- 37
	public static void frameDefaultContent() {
		driver.switchTo().defaultContent();

	}

	// METHOD-- 38
	public static void screenShot(String imgname) throws IOException {
		File src = tk.getScreenshotAs(OutputType.FILE);
		File dsc = new File("C:\\Users\\Lenovo\\eclipse-workspace\\Day1FrameWork\\screenshot" + imgname + ".png");
		FileUtils.copyFile(src, dsc);

	}

	// METHOD-- 39
	public static void scrollTrue(String argu, WebElement ref) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(argu, ref);
	}

	// METHOD-- 40
	public static void scrollFalse(String argu, WebElement ref) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(argu, ref);
	}

	// METHOD-- 41
	public static void javaScriptSendKeys(String argu, WebElement ref) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(argu, ref);
	}

	// METHOD-- 42
	public static void javaScriptAttribute(String argu, WebElement ref) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(argu, ref);
	}

	// METHOD-- 43
	public static void javaScriptHighlight(String argu, WebElement ref) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background:yellow; border:10px solid green')", ref);
	}

	// METHOD-- 44
	public static void javascriptClick(String argu, WebElement ref) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ref);
	}

	// METHOD-- 45
	public static void windowHandleParent() {
		Set<String> child = driver.getWindowHandles();
		List<String> li = new ArrayList<String>();
		li.addAll(child);
		String wind = li.get(0);
		driver.switchTo().window(wind);
	}

	// METHOD-- 46
	public static void windowHandlesChild() {
		// driver.getWindowHandles();
		Set<String> child = driver.getWindowHandles();
		List<String> li = new ArrayList<String>();
		li.addAll(child);
		String wind = li.get(1);
		driver.switchTo().window(wind);
	}

	// METHOD-- 47
	public static void windowByUrl(String url) {
		String windo = driver.getWindowHandle();
		driver.switchTo().window(windo);
	}

	// METHOD-- 48
	public static void windowByTitle(String title) {
		driver.switchTo().window(title);
	}

	// METHOD-- 49
	public static void windowByWindId(String windowid) {
		driver.switchTo().window(windowid);
	}

	// METHOD-- 50
	public static void sleep(int sec) throws InterruptedException {
		Thread.sleep(sec);

	}

	// METHOD-- 51
	public static void waitImpli(long time, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(time, unit);

	}

	// METHOD-- 52
	public static void waitWebdriver(String name) {
		WebDriverWait w = new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.titleContains(name));

	}

	// METHOD-- 53
	public static void waitWebdriverFrame(String name) {
		WebDriverWait w = new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(name));
		driver.switchTo().frame(name);

	}

	// METHOD-- 54
	public static void waitWebdriverClick(WebElement ele) {
		WebDriverWait w = new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.elementToBeClickable(ele));

	}

	// METHOD-- 55
	public static void waitFluent(String name) {
		FluentWait<WebDriver> f = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(0))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(Throwable.class);
		f.until(ExpectedConditions.titleContains(name));

	}

	// METHOD-- 56
	public static void waitFluentFrame(String name) {
		FluentWait<WebDriver> f = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(0))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(Throwable.class);
		f.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(name));

	}

	// METHOD-- 57
	public static void waitFluentClick(WebElement ele) {
		FluentWait<WebDriver> f = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(0))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(Throwable.class);
		f.until(ExpectedConditions.elementToBeClickable(ele));

	}

	// METHOD-- 58
	public static void selectValue(WebElement ele, String byvalue) {
		Select s = new Select(ele);
		s.selectByValue(byvalue);
	}

	// METHOD-- 59
	public static void selectByText(WebElement ele, String bytext) {
		Select s = new Select(ele);
		s.selectByVisibleText(bytext);

	}

	// METHOD-- 60
	public static void selectByIndex(WebElement ele, int byindex) {
		Select s = new Select(ele);
		s.selectByIndex(byindex);

	}

	// METHOD-- 61
	public static void deSelectValue(WebElement ele, String debyvalue) {
		Select s = new Select(ele);
		s.deselectByValue(debyvalue);
	}

	// METHOD-- 62
	public static void deSelectByText(WebElement ele, String debytext) {
		Select s = new Select(ele);
		s.deselectByVisibleText(debytext);

	}

	// METHOD-- 63
	public static void deSelectByIndex(WebElement ele, int debyindex) {
		Select s = new Select(ele);
		s.deselectByIndex(debyindex);

	}

	// METHOD-- 64
	public static void deSelectByAll() {
		Select s = new Select(ele);
		s.deselectAll();

	}

	// METHOD-- 65
	public static void firstSelectOption() {

		Select s = new Select(ele);
		s.getFirstSelectedOption();
	}

	// METHOD-- 66
	public static void allSelectOption() {
		Select s = new Select(ele);
		List<WebElement> list = s.getAllSelectedOptions();
		for (WebElement we : list) {
			System.out.println(we.getText());

		}
	}

	// METHOD-- 67
	public static void checkMultiSelect() {
		System.out.println(s.isMultiple());

	}

	// METHOD-- 68
	public static void navigateTo(String url) {
		driver.navigate().to(url);

	}

	// METHOD-- 69
	public static void navigateBack() {
		driver.navigate().back();

	}

	// METHOD-- 70
	public static void navigateForward() {
		driver.navigate().forward();

	}

	// METHOD-- 71
	public static void navigateRefresh() {
		driver.navigate().refresh();

	}

	// METHOD-- 72
	public static void displayed(WebElement ele) {
		System.out.println(ele.isDisplayed());

	}

	// METHOD-- 73
	public static void enabled(WebElement ele) {
		System.out.println(ele.isEnabled());

	}

	// METHOD-- 74
	public static void selected(WebElement ele) {
		System.out.println(ele.isSelected());

	}

	// METHOD-- 75
	public static void btnSumit(WebElement ele) {
		ele.submit();

	}

	// METHOD-- 76
	public static void btnClear(WebElement ele) {
		ele.clear();

	}

	// METHOD-- 77
	public static void locatorsId(String val) {
		driver.findElement(By.id(val));

	}

	// METHOD-- 78
	public static void locatorsXpath(String val) {
		driver.findElement(By.xpath(val));

	}
	// METHOD-- 79 To read the data from excel
		public static String getDataExcel(int rowNumber,int columNumber,String path,String sheetName) throws Throwable {
		File f = new File(path);
		FileInputStream fin= new FileInputStream(f);
		Workbook wrkbook= new XSSFWorkbook(fin);
		Sheet sheet = wrkbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNumber);
		Cell cell = row.getCell(columNumber);
		int cellType = cell.getCellType();
		String value="";
		if(cellType==1) {
			value=cell.getStringCellValue();
		}
		else if (DateUtil.isCellDateFormatted(cell)) {
			Date datecel = cell.getDateCellValue();
			SimpleDateFormat sim= new SimpleDateFormat("dd,MMM,YYYY");
			sim.format(datecel);
			
		}
		else {
			double numericValue = cell.getNumericCellValue();
			long lo=(long)numericValue;
			String.valueOf(lo);
		}
		return value;

		}
		// METHOD-- 80 To write the data from excel
		
		public static void writedataExcel(String path,String sheetName,int createRow,int createcell,String cellValue) throws Throwable {
			File f = new File(path);
			boolean create = f.createNewFile();
			Workbook wrkbook= new XSSFWorkbook();
			Sheet creSheet = wrkbook.createSheet(sheetName);
			Row creRow = creSheet.createRow(createRow);
			Cell creCell = creRow.createCell(createcell);
			creCell.setCellValue(cellValue);
			FileOutputStream fout= new FileOutputStream(f);
			 wrkbook.write(fout);
			
			
			
			
			
		}
		


}
