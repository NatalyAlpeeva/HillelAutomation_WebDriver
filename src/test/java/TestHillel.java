import configuration.BaseClass;
import jdk.jshell.execution.Util;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.FrontEnd;
import pages.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestHillel extends BaseClass {
    static FrontEnd frontEnd = new FrontEnd(driver);
     By courses = By.xpath("//li[contains(@class,\"site-nav-menu_item\")]/button[@data-dropdown-trigger=\"coursesMenu\"]"),
            programmingSelect = By.xpath("//button[@data-category=\"programming\"]"),
          //  courseSelect1 = By.xpath("//*[@id=\"coursesMenuMainContent\"]//div[@class=\"subcats-nav\"]//button[@data-value=\"front-end\"]"),
             showAll = By.id("coachesShowAllButton"),
            courseSelect = By.xpath("//div[contains(@class, \"courses-nav\") and contains(@class,\"bg\")]/ul[@class=\"course-list\"]/li[@class=\"course-list_item\"]/a[@href=\"https://ithillel.ua/courses/front-end-basic\"]");

    @BeforeClass
    public static void startSite() {
        driver.get("https://ithillel.ua/");
    }

    @Test
    public void testCoursesSelect() {
        driver.findElement(courses).click();
        driver.findElement(programmingSelect).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
     // driver.findElement(courseSelect1).click();
        driver.findElement(courseSelect).click();
    }

    @Test
    public void showCoachesList() {
        driver.get("https://ithillel.ua/courses/front-end-basic");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Utils.scrollDown(driver, new By.ById("coachesShowAllButton"));
        driver.findElement(showAll).click();
        List<WebElement> webElementList = driver.findElements(By.className("coach-list_item"));
        for (WebElement element : webElementList) {
            System.out.println(element.findElement(By.className("coach-card_name")).getText());
        }
    }
}