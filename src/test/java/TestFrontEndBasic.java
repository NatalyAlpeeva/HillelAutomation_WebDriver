import configuration.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.FrontEndBasic;
import static junit.framework.Assert.*;

import java.util.concurrent.TimeUnit;

public class TestFrontEndBasic extends BaseClass {
    static FrontEndBasic frontEndBasic=null;
    @BeforeClass
    public static void startSite() {
        driver.get("https://dnipro.ithillel.ua/courses/front-end-basic");
        frontEndBasic=new FrontEndBasic(driver);
    }
    @Test
    public void getCourseTitle() {
       assertEquals( "Курс",  frontEndBasic.getCourseTitle());
    }
    @Test
    public void getCourseRate() {
        assertEquals("5", frontEndBasic.getCourseRate());
    }
    @Test
    public void getCourseDescription() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        assertEquals("Розробка видимої частини будь-якого сайту називається Front-end, і це область програмування, яка розвивається швидше за інші. Жоден сучасний веб-сайт і веб-додаток не обійдуться без Front-end розробника.\n" +
                "В рамках курсу Front-end Basic студенти без досвіду в розробці вивчають HTML і CSS та вчаться верстати сайти. Після успішного закінчення курсу студенти отримують достатньо знань і навичок для верстки сайту будь-якої складності.\n" +
                "ЦІЛІ КУРСУ\n" +
                "Втілювати в верстку дизайн будь-якої складності\n" +
                "Робити сайти, які однаково добре відображаються на будь-якому пристрої\n" +
                "Помічати важливі дрібниці і писати код, який легко розширювати і підтримувати\n" +
                "Навчитися розуміти структуру веб-сторінок", frontEndBasic.getCourseDescription());
    }

    @Test
    public void getListCoaches() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println(frontEndBasic.getListCoachesNames());
    }
}
