import configuration.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class dz13 extends BaseClass {
    static private final String mainURL = "https://ithillel.ua//";

    public static void main(String[] args) throws InterruptedException {
        driver.get(mainURL);
        driver.findElement(By.id("btn-consultation-hero")).click();
        driver.findElement(By.id("input-name-consultation")).sendKeys("Natalia");
        driver.findElement(By.id("input-email-consultation")).sendKeys("username@gmail.com");
        driver.findElement(By.id("input-tel-consultation")).sendKeys("501234567");
        Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[contains(@class,\"socials-input-triggers_btn\") and contains(@data-name, \"tg\")]")).click();
//        driver.findElement(By.xpath("//button[contains(@class,\"socials-input-triggers_btn\") and contains(@data-name, \"tg\")]")).sendKeys("https://t.me/userid");
       driver.findElement(By.id("listbox-btn-input-course-consultation")).click();

        Thread.sleep(3000);
               driver.quit();
            }
        }

