package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static configuration.BaseClass.driver;


public class FrontEndBasic {
    static WebDriver frontEndBasic;
    @FindBy(xpath = "//span[@class=\"course-descriptor_course-text\"]")
    WebElement courseTitle;
    @FindBy(xpath = "//span[@class=\"course-rating_average\"]")
    WebElement courseRate;
    @FindBy(xpath = "//div[contains(@class,\"introduction-info_content\") and contains(@class,\"introduction-info-redactor\")]")
    WebElement courseDescription;
    @FindBy(id="coachesShowAllButton")
    WebElement showAll;


    public FrontEndBasic(WebDriver driver) {
        frontEndBasic = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCourseTitle() {
        return courseTitle.getText();
    }


    public String getCourseRate() {
        return courseRate.getText();
    }

    public String getCourseDescription() {
        scrollDown(frontEndBasic, By.id("buyCourseFormTrigger"));
        return courseDescription.getText();
    }

    public List<String> getListCoachesNames() {
        scrollDown(frontEndBasic,By.id("coachesShowAllButton"));
        showAll.click();
        List<String> stringList = new ArrayList<String>();
        List<WebElement> webElementList = driver.findElements(By.className("coach-list_item"));
        for (WebElement element : webElementList) {
           // System.out.println(element.findElement(By.className("coach-card_name")).getText());
            stringList.add(element.findElement(By.className("coach-card_name")).getText());
        }
        return stringList;
    }

//
//    public List<String> webElementToString(List<WebElement> elementList){
//        List<String> stringList = new ArrayList<String>();
//        for (WebElement element : elementList ) {
//            stringList.add(element.getText().toString());
//            System.out.println(element.getText());
//        }
//        for(String s : stringList) {
//            System.out.println("Element of the list into String formate");
//            System.out.println(s);
//        }
//        return stringList;
//    }



    public static void scrollDown(WebDriver driver, By by) {//метод который скролит до элемента
        JavascriptExecutor js = (JavascriptExecutor) driver;

        boolean bool = false;

        while (!bool) {//цикл проверяет есть ли элемент, если не находит скролит до тех пор пока не найдет этот элемент
            try {
                driver.findElement(by);
                bool = true;
            } catch (Exception ignore) {
                js.executeScript("window.scrollBy(0,500)");
            }
        }
    }
}
