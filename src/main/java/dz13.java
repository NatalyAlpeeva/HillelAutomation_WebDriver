import configuration.BaseClass;
import enums.CourseName;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class dz13 extends BaseClass {
    By inputNameId = By.id("input-name-consultation"),
    inputEmail=By.id("input-email-consultation"),
    inputPhone=By.id("input-tel-consultation"),
    messengerSelect=By.xpath("//button[contains(@class,\"socials-input-triggers_btn\") and contains(@data-name,\"tg\")]");


    @BeforeClass
    public static void startSite() {
        driver.get("https://ithillel.ua//");
        driver.findElement(By.id("btn-consultation-hero")).click();
    }
    @Test
    public void testNameField() {
        WebElement inputElement = driver.findElement(inputNameId);
        inputElement.sendKeys("Natalia");
    }
    @Test
    public void testEmailField() {
        WebElement inputElement = driver.findElement(inputEmail);
        inputElement.sendKeys("user@gmail.com");
    }
    @Test
    public void testPhoneField() {
        WebElement inputElement = driver.findElement(inputPhone);
        inputElement.sendKeys("503456789");
    }
    @Test
    public void testMessengerSelect() {
        WebElement inputElement = driver.findElement(messengerSelect);
        inputElement.click();
        driver.findElement(By.name("tg")).sendKeys("https://t.me/userid");
    }
    @Test
    public void testCourseSelected() throws InterruptedException{
       selectCourseName(CourseName.QA_Manual);
    }

    private void selectCourseName(CourseName courseName) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("listbox-btn-input-course-consultation")).click();
        WebElement element = driver.findElement(By.xpath("//ul[contains(@class,\"listbox_opt-list\") and contains(@role,\"listbox\")]"));
        List<WebElement> list = element.findElements(By.tagName("li"));
        for (WebElement webElement : list) {
            if (webElement.findElement(By.tagName("span")).getText().equals(courseName.toString())) {
                webElement.findElement(By.tagName("span")).click();
            }
        }
    }
}

