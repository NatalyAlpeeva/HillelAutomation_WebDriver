package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FrontEnd {
    WebDriver driver;

    public FrontEnd(WebDriver driver) {
        this.driver = driver;
    }

    By coachList = By.xpath("//ul[contains(@class, \"coach-list\") and contains(@class, \"coaches_list\")]"),
            showAllCoach = By.id("#coachesShowAllButton");

    public List<String> getListNames() {
        List<String> list = new ArrayList<>();
        driver.findElement(showAllCoach).click();
        for (WebElement element : driver.findElements(coachList)) {
            list.add(element.getText());
        }
        return list;
    }

}
