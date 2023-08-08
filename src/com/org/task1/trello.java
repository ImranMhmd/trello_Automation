package com.org.task1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class trello {

	public static void main(String[] args) throws Throwable {

		//property setup
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\hp\\eclipse-workspace\\fullC\\driver\\chromedriver.exe");
		
		//session created
		WebDriver driver = new ChromeDriver();
		
		//url navigation
		driver.get("https://trello.com/en/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(1000);	

	 	
		//credentials to login
	    WebElement username = driver.findElement(By.id("user"));
	    username.sendKeys("");
		Thread.sleep(1000);
	    driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);	
	    WebElement password = driver.findElement(By.id("password"));
	    password.sendKeys("");
		Thread.sleep(1000);
	    driver.findElement(By.id("login-submit")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Login success");

		//board creation
		driver.findElement(By.xpath("//button[@data-testid='header-create-menu-button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Create board']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("newBoard");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Board Created");

		//creating list
		driver.findElement(By.xpath("//span[text()='Add another list']")).click();
		Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@class='list-name-input']")).sendKeys("list A");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@value='Add list']")).click();
	    Thread.sleep(2000);
		System.out.println("List A added");
	    driver.findElement(By.xpath("//input[@class='list-name-input']")).sendKeys("list B");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@value='Add list']")).click();
		System.out.println("List B added");

	    //add a card
	    driver.findElement(By.xpath("(//span[text()='Add a card'])[4]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//textarea[@class='list-card-composer-textarea js-card-title']")).sendKeys("newCard");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@value='Add card']")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//a[@class='icon-lg icon-close dark-hover js-cancel']")).click();
	    Thread.sleep(1000);
		System.out.println("Card added in List A");
	    
	    //drag a card from list A to list B
	    Actions action = new Actions(driver);
	    WebElement card_ListA = driver.findElement(By.xpath("//span[@class='list-card-title js-card-name']"));
	    WebElement card_ListB = driver.findElement(By.xpath("(//div[@class='list-header-target js-editing-target'])[5]"));
	    action.dragAndDrop(card_ListA, card_ListB).build().perform();
	    Thread.sleep(2000);
		System.out.println("Card moved from List A to List B");
	    
	    //X and Y coordinates
	    WebElement card = driver.findElement(By.xpath("//span[@class='list-card-title js-card-name']"));
	    Point point = card.getLocation();
	    System.out.println("X coordinate:" + point.getX());
	    System.out.println("Y coordinate:" + point.getY());
	    
	    //logout
	    driver.findElement(By.xpath("//button[@data-testid='header-member-menu-button']")).click();
	    driver.findElement(By.xpath("//button[@data-testid='account-menu-logout']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.id("logout-submit")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    Thread.sleep(2000);
	    System.out.println("Success");

	    driver.quit();	
	}
}
