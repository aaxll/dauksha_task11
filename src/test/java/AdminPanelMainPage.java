import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

public class AdminPanelMainPage {
    public String adminPanelMainPageTitle(){
        return title();
    }

    public AdminPanelMainPage addNewCoupon(String name, String date, String count){
        $(By.cssSelector("a[href=\"#collapseOne\"]")).click();
        $(By.cssSelector("a[title=\"Coupons\"]")).click();
        $(By.cssSelector("a[href=\"http://open-eshop.stqa.ru/oc-panel/Coupon/create\"]")).click();
        $(By.cssSelector("input[name=\"name\"]")).setValue(name);
        $(By.cssSelector("input[name=\"valid_date\"]")).setValue(date);
        $(By.cssSelector("input[name=\"number_coupons\"]")).setValue(count);
        $(By.cssSelector("button[name=\"submit\"]")).click();
        return  page(AdminPanelMainPage.class);
    }

    public AdminPanelMainPage couponSearch(String name){
        $(By.cssSelector("input[name=\"name\"]")).setValue(name);
        $(By.cssSelector("form[method=\"get\"] button")).click();
        return  page(AdminPanelMainPage.class);
    }

    public AdminPanelMainPage couponDelete(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        $(By.cssSelector("a[href*=\"oc-panel/Coupon/delete\"]")).click();
        $(By.cssSelector("button.confirm")).shouldBe(Condition.visible).click();
        return  page(AdminPanelMainPage.class);
    }

    public AdminPanelMainPage logoutUser(){
        $(By.cssSelector("a[data-toggle=\"dropdown\"] > span.caret")).click();
        $(By.cssSelector("a[href*=\"logout\"]")).click();
        return  page(AdminPanelMainPage.class);
    }
}
