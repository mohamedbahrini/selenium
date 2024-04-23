package com.example.demo.bootstrap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class Init implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(Init.class);

    @Override
    public void run(String... args) throws Exception {
        firstTest();
        eightComponents();
    }

    void firstTest() throws InterruptedException {
        logger.info("tests");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.booking.com/");

        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

        WebElement textBox = driver.findElement(By.name("ss"));

        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("bassasa");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        message.getText();

        logger.info("message.getText(): {}", message.getText());
        driver.quit();
    }

    public void eightComponents() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String title = driver.getTitle();
        logger.info("Web form {}", title);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        String value = message.getText();
        logger.info("Received! {}", value);

        driver.quit();
    }
}
